package com.finalproject.Hotel.Booking.Application.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userid")
    private Long userId;
    @Column(name = "roomtypeid")
    private String roomTypeId;
    @Column(name = "bookeddate")
    private Date bookedDate;
    @Column(name = "roomcount")
    private Integer roomCount;
    @Column(name = "bookedrooms")
    private String bookedRooms;
    private Double amount;

    public Bookings() {

    }

    public Bookings(Long userId, String roomTypeId, Date bookedDate, Integer roomCount, String bookedRooms, Double amount) {
        this.userId = userId;
        this.roomTypeId = roomTypeId;
        this.bookedDate = bookedDate;
        this.roomCount = roomCount;
        this.bookedRooms = bookedRooms;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public String getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(String bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
