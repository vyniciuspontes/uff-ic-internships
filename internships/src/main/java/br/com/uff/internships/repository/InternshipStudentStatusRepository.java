package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.InternshipStudentStatus;

@Repository
public class InternshipStudentStatusRepository extends AbstractDAOImpl<InternshipStudentStatus>{
	
	public InternshipStudentStatusRepository() {
		super(InternshipStudentStatus.class);
	}
	
	public List<InternshipStudentStatus> findLastStatusByInternship(Integer internshipId){
		
		String query = "select iss from InternshipStudentStatus iss \n" + 
				"	join iss.internshipStudent as ist \n"
				+ "where ist.internship.id=:internshipId and iss.datetime = (select max(isss.datetime) from InternshipStudentStatus isss "
				+ "where isss.internshipStudent.student.id = iss.internshipStudent.student.id "
				+ "and isss.internshipStudent.internship.id = iss.internshipStudent.internship.id)";
		
		return entityManager.createQuery(query, InternshipStudentStatus.class).setParameter("internshipId", internshipId ).getResultList();
	}
}
