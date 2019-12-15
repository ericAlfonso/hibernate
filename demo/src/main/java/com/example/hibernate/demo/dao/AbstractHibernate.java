package com.example.hibernate.demo.dao;

public interface AbstractHibernate<DomainObject, KeyType> {

	public DomainObject findOne(KeyType id);
	public void save(DomainObject entity);
	public DomainObject update(DomainObject entity);
	public void delete(DomainObject entity);
	public void deleteById(KeyType id);
}
