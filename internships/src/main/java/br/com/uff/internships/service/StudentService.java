package br.com.uff.internships.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uff.internships.entity.City;
import br.com.uff.internships.entity.Experience;
import br.com.uff.internships.entity.Internship;
import br.com.uff.internships.entity.InternshipStudent;
import br.com.uff.internships.entity.InternshipStudentPK;
import br.com.uff.internships.entity.InternshipStudentStatus;
import br.com.uff.internships.entity.Student;
import br.com.uff.internships.entity.StudentForeignLanguage;
import br.com.uff.internships.entity.StudentForeignLanguagePK;
import br.com.uff.internships.entity.StudentSkill;
import br.com.uff.internships.entity.StudentSkillPK;
import br.com.uff.internships.form.StudentRegistrationForm;
import br.com.uff.internships.repository.ExperienceRepository;
import br.com.uff.internships.repository.InternshipRepository;
import br.com.uff.internships.repository.InternshipStudentRepository;
import br.com.uff.internships.repository.InternshipStudentStatusRepository;
import br.com.uff.internships.repository.StudentForeignLanguageRepository;
import br.com.uff.internships.repository.StudentRepository;
import br.com.uff.internships.repository.StudentSkillRepository;
import br.com.uff.internships.repository.UserRepository;

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
	private UserRepository userRepository;

	@Autowired
	private InternshipStudentRepository internshipStudentRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private InternshipRepository internshipRepository;
	
	@Autowired
	private InternshipStudentStatusRepository internshipStudentStatusRepository;

	@Transactional
	public void saveNewStudent(StudentRegistrationForm form) {

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
		newStudent.setValidated(false);

		studentRepository.create(newStudent);

		Experience newExperience = new Experience();

		newExperience.setTitle(form.getExperienceTitle());
		newExperience.setDescription(form.getExperienceDescription());
		newExperience.setStartDate(form.getExperienceStartDate());
		newExperience.setEndDate(form.getExperienceEndDate());
		newExperience.setStudent(newStudent);

		experienceRepository.create(newExperience);

		for (Map.Entry<Integer, Integer> entry : form.getForeignLanguageLevel().entrySet()) {

			String level = entry.getValue() != null ? entry.getValue().toString() : "0";

			StudentForeignLanguage newStudentForeignLanguage = new StudentForeignLanguage();
			newStudentForeignLanguage
					.setId(new StudentForeignLanguagePK(newStudent.getId(), entry.getKey().intValue()));
			newStudentForeignLanguage.setLevel(level);

			studentForeignLanguageRepository.create(newStudentForeignLanguage);

		}

		for (Map.Entry<Integer, Integer> entry : form.getSkillLevel().entrySet()) {

			String level = entry.getValue() != null ? entry.getValue().toString() : "0";

			StudentSkill newStudentSkill = new StudentSkill();
			newStudentSkill.setId(new StudentSkillPK(newStudent.getId(), entry.getKey().intValue()));
			newStudentSkill.setLevel(level);

			studentSkillRepository.create(newStudentSkill);

		}

	}

	public List<Internship> findAllAppliableInternships(String studentEmail) {

		Student student = (Student) this.userRepository.findByEmail(studentEmail);

		return this.internshipRepository.findAllApplicableInternships(student.getId());
	}
	
	public List<Internship> findAllStudentInternships(String studentEmail) {

		Student student = (Student) this.userRepository.findByEmail(studentEmail);

		return this.internshipRepository.findByStudent(student.getId());
	}

	@Transactional
	public void applyForInternship(Integer internshipId, String studentEmail) {

		Student student = (Student) this.userRepository.findByEmail(studentEmail);

		InternshipStudent newInternshipStudent = new InternshipStudent(
				new InternshipStudentPK(internshipId, student.getId()));

		internshipStudentRepository.create(newInternshipStudent);

		InternshipStudentStatus status = new InternshipStudentStatus();
		
		status.setStatus(InternshipStudentStatus.Status.PROFILE_ANALYSIS.name());
		status.setDatetime(new Date());
		status.setInternshipStudent(newInternshipStudent);
		internshipStudentStatusRepository.create(status);

	}
}
