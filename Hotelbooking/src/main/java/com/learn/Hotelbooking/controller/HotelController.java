package com.learn.Hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Hotelbooking.Dto.HotelDto;
import com.learn.Hotelbooking.service.HotelService;
@RestController
@RequestMapping("/hotels") 
@CrossOrigin(origins="http://localhost:5173/")
public class HotelController {
	@Autowired
 private HotelService hotelService;
	@PostMapping
	public ResponseEntity<HotelDto> addHotel(@RequestBody HotelDto hotelDto){
	HotelDto hotel=hotelService.addHotel(hotelDto);
	return new ResponseEntity<HotelDto> (hotel,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<HotelDto>> getHotel(){
		List<HotelDto> allHotel=hotelService.getAllHotels();
		return new ResponseEntity<List<HotelDto>>(allHotel,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelDto> getHotelById(@PathVariable int id){
		HotelDto hotelDto=hotelService.getHotelById(id);
		return new ResponseEntity<HotelDto> (hotelDto,HttpStatus.FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<HotelDto> updateHotel(@PathVariable int id,@RequestBody HotelDto hotelDto){
		HotelDto updateHotel=hotelService.updatedHotel(id, hotelDto);
	return new ResponseEntity<HotelDto>(updateHotel,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable int id){
		hotelService.deletById(id);
		return new ResponseEntity<String>("Hotel deleted ",HttpStatus.OK); 
	}
}
