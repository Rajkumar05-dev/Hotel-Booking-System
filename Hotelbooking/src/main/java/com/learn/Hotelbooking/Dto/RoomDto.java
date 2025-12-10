package com.learn.Hotelbooking.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

	private Long id;
	@Column(name = "hotel_id")
	private Long hotelId;
	private String roomNumber;
	private String roomType;// enum type
	private Double pricePerNight;
	private String status;//enum status
	
}
