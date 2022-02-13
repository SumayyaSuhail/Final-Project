package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Method to find User by email and password passed as parameters from database
     *
     * @param email
     * @param password
     * @return User
     */
    @Query("Select user from User user where user.email=:email and user.password=:password")
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    /**
     * Method to find User by email passed as parameters from database
     *
     * @param email
     * @return User
     */
    @Query("Select user from User user where user.email=:email")
    User findUserByEmail(@Param("email") String email);

    /**
     * Method to find User by userId passed as parameters from database
     *
     * @return User
     */
    User findUserByUsername(String username);
}
