package com.example.hibernate.demo.dao;

import java.util.List;

import com.example.hibernate.demo.entity.Car;

public interface CarDAO extends AbstractHibernate<Car, Integer>{

	List<Car> getAllCars();
}
