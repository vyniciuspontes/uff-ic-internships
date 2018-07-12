package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.StudentSkill;

@Repository
public class StudentSkillRepository extends AbstractDAOImpl<StudentSkill>{

	public StudentSkillRepository() {
		super(StudentSkill.class);
	}

	public List<StudentSkill> getAll() {
		return this.entityManager.createQuery("select e from StudentSkill e", StudentSkill.class).getResultList();
	}
}
