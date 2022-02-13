package com.finalproject.Hotel.Booking.Application.service;

import com.finalproject.Hotel.Booking.Application.entity.Admin;
import com.finalproject.Hotel.Booking.Application.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    /**
     * Method to save a new Admin
     *
     * @param admin
     */
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    /**
     * Method to find Admin by email and password
     *
     * @param email
     * @param password
     * @return Admin
     */
    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.findAdminByEmailAndPassword(email, password);
    }

    /**
     * Method to find Admin by email
     *
     * @param email
     * @return
     */
    public Admin getAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    public Admin getAdminByUsername(String username){
        return adminRepository.findAdminByUsername(username);
    }
}
