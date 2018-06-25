package br.com.uff.internships;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.uff.internships.entity.Student;
import br.com.uff.internships.repository.StudentRepository;
import br.com.uff.internships.repository.UserRepository;

@SpringBootApplication
public class InternshipsApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(InternshipsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		List<Student> users = studentRepository.getAll();
		
		for (Student user : users) {

			System.out.println(user.toString());
		}
		
	}
}
