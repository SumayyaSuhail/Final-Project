package com.finalproject.Hotel.Booking.Application.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userId;
    @Column(nullable = false, unique = true)
    private String email;
    private String username;
    @Column(name = "phonenumber", unique = true, nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;

    public User() {

    }

    public User(String email, String username, String password, String phoneNumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
