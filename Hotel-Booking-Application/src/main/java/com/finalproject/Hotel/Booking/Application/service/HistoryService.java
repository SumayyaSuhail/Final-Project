package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.History;
import com.finalproject.Hotel.Booking.Application.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    /**
     * Method to save new History
     *
     * @param history
     */
    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    /**
     * Method to get Histories of a user
     *
     * @param userId
     * @return List of History
     */
    public List<History> getHistoryByUserId(Long userId) {
        return historyRepository.findHistoryByUserId(userId);
    }

    /**
     * Method to find all histories
     *
     * @return List of History
     */
    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }
}
