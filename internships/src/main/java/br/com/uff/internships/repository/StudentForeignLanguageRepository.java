package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.StudentForeignLanguage;

@Repository
public class StudentForeignLanguageRepository extends AbstractDAOImpl<StudentForeignLanguage>{

	public StudentForeignLanguageRepository() {
		super(StudentForeignLanguage.class);
	}

	public List<StudentForeignLanguage> getAll() {
		return this.entityManager.createQuery("select e from StudentForeignLanguage e", StudentForeignLanguage.class).getResultList();
	}
}
