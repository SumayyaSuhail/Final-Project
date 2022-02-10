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

    public List<RoomType> getAllTypes() {
        return repository.findAll();
    }

    public RoomType getById(Long roomTypeId) {
        return repository.getById(roomTypeId);
    }

    public void saveRoomType(RoomType addedType) {
        repository.save(addedType);
    }
}
