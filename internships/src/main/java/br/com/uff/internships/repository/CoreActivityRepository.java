package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.CoreActivity;

@Repository
public class CoreActivityRepository extends AbstractDAOImpl<CoreActivity>{
	
	public CoreActivityRepository() {
		super(CoreActivity.class);
	}

	public List<CoreActivity> getAll() {
		return this.entityManager.createNamedQuery("CoreActivity.findAll", CoreActivity.class).getResultList();
	}
}
