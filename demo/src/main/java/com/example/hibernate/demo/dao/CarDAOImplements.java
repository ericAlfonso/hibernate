package com.example.hibernate.demo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.example.hibernate.demo.entity.Car;

@Repository
public class CarDAOImplements extends AbstractHibernateDAO<Car, Integer> implements CarDAO{

	@Override
	@Nullable
	public List<Car> getAllCars() {
		final CriteriaBuilder builder = getCriteriaBuilder();
		final CriteriaQuery<Car> criteriaQuery = builder.createQuery(getClazz());
		final Root<Car> root = criteriaQuery.from(getClazz());
		
		criteriaQuery
			.select(root)
			.where();
		
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}


}
