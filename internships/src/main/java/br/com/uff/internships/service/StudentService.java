package br.com.uff.internships.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uff.internships.entity.City;
import br.com.uff.internships.entity.Experience;
import br.com.uff.internships.entity.Student;
import br.com.uff.internships.entity.StudentForeignLanguage;
import br.com.uff.internships.entity.StudentForeignLanguagePK;
import br.com.uff.internships.entity.StudentSkill;
import br.com.uff.internships.entity.StudentSkillPK;
import br.com.uff.internships.form.RegistrationStudentForm;
import br.com.uff.internships.repository.ExperienceRepository;
import br.com.uff.internships.repository.StudentForeignLanguageRepository;
import br.com.uff.internships.repository.StudentRepository;
import br.com.uff.internships.repository.StudentSkillRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentForeignLanguageRepository studentForeignLanguageRepository;

	@Autowired
	private StudentSkillRepository studentSkillRepository;

	@Autowired
	private ExperienceRepository experienceRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public void saveNewStudent(RegistrationStudentForm form) {

		Student newStudent = new Student();
		
		String encryptedPassword = bCryptPasswordEncoder.encode(form.getPassword());
		
		newStudent.setName(form.getName());
		newStudent.setBornDate(form.getBornDate());
		newStudent.setComplement(form.getComplement());
		newStudent.setEmail(form.getEmail());
		newStudent.setEnrollmentCode(form.getEnrollmentCode());
		newStudent.setCity(new City(form.getCityId()));
		newStudent.setAddress(form.getAddress());
		newStudent.setPassword(encryptedPassword);
		newStudent.setResume(form.getResume());

		studentRepository.create(newStudent);

		Experience newExperience = new Experience();

		newExperience.setTitle(form.getExperienceTitle());
		newExperience.setDescription(form.getExperienceDescription());
		newExperience.setStartDate(form.getExperienceStartDate());
		newExperience.setEndDate(form.getExperienceEndDate());
		newExperience.setStudent(newStudent);

		experienceRepository.create(newExperience);

		for (Map.Entry<Integer, Integer> entry : form.getForeignLanguageLevel().entrySet()) {

			StudentForeignLanguage newStudentForeignLanguage = new StudentForeignLanguage();
			newStudentForeignLanguage
					.setId(new StudentForeignLanguagePK(newStudent.getId(), entry.getKey().intValue()));
			newStudentForeignLanguage.setLevel(entry.getValue().toString());

			studentForeignLanguageRepository.create(newStudentForeignLanguage);

		}

		for (Map.Entry<Integer, Integer> entry : form.getSkillLevel().entrySet()) {

			StudentSkill newStudentSkill = new StudentSkill();
			newStudentSkill.setId(new StudentSkillPK(newStudent.getId(), entry.getKey().intValue()));
			newStudentSkill.setLevel(entry.getValue().toString());

			studentSkillRepository.create(newStudentSkill);

		}

	}

}
