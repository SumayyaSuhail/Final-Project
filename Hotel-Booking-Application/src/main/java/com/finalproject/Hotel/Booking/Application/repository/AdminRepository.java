package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.Admin;
import com.finalproject.Hotel.Booking.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("Select admin from Admin admin where admin.email=:email and admin.password=:password")
    Admin findAdminByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("Select admin from Admin admin where admin.email=:email")
    Admin findAdminByEmail(@Param("email") String email);
}
