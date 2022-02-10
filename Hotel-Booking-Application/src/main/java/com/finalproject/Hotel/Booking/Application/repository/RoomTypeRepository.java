package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    RoomType findByName(String roomType);
}
