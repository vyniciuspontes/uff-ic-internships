package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.InternshipStudent;

@Repository
public class InternshipStudentRepository extends AbstractDAOImpl<InternshipStudent>{
	
	public InternshipStudentRepository() {
		super(InternshipStudent.class);
	}

	public List<InternshipStudent> getAll() {
		return this.entityManager.createQuery("select e from InternshipStudent e", InternshipStudent.class).getResultList();
	}
}
