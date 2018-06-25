package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.User;

@Repository
public class UserRepository extends AbstractDAOImpl<User>{

	public UserRepository() {
		super(User.class);
	}

	public List<User> getAll() {
		return this.entityManager.createQuery("select e from User e", User.class).getResultList();
	}

	public User findByEmail(String email) {
		List<User> resultList = this.entityManager.createNamedQuery("User.findByEmail", User.class).setParameter(0, email).getResultList();
		
		if (resultList == null || resultList.isEmpty())
			return null;
		
		return resultList.get(0);
	}
}
