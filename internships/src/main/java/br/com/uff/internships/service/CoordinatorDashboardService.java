package br.com.uff.internships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uff.internships.entity.User;
import br.com.uff.internships.repository.UserRepository;

@Service
public class CoordinatorDashboardService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAllNonValidatedUsers() {

		return this.userRepository.findByValidation(false);
	}

	@Transactional
	public void validateUser(Integer userId) {

		User user = userRepository.find(userId);
		user.setValidated(true);
		userRepository.update(user);
	}

}
