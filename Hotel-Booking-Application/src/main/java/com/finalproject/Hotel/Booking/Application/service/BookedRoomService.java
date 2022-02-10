package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.BookedRoom;
import com.finalproject.Hotel.Booking.Application.entity.Room;
import com.finalproject.Hotel.Booking.Application.repository.BookedRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookedRoomService {

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    public void saveBooking(BookedRoom bookedRoom){
        bookedRoomRepository.save(bookedRoom);
    }
    public BookedRoom getBookedRoomByRoomNumberAndRoomType(Integer roomNumber, String roomType) {
        return bookedRoomRepository.findBookedRoomByRoomNumberAndRoomType(roomNumber, roomType);
    }
}
