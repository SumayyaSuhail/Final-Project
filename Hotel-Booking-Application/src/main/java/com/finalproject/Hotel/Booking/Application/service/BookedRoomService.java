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

    /**
     * Method to save a new BookedRoom
     *
     * @param bookedRoom
     */
    public void saveBooking(BookedRoom bookedRoom) {
        bookedRoomRepository.save(bookedRoom);
    }

    /**
     * Method to get a booked room by room number and room type
     *
     * @param roomNumber
     * @param roomType
     * @return BookedRoom
     */
    public BookedRoom getBookedRoomByRoomNumberAndRoomType(Integer roomNumber, String roomType) {
        return bookedRoomRepository.findBookedRoomByRoomNumberAndRoomType(roomNumber, roomType);
    }

    public void deleteAll() {
        bookedRoomRepository.deleteAll();
    }
}
