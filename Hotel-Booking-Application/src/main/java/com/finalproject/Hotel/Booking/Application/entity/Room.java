package com.finalproject.Hotel.Booking.Application.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "roomnumber")
    private Integer roomNumber;
    @Column(name = "roomtype")
    private String roomType;
    @Column(name = "roomfare")
    private Double roomFare;
    @Column(name = "maxadults")
    private Integer maxAdults;
    @Column(name = "maxchild")
    private Integer maxChild;
    @Column(name = "numberofbeds")
    private Integer numberOfBeds;
    private String status;

    public Room() {

    }

    public Room(Integer roomNumber, String roomType, Double roomFare, Integer maxAdults, Integer maxChild, Integer numberOfBeds, String status) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomFare = roomFare;
        this.maxAdults = maxAdults;
        this.maxChild = maxChild;
        this.numberOfBeds = numberOfBeds;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getRoomFare() {
        return roomFare;
    }

    public void setRoomFare(Double roomFare) {
        this.roomFare = roomFare;
    }

    public Integer getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(Integer maxAdults) {
        this.maxAdults = maxAdults;
    }

    public Integer getMaxChild() {
        return maxChild;
    }

    public void setMaxChild(Integer maxChild) {
        this.maxChild = maxChild;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
