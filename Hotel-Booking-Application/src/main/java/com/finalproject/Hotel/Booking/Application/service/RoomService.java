package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Message;
import com.finalproject.Hotel.Booking.Application.entity.Room;
import com.finalproject.Hotel.Booking.Application.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    /**
     * Method to save a new room
     *
     * @param room
     */
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    /**
     * Method to list all rooms
     *
     * @return List of Room
     */
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    /**
     * Method to find room By Room id
     *
     * @param id
     * @return Room
     */
    public Room getRoomById(Long id) {
        return roomRepository.getById(id);
    }

    /**
     * Method to delete a room
     *
     * @param roomId
     */
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    /**
     * Method to find a room by room number and type
     *
     * @param roomNumber
     * @param name
     * @return Room
     */
    public Room getRoomByNumberAndType(Integer roomNumber, String name) {
        return roomRepository.findRoomByNumberAndType(roomNumber, name);
    }
}
