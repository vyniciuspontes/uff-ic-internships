package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.Experience;

@Repository
public class ExperienceRepository extends AbstractDAOImpl<Experience>{
	
	public ExperienceRepository() {
		super(Experience.class);
	}

	public List<Experience> getAll() {
		return this.entityManager.createNamedQuery("Experience.findAll", Experience.class).getResultList();
	}
}
