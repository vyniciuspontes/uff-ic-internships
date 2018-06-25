package br.com.uff.internships.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author vyniciuspontes
 */
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T>{

	@Autowired
	protected EntityManager entityManager;
	
	public Class<T> entityClass;

    public AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
    		entityManager.persist(entity);
    }
    
    @Override
    public void update(T entity) {
    		entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
    		entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public T find(Long id) {
        return entityManager.find(entityClass, id);
    }
}
