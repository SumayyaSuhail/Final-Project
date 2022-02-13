package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.Admin;
import com.finalproject.Hotel.Booking.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    /**
     * Method to find the admin that matches with the email and password passed as parameters from database
     *
     * @param email
     * @param password
     * @return Admin
     */
    @Query("Select admin from Admin admin where admin.email=:email and admin.password=:password")
    Admin findAdminByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    /**
     * Method to find the admin that matches with the email passed as parameters from database
     *
     * @param email
     * @return Admin
     */
    @Query("Select admin from Admin admin where admin.email=:email")
    Admin findAdminByEmail(@Param("email") String email);

    Admin findAdminByUsername(String username);
}
