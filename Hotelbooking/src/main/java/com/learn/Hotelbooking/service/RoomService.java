package com.learn.Hotelbooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learn.Hotelbooking.Dto.RoomDto;
import com.learn.Hotelbooking.Entities.*;
import com.learn.Hotelbooking.repository.HotelRepository;
import com.learn.Hotelbooking.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public RoomDto saveRoom(RoomDto roomDto) {
        Hotel hotel = hotelRepository.findById(roomDto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Room room = new Room();
        room.setHotel(hotel);
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setRoomType(RoomType.valueOf(roomDto.getRoomType().toUpperCase()));
        room.setPricePerNight(roomDto.getPricePerNight());
        room.setStatus(RoomStatus.valueOf(roomDto.getStatus().toUpperCase()));

        roomRepository.save(room);
        return mapToDto(room);
    }

    public List<Room> getRoomsByHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        return roomRepository.findByHotel(hotel);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    private RoomDto mapToDto(Room room) {
        return new RoomDto(room.getId(),
                room.getHotel().getId(),
                room.getRoomNumber(),
                room.getRoomType().name(),
                room.getPricePerNight(),
                room.getStatus().name());
    }
}
