package br.com.uff.internships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uff.internships.entity.User;
import br.com.uff.internships.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
