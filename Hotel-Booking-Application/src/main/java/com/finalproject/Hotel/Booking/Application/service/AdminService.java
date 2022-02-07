package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Admin;
import com.finalproject.Hotel.Booking.Application.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.findAdminByEmailAndPassword(email, password);
    }

    public Admin getAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }
}
