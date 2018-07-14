package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.InternshipStudentStatus;

@Repository
public class InternshipStudentStatusRepository extends AbstractDAOImpl<InternshipStudentStatus>{
	
	public InternshipStudentStatusRepository() {
		super(InternshipStudentStatus.class);
	}
}
