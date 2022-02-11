package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    /**
     * Method to find bookings of the user who has logged in from database
     * @param userId
     * @return list of Bookings
     */
    @Query("Select history from History history where history.userId=:userId")
    List<Bookings> findBookingsByUserId(Long userId);
}
