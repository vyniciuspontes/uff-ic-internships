package br.com.uff.internships.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uff.internships.entity.City;

@Repository
public class CityRepository extends AbstractDAOImpl<City>{
	
	public CityRepository() {
		super(City.class);
	}

	public List<City> getAll() {
		return this.entityManager.createQuery("select e from City e", City.class).getResultList();
	}
}
