package com.finalproject.Hotel.Booking.Application.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "roomtype")
    private String roomType;
    @Column(name = "roomnumber")
    private Integer roomNumber;
    @Column(name = "userid")
    private Long userId;
    public BookedRoom(){

    }
    public BookedRoom(String roomType, Integer roomNumber, Long userId){
        this.roomType=roomType;
        this.roomNumber=roomNumber;
        this.userId=userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
