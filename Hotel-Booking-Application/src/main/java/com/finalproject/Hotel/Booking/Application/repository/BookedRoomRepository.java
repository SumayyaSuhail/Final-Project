package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.BookedRoom;
import com.finalproject.Hotel.Booking.Application.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.net.Inet4Address;

public interface BookedRoomRepository extends JpaRepository<BookedRoom, Long> {

    @Query("Select room from BookedRoom room where room.roomNumber=:roomNumber and room.roomType=:roomType")
    BookedRoom findBookedRoomByRoomNumberAndRoomType(Integer roomNumber, String roomType);
}
