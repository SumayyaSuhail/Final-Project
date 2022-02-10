package com.finalproject.Hotel.Booking.Application.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userid")
    private Long userId;
    @Column(name = "roomtypeid")
    private Long roomTypeId;
    @Column(name = "bookeddate")
    private String bookedDate;
    @Column(name = "roomcount")
    private Integer roomCount;
    @Column(name = "bookedrooms")
    private String bookedRooms;
    private Double amount;

    public History(){

    }
    public History(Long userId, Long roomTypeId, String bookedDate, Integer roomCount, String bookedRooms, Double amount) {
        this.userId=userId;
        this.roomTypeId=roomTypeId;
        this.bookedDate=bookedDate;
        this.roomCount=roomCount;
        this.bookedRooms=bookedRooms;
        this.amount=amount;
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

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookingDate) {
        this.bookedDate = bookingDate;
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
