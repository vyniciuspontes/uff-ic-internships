package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.Internship;

@Repository
public class InternshipRepository extends AbstractDAOImpl<Internship>{
	
	public InternshipRepository() {
		super(Internship.class);
	}

	public List<Internship> getAll() {
		return this.entityManager.createQuery("select e from Internship e", Internship.class).getResultList();
	}
}
