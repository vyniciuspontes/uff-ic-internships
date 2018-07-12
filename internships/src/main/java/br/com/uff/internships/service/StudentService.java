package br.com.uff.internships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uff.internships.entity.StudentSkill;
import br.com.uff.internships.entity.User;
import br.com.uff.internships.form.RegistrationStudentForm;
import br.com.uff.internships.repository.StudentForeignLanguageRepository;
import br.com.uff.internships.repository.StudentRepository;
import br.com.uff.internships.repository.UserRepository;

@Service
public class StudentService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentForeignLanguageRepository studentForeignLanguageRepository;
	
	@Autowired
	private StudentSkill studentSkill;
	
	public void saveNewStudent(RegistrationStudentForm form) {
		
		User newUser = new User();
		
	}
	
}
