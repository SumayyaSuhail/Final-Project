package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Message;
import com.finalproject.Hotel.Booking.Application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(Message message){
        messageRepository.save(message);
    }
}
