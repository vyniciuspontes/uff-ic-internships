package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.ForeignLanguage;
import br.com.uff.internships.entity.Skill;

@Repository
public class SkillRepository extends AbstractDAOImpl<Skill>{
	
	public SkillRepository() {
		super(Skill.class);
	}

	public List<Skill> getAll() {
		return this.entityManager.createNamedQuery("Skill.findAll", Skill.class).getResultList();
	}
}
