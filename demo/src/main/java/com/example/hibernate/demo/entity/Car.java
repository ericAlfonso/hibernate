package com.example.hibernate.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
    @Column(name = "plate", nullable = false)
    private String plate;
    
    @Column(name = "model", nullable = false)
    private String model;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "size")
    private Integer size;
    
    @Column(name = "yr", nullable = false)
    private int year;

	public Car(final String plate, final String model, 
			final String color, final int size, final int year) {
		this.plate = plate;
		this.model = model;
		this.color = color;
		this.size = size;
		this.year = year;
	}
    
}
