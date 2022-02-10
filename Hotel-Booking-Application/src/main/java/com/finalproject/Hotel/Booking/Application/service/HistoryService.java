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

    public void saveHistory(History history){
        historyRepository.save(history);
    }

    public List<History> getHistoryByUserId(Long userId) {
        return historyRepository.findHistoryByUserId(userId);
    }

    public List<History> getAllHistories(){
        return historyRepository.findAll();
    }
}
