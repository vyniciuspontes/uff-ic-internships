package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.Student;

@Repository
public class StudentRepository extends AbstractDAOImpl<Student> {

	public StudentRepository() {
		super(Student.class);
	}

	public List<Student> getAll() {
		return this.entityManager.createQuery("select e from Student e", Student.class).getResultList();
	}

	public List<Student> findByInternship(Integer internshipId) {

		return this.entityManager
				.createQuery("select s from Student s join InternshipStudent ist "
						+ "on s.id = ist.id.studentId where ist.id.internshipId=:internshipId", Student.class)
				.setParameter("internshipId", internshipId).getResultList();
	}
}
