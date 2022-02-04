package com.finalproject.Hotel.Booking.Application.repository;

import com.finalproject.Hotel.Booking.Application.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
