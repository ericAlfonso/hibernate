package com.example.hibernate.demo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public class AbstractHibernateDAO<T extends Serializable, KeyType extends Serializable> implements AbstractHibernate<T, KeyType>{
	private Class<T> clazz;
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	public AbstractHibernateDAO() {
		if(getClass().getGenericSuperclass() instanceof Class) {
			this.clazz = (Class<T>) getClass().getGenericSuperclass();
		}
		
		else if(getClass().getGenericSuperclass() instanceof ParameterizedType) {
			this.clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}
	
	
	
	public Class<T> getClazz() {
		return clazz;
	}



	public EntityManager getEntityManager() {
		return entityManager;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}
	
	public T findOne(final KeyType id){
		return entityManager.find(getClazz(), id);
	}
	
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public T update(T entity) {
		return (T) entityManager.merge(entity);
	}
	
	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	public void deleteById(KeyType id) {
		final T entity = findOne(id);
		delete(entity);
	}

}
