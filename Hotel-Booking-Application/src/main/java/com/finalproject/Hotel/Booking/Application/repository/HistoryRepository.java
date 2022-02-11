package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    /**
     * Method to find histories of the user who has logged in from database
     * @param userId
     * @return list of History
     */
    @Query("Select history from History history where history.userId=:userId")
    List<History> findHistoryByUserId(Long userId);
}
