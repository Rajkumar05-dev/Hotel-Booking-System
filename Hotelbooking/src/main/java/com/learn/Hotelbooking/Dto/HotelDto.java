package com.learn.Hotelbooking.Dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
	    private Long id;
		private  String name;
		private String location;
		private String description;
		private BigDecimal rating;
		private String contactNumber;
		private String email;
}
