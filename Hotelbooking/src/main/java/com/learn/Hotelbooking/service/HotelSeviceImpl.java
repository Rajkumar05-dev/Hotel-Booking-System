package com.learn.Hotelbooking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Hotelbooking.Dto.HotelDto;
import com.learn.Hotelbooking.Entities.Hotel;
import com.learn.Hotelbooking.repository.HotelRepository;

@Service
public class HotelSeviceImpl implements HotelService{
	@Autowired
 private ModelMapper modelMapper;
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public HotelDto addHotel(HotelDto hotelDto) {
		Hotel hotel =modelMapper.map(hotelDto,Hotel.class);
		Hotel savedHotel=hotelRepository.save(hotel);
		HotelDto saveDto=modelMapper.map(savedHotel,HotelDto.class);
		return saveDto;
	}
	@Override
	public List<HotelDto> getAllHotels() {
	List<Hotel> hotel=hotelRepository.findAll();
	List<HotelDto> hotelDtoList=hotel
			.stream()
		.map(p->modelMapper.map(p, HotelDto.class))
		.toList();
		return hotelDtoList;
	}
	@Override
	public HotelDto getHotelById(int id) {
		Hotel hotel=hotelRepository.findById((long) id)
				.orElseThrow(()->new RuntimeException("ID not found"));
		HotelDto hotelDto=modelMapper.map(hotel,HotelDto.class);
		
		return hotelDto;
	}
	@Override
	public HotelDto updatedHotel(int id, HotelDto hotelDto) {
	Hotel hotel=hotelRepository.findById((long) id)
			.orElseThrow(()->new RuntimeException("Not found"));
	hotel.setName(hotelDto.getName());
	hotel.setDescription(hotelDto.getDescription());
	Hotel updateHotel=hotelRepository.save(hotel);
	HotelDto dto=modelMapper.map(updateHotel,HotelDto.class);
	return dto;
		
	}
	@Override
	public void deletById(int id) {
	Hotel hotel=hotelRepository.findById((long) id)
			.orElseThrow(()-> new RuntimeException(" Id Not found "));
	hotelRepository.delete(hotel);
		
	}
}
