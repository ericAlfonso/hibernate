package com.example.hibernate.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.demo.dao.CarDAO;
import com.example.hibernate.demo.dto.CarDTO;
import com.example.hibernate.demo.entity.Car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CarService {
	
	@Autowired
	private CarDAO carDAO;

	public CarDTO getCarById(final int id) {
		Car car = carDAO.findOne(id);
		log.info("Resukt" + car.getId());
		return populateCarDTO(car);
	}
	
	private CarDTO populateCarDTO(Car car) {
		return CarDTO.builder()
				.id(car.getId())
				.color(car.getColor())
				.model(car.getModel())
				.plate(car.getPlate())
				.build();
	}
	
	public List<CarDTO> getAllCars(){
		return carDAO.getAllCars().stream().map(this::populateCarDTO).collect(Collectors.toList());
	}
}
