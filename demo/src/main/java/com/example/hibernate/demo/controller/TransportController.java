package com.example.hibernate.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.demo.dto.CarDTO;
import com.example.hibernate.demo.service.CarService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/transport")
@CrossOrigin
public class TransportController {
	
	@Autowired
	private CarService carService;

	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> getCarById(@PathVariable(name = "id") final int id) {
		log.info("{}", carService.getCarById(id));
		return ResponseEntity.ok(carService.getCarById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<CarDTO>> getAllCars(){
		return ResponseEntity.ok(carService.getAllCars());
	}
}
