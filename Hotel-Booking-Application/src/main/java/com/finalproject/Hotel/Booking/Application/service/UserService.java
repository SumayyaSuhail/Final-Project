package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.User;
import com.finalproject.Hotel.Booking.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to save a new user
     *
     * @param user
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Method to find user by email and password
     *
     * @param email
     * @param password
     * @return User
     */
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    /**
     * Method to find user by email
     *
     * @param email
     * @return User
     */
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
