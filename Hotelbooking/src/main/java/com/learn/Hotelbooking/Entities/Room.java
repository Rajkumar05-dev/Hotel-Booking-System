package com.learn.Hotelbooking.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	private String roomNumber;
	@Enumerated(EnumType.STRING)
	private RoomType roomType;
	private Double pricePerNight;
	@Enumerated(EnumType.STRING)
	private RoomStatus status=RoomStatus.AVAILABLE;
	
}
