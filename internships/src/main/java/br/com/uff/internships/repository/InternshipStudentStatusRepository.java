package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.InternshipStudentStatus;

@Repository
public class InternshipStudentStatusRepository extends AbstractDAOImpl<InternshipStudentStatus> {

	public InternshipStudentStatusRepository() {
		super(InternshipStudentStatus.class);
	}

	public List<InternshipStudentStatus> findByStatus(String status) {

		String query = "select iss from InternshipStudentStatus iss " + " join fetch iss.internshipStudent"
				+ " where iss.status=:status";

		return entityManager.createQuery(query, InternshipStudentStatus.class).setParameter("status", status)
				.getResultList();
	}

	public List<InternshipStudentStatus> findLastStatusByInternship(Integer internshipId) {

		String query = "select iss from InternshipStudentStatus iss \n" 
				+ "	join fetch iss.internshipStudent as ist "
				+ " join fetch ist.internship itn"
				+ "	join fetch itn.company "
				+ " join fetch ist.student as std "
				+ " where ist.internship.id=:internshipId and iss.datetime = (select max(isss.datetime) from InternshipStudentStatus isss "
				+ " join isss.internshipStudent as ists "
				+ " where ists.student.id=ist.student.id and ists.internship.id = ist.internship.id)";

		return entityManager.createQuery(query, InternshipStudentStatus.class)
				.setParameter("internshipId", internshipId).getResultList();
	}

	public List<InternshipStudentStatus> findLastStatusByStatus(String status) {

		String query = "select iss from InternshipStudentStatus iss join iss.internshipStudent as ist \n"
				+ "where iss.status=:status and iss.datetime = (select max(isss.datetime) from InternshipStudentStatus isss "
				+ "join isss.internshipStudent as ists "
				+ "where ists.student.id=ist.student.id and ists.internship.id = ist.internship.id)";

		return entityManager.createQuery(query, InternshipStudentStatus.class)
				.setParameter("status", status).getResultList();
	}
}
