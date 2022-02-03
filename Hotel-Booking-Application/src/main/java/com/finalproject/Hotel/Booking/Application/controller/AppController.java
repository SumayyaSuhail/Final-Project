package com.finalproject.Hotel.Booking.Application.controller;

import com.finalproject.Hotel.Booking.Application.entity.User;
import com.finalproject.Hotel.Booking.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class AppController {
    static Long userId;
    static Long movieId;
    static Long showId;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String loginAfterRegister(HttpServletRequest request, Model model) {
        if (!(request.getParameter("password").equals(request.getParameter("confirmPassword")))) {
            model.addAttribute("message", "Re-enter the same password!!!");
            return "register";
        } else {
            model.addAttribute("successMessage", "Registered Successfully!!!");
            String email = request.getParameter("email");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phoneNumber");
            User user = new User(email, userName, password, phoneNumber);
            userService.saveUser(user);
            return "login";
        }
    }

    @RequestMapping("/home")
    public String home(Model model, HttpServletRequest request) {
        return "home";
    }


    @PostMapping("/home")
    public String homeAfterLogin(Model model, HttpServletRequest request) {
        User user = userService.getUserByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));
        if (!(Objects.isNull(user))) {
            model.addAttribute("successMessage", "Login Successful!!!");
            userId = user.getUserId();
            return "home";
        } else {
            model.addAttribute("message", "Invalid user credentials!!!");
            return "login";
        }
    }


    @RequestMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }


    @PostMapping("/")
    public String updatePassword(HttpServletRequest request, Model model) {
        if (!(request.getParameter("newPassword").equals(request.getParameter("confirmPassword")))) {
            model.addAttribute("message", "Re-enter the same password!!!");
            return "forgotPassword";
        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("newPassword");
            User user = userService.getUserByEmail(email);
            user.setPassword(password);
            userService.saveUser(user);
            return "index";
        }
    }
}
