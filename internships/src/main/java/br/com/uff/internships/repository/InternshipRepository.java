package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.Internship;

@Repository
public class InternshipRepository extends AbstractDAOImpl<Internship> {

	public InternshipRepository() {
		super(Internship.class);
	}

	public List<Internship> getAll() {
		return this.entityManager.createQuery("select e from Internship e", Internship.class).getResultList();
	}

	public List<Internship> findByStudent(Integer studentId) {

		return this.entityManager
				.createQuery("select i from Internship i join InternshipStudent ist "
						+ "on ist.id.internshipId = i.id where ist.id.studentId=:studentId", Internship.class)
				.setParameter("studentId", studentId).getResultList();
	}

	public List<Internship> findByCompany(Integer companyId) {

		return this.entityManager
				.createQuery("select i from Internship i where i.company.id=:companyId", Internship.class)
				.setParameter("companyId", companyId).getResultList();
	}

	public List<Internship> findAllApplicableInternships(Integer studentId) {

		String query = "select i from Internship i "
				+ "left join InternshipStudent ist on i.id = ist.id.internshipId and ist.id.studentId=:studentId "
				+ "where ist.id.internshipId is null";

		return this.entityManager.createQuery(query, Internship.class).setParameter("studentId", studentId)
				.getResultList();

	}
}
