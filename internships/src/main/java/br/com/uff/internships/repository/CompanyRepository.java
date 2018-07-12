package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.Company;

@Repository
public class CompanyRepository extends AbstractDAOImpl<Company>{

	public CompanyRepository() {
		super(Company.class);
	}

	public List<Company> getAll() {
		return this.entityManager.createQuery("select e from Company e", Company.class).getResultList();
	}
}
