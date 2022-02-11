package com.finalproject.Hotel.Booking.Application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "roomfare")
    private Double roomFare;
    @Column(name = "maxadults")
    private Integer maxAdults;
    @Column(name = "maxchild")
    private Integer maxChild;
    @Column(name = "numberofbeds")
    private Integer numberOfBeds;

    public RoomType() {

    }

    public RoomType(String name, Double roomFare, Integer maxAdults, Integer maxChild, Integer numberOfBeds) {
        this.name = name;
        this.roomFare = roomFare;
        this.maxAdults = maxAdults;
        this.maxChild = maxChild;
        this.numberOfBeds = numberOfBeds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
