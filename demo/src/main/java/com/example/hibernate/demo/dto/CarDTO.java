package com.example.hibernate.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDTO {

	private int id;
    private String plate;
    private String model;
    private String color;
    private Integer size;
    private int year;
}
