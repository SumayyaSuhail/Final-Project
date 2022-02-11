package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Room;
import com.finalproject.Hotel.Booking.Application.entity.RoomType;
import com.finalproject.Hotel.Booking.Application.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository repository;

    /**
     * Method to return all types of room type
     *
     * @return List of RoomType
     */
    public List<RoomType> getAllTypes() {
        return repository.findAll();
    }

    /**
     * Method to find type By type name
     *
     * @param roomType
     * @return RoomType
     */
    public RoomType getByName(String roomType) {
        return repository.findByName(roomType);
    }

    /**
     * Method to save a new type of room
     *
     * @param addedType
     */
    public void saveRoomType(RoomType addedType) {
        repository.save(addedType);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
