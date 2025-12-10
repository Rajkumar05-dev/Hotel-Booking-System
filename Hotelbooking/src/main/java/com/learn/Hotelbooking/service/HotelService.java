package com.learn.Hotelbooking.service;

import java.util.List;


import com.learn.Hotelbooking.Dto.HotelDto;

public interface HotelService {
HotelDto addHotel(HotelDto hotelDto);
List<HotelDto>getAllHotels();
HotelDto getHotelById(int id);
HotelDto updatedHotel(int id,HotelDto hotelDto);
void deletById(int id);
}
