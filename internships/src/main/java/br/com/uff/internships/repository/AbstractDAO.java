package br.com.uff.internships.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractDAO<T> {
	
	public void create(T entity);
	public T find(Long id);
	public void update(T entity);
	public void remove (T entity);
}
