package com.learn.Hotelbooking.Entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
 @Column(nullable=false,length = 100)
	private  String name;
 @Column(nullable=false)
	private String location;
 @Column(nullable = false)
	private String description;
 @Column(nullable=false)
	private BigDecimal rating;
 @Column(nullable=false)
	private String contactNumber;
 @Column(nullable=false)
	private String email;
	
}
