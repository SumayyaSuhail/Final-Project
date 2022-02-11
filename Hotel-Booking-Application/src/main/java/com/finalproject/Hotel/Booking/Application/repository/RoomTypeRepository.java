package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    /**
     * Method to find room by the type of room passed as parameter
     * @param roomType
     * @return RoomType
     */
    RoomType findByName(String roomType);
}
