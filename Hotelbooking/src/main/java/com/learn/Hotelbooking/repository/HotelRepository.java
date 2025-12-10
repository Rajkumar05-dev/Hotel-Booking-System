package com.learn.Hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Hotelbooking.Entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
