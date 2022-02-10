package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("Select room from Room room where room.roomNumber=:roomNumber and room.roomType=:name")
    Room findRoomByNumberAndType(Integer roomNumber, String name);
}
