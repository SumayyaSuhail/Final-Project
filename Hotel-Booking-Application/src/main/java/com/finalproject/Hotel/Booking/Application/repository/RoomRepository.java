package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long> {

    /**
     * Method to find the room by room number and type from database
     * @param roomNumber
     * @param roomType
     * @return
     */

    @Query("Select room from Room room where room.roomNumber=:roomNumber and room.roomType=:roomType")
    Room findRoomByRoomNumberAndRoomType(@Param("roomNumber") Integer roomNumber, @Param("roomType") String roomType);
}
