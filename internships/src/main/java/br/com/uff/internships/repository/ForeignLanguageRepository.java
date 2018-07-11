package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.ForeignLanguage;

@Repository
public class ForeignLanguageRepository extends AbstractDAOImpl<ForeignLanguage>{
	
	public ForeignLanguageRepository() {
		super(ForeignLanguage.class);
	}

	public List<ForeignLanguage> getAll() {
		return this.entityManager.createNamedQuery("ForeignLanguage.findAll", ForeignLanguage.class).getResultList();
	}
}
