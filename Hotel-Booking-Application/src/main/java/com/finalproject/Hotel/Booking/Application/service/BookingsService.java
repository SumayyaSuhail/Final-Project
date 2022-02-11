package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Bookings;
import com.finalproject.Hotel.Booking.Application.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;

    /**
     * Method to save new Bookings
     *
     * @param bookings
     */
    public void saveBooking(Bookings bookings){
        bookingsRepository.save(bookings);
    }

    /**
     * Method to get Bookings of a user
     *
     * @param userId
     * @return List of Bookings
     */
    public List<Bookings> getBookingsByUserId(Long userId) {
        return bookingsRepository.findBookingsByUserId(userId);
    }

    /**
     * Method to find all bookings
     *
     * @return List of Bookings
     */
    public List<Bookings> getAllBookings() {
        return bookingsRepository.findAll();
    }

    public void deleteAll() {
        bookingsRepository.deleteAll();
    }
}
