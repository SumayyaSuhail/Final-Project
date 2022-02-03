package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.User;
import com.finalproject.Hotel.Booking.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(user);
    }


    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User getUserById(Long userId) {
        return userRepository.findUserByUserId(userId);
    }
}
