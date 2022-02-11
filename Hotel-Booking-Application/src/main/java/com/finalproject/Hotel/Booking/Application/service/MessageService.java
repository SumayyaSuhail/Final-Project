package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Message;
import com.finalproject.Hotel.Booking.Application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Method to save a new Message from User
     *
     * @param message
     */
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    /**
     * Method to return all histories to Admin
     *
     * @return List of Message
     */
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
