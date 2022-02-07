package com.finalproject.Hotel.Booking.Application.controller;

import com.finalproject.Hotel.Booking.Application.entity.Admin;
import com.finalproject.Hotel.Booking.Application.entity.Message;
import com.finalproject.Hotel.Booking.Application.entity.Room;
import com.finalproject.Hotel.Booking.Application.entity.User;
import com.finalproject.Hotel.Booking.Application.service.AdminService;
import com.finalproject.Hotel.Booking.Application.service.MessageService;
import com.finalproject.Hotel.Booking.Application.service.RoomService;
import com.finalproject.Hotel.Booking.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class AppController {
    static Long userId;
    static Long adminId;
    static Long roomId;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AdminService adminService;

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


    @RequestMapping("/adminRegister")
    public String adminRegister() {
        return "adminRegister";
    }

    @PostMapping("/adminLogin")
    public String loginAfterAdminRegister(HttpServletRequest request, Model model) {
        if (!(request.getParameter("password").equals(request.getParameter("confirmPassword")))) {
            model.addAttribute("message", "Re-enter the same password!!!");
            return "adminRegister";
        } else {
            if (!(request.getParameter("adminCode").equals("ADMIN"))) {
                model.addAttribute("message", "Invalid Admin Code!!!");
                return "adminRegister";
            } else {
                model.addAttribute("successMessage", "Registered Successfully!!!");
                String email = request.getParameter("email");
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                String phoneNumber = request.getParameter("phoneNumber");
                Admin admin = new Admin(email, userName, password, phoneNumber);
                adminService.saveAdmin(admin);
                return "login";
            }
        }
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
    public String home() {
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
            Admin admin = adminService.getAdminByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));
            if (!(Objects.isNull(admin))) {
                model.addAttribute("successMessage", "Login Successful!!!");
                adminId = admin.getId();
                List<Room> rooms = roomService.getAllRooms();
                model.addAttribute("rooms", rooms);
                return "admin";
            } else {
                model.addAttribute("message", "Invalid user credentials!!!");
                return "login";
            }
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
            if (!(Objects.isNull(user))) {
                user.setPassword(password);
                userService.saveUser(user);
                return "index";
            } else {
                Admin admin = adminService.getAdminByEmail(email);
                if (!(Objects.isNull(admin))) {
                    admin.setPassword(password);
                    adminService.saveAdmin(admin);
                    return "index";
                } else {
                    model.addAttribute("message", "Account does not exist!!!");
                    return "forgotPassword";
                }
            }

        }
    }

    @RequestMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

    @RequestMapping("/contactUs")
    public String contactUs() {
        return "contactUs";
    }

    @PostMapping("/contactUs")
    public String afterContact(HttpServletRequest request, Model model) {
        model.addAttribute("successMessage", "Message Sent Successfully! Admin will contact you via Email!");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        Message newMessage = new Message(name, email, subject, message);
        messageService.saveMessage(newMessage);
        return "/contactUs";
    }

    @RequestMapping("/messages")
    public String messages(HttpServletRequest request, Model model) {
        List<Message> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "messages";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "admin";
    }

    @RequestMapping("/addRoom")
    public String addRoom() {
        return "addRoom";
    }

    @PostMapping("/addRoom")
    public String afterAddingRoom(HttpServletRequest request, Model model) {
        model.addAttribute("successMessage", "Room Added Successfully!");
        Integer roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String roomType = request.getParameter("roomType");
        Integer maxAdults = Integer.parseInt(request.getParameter("maxAdults"));
        Integer maxChild = Integer.parseInt(request.getParameter("maxChild"));
        Integer numberOfBeds = Integer.parseInt(request.getParameter("numberOfBeds"));
        Double roomFare = Double.parseDouble(request.getParameter("roomFare"));
        Room room = new Room(roomNumber, roomType, roomFare, maxAdults, maxChild, numberOfBeds);
        roomService.saveRoom(room);
        return "addRoom";
    }

    @RequestMapping("/viewRoom")
    public String viewRoom(Model model, HttpServletRequest request) {
        roomId=Long.parseLong(request.getParameter("roomId"));
        Room room = roomService.getRoomById(roomId);
        model.addAttribute("roomNumber", room.getRoomNumber());
        model.addAttribute("roomType", room.getRoomType());
        model.addAttribute("maxAdults", room.getMaxAdults());
        model.addAttribute("maxChild", room.getMaxChild());
        model.addAttribute("numberOfBeds", room.getNumberOfBeds());
        model.addAttribute("roomFare", room.getRoomFare());
        return "viewRoom";
    }

    @PostMapping("/viewRoom")
    public String afterUpdate(HttpServletRequest request, Model model) {
        Room room = roomService.getRoomById(roomId);
        room.setRoomType(request.getParameter("roomType"));
        room.setMaxAdults(Integer.parseInt(request.getParameter("maxAdults")));
        room.setMaxChild(Integer.parseInt(request.getParameter("maxChild")));
        room.setNumberOfBeds(Integer.parseInt(request.getParameter("numberOfBeds")));
        room.setRoomFare(Double.parseDouble(request.getParameter("roomFare")));
        roomService.saveRoom(room);
        model.addAttribute("roomNumber", room.getRoomNumber());
        model.addAttribute("roomType", room.getRoomType());
        model.addAttribute("maxAdults", room.getMaxAdults());
        model.addAttribute("maxChild", room.getMaxChild());
        model.addAttribute("numberOfBeds", room.getNumberOfBeds());
        model.addAttribute("roomFare", room.getRoomFare());
        model.addAttribute("successMessage", "Edit Successful!!!");
        return "viewRoom";
    }

    @RequestMapping("/editRoom")
    public String editRoom(Model model){
        Room room=roomService.getRoomById(roomId);
        model.addAttribute("roomNumber", room.getRoomNumber());
        model.addAttribute("roomType", room.getRoomType());
        model.addAttribute("maxAdults", room.getMaxAdults());
        model.addAttribute("maxChild", room.getMaxChild());
        model.addAttribute("numberOfBeds", room.getNumberOfBeds());
        model.addAttribute("roomFare", room.getRoomFare());
        return "editRoom";
    }

    @RequestMapping("/deleteRoom")
    public String deleteRoom(Model model){
        Room room = roomService.getRoomById(roomId);
        roomService.deleteRoom(roomId);
        model.addAttribute("successMessage", "Deletion Successful!!!");
        return "admin";
    }

    @RequestMapping("/history")
    public String history(Model model){
        return "history";
    }
}
