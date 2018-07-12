package br.com.uff.internships.service;

import org.springframework.stereotype.Service;

import br.com.uff.internships.form.RegistrationStudentForm;
import br.com.uff.internships.repository.ForeignLanguageRepository;
import br.com.uff.internships.repository.StudentRepository;
import br.com.uff.internships.repository.UserRepository;

@Service
public class StudentService {
	
	private UserRepository userRepository;
	
	private StudentRepository studentRepository;
	
	private ForeignLanguageRepository foreignLanguageRepository;
	
	public void saveNewStudent(RegistrationStudentForm form) {
		
		
		
	}
	
}
