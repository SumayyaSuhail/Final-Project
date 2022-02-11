package com.finalproject.Hotel.Booking.Application.controller;

import com.finalproject.Hotel.Booking.Application.entity.*;
import com.finalproject.Hotel.Booking.Application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class AppController {
    static Long userId;
    static Long adminId;
    static String staticRoomType;
    static Long roomId;
    static Date bookedDate;
    static Integer numberOfDays;
    @Autowired
    private BookingsService bookingsService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private BookedRoomService bookedRoomService;

    /**
     * Method to return index page
     * @return index.html
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Method to return register page
     * @return register.html
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * Method to return login.html
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    /**
     * Method to return Admin's register page
     * @return adminRegister.html
     */
    @RequestMapping("/adminRegister")
    public String adminRegister() {
        return "adminRegister";
    }

    /**
     * Method to return login page after admin registers
     * @param request
     * @param model
     * @return login.html
     */
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

    /**
     * Method to return login page after user registers
     * @param request
     * @param model
     * @return login.html
     */
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

    /**
     * Method to return user's home page
     * @return home.html
     */
    @RequestMapping("/home")
    public String home(Model model) {
        List<RoomType> roomTypes = roomTypeService.getAllTypes();
        model.addAttribute("roomTypes", roomTypes);
        return "home";
    }

    /**
     * Method to return different home page for user and admin
     * @param model
     * @param request
     * @return admin.html for admin and home.html for user
     */
    @PostMapping("/home")
    public String homeAfterLogin(Model model, HttpServletRequest request) {
        User user = userService.getUserByEmailAndPassword(request.getParameter("email"), request.getParameter("password"));
        if (!(Objects.isNull(user))) {
            model.addAttribute("successMessage", "Login Successful!!!");
            userId = user.getUserId();
            List<RoomType> roomTypes = roomTypeService.getAllTypes();
            model.addAttribute("roomTypes", roomTypes);
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

    /**
     * Method to display forgot password page
     * @return forgotPassword.html
     */
    @RequestMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }


    /**
     * Method to return index page after password update
     * @param request
     * @param model
     * @return index.html
     */
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

    /**
     * Method to return aboutUs page
     * @return aboutUs.html
     */
    @RequestMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

    /**
     * Method to return contactUs page
     * @return contactUs.html
     */
    @RequestMapping("/contactUs")
    public String contactUs() {
        return "contactUs";
    }

    /**
     * Method to return contactUs page after contacting
     * @param request
     * @param model
     * @return contactUs.html
     */
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

    /**
     * Method to display messages for admin
     * @param request
     * @param model
     * @return messages.html
     */
    @RequestMapping("/messages")
    public String messages(HttpServletRequest request, Model model) {
        List<Message> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "messages";
    }

    /**
     * Method to display admins' home page
     * @param model
     * @return admin.html
     */
    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "admin";
    }

    /**
     * Method to return page to add room
     * @return addRoom.html
     */
    @RequestMapping("/addRoom")
    public String addRoom() {
        return "addRoom";
    }

    /**
     * Method to return addRoom page after adding a room
     * @param request
     * @param model
     * @return addRoom.html
     */
    @PostMapping("/addRoom")
    public String afterAddingRoom(HttpServletRequest request, Model model) {
        model.addAttribute("successMessage", "Room Added Successfully!");
        Integer roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String roomType = request.getParameter("roomType");
        Integer maxAdults = Integer.parseInt(request.getParameter("maxAdults"));
        Integer maxChild = Integer.parseInt(request.getParameter("maxChild"));
        Integer numberOfBeds = Integer.parseInt(request.getParameter("numberOfBeds"));
        Double roomFare = Double.parseDouble(request.getParameter("roomFare"));
        Room room = new Room(roomNumber, roomType, roomFare, maxAdults, maxChild, numberOfBeds,"false");
        roomService.saveRoom(room);
        return "addRoom";
    }

    /**
     * Method to view details of a room
     * @param model
     * @param request
     * @return viewRoom.html
     */
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
        model.addAttribute("status", room.getStatus());
        return "viewRoom";
    }

    /**
     * Method to view details of a room after editing
     * @param model
     * @param request
     * @return viewRoom.html
     */
    @PostMapping("/viewRoom")
    public String afterUpdate(HttpServletRequest request, Model model) {
        Room room = roomService.getRoomById(roomId);
        room.setRoomFare(Double.parseDouble(request.getParameter("roomFare")));
        room.setStatus(request.getParameter("status"));
        roomService.saveRoom(room);
        model.addAttribute("roomNumber", room.getRoomNumber());
        model.addAttribute("roomType", room.getRoomType());
        model.addAttribute("maxAdults", room.getMaxAdults());
        model.addAttribute("maxChild", room.getMaxChild());
        model.addAttribute("numberOfBeds", room.getNumberOfBeds());
        model.addAttribute("roomFare", room.getRoomFare());
        model.addAttribute("status", room.getStatus());
        model.addAttribute("successMessage", "Edit Successful!!!");
        return "viewRoom";
    }

    /**
     * Method to edit details of a room
     * @param model
     * @return editRoom.html
     */
    @RequestMapping("/editRoom")
    public String editRoom(Model model){
        Room room=roomService.getRoomById(roomId);
        model.addAttribute("roomNumber", room.getRoomNumber());
        model.addAttribute("roomType", room.getRoomType());
        model.addAttribute("maxAdults", room.getMaxAdults());
        model.addAttribute("maxChild", room.getMaxChild());
        model.addAttribute("numberOfBeds", room.getNumberOfBeds());
        model.addAttribute("roomFare", room.getRoomFare());
        model.addAttribute("status", room.getStatus());
        return "editRoom";
    }

    /**
     * Method to deleteRoom
     * @param model
     * @return admin.html
     */
    @RequestMapping("/deleteRoom")
    public String deleteRoom(Model model){
        Room room = roomService.getRoomById(roomId);
        roomService.deleteRoom(roomId);
        model.addAttribute("successMessage", "Deletion Successful!!!");
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "admin";
    }

    /**
     * Method to show history of bookings to admin
     * @param model
     * @return admin.html
     */
    @RequestMapping("/history")
    public String history(Model model){
        model.addAttribute("histories", bookingsService.getAllBookings());
        return "history";
    }

    /**
     * Method to return bookRoombpage
     * @param request
     * @return bookRoom.html
     */
    @PostMapping("/bookRoom")
    public String bookRoom(HttpServletRequest request, Model model){
        staticRoomType = request.getParameter("roomId");
        bookedDate= Date.valueOf(request.getParameter("bookingDate"));
        numberOfDays=Integer.parseInt(request.getParameter("numberOfDays"));
        return "bookRoom";
    }

    /**
     * Method to return payment page after booking room
     * @param request
     * @param model
     * @return payment.html
     */
    @PostMapping("/payment")
    public String payment(HttpServletRequest request, Model model){
        String bookedRooms = request.getParameter("bookedRooms");
        StringBuffer stringBuffer= new StringBuffer(bookedRooms);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        String[] rooms = bookedRooms.split(",");
        System.out.println(stringBuffer);
        RoomType roomType = roomTypeService.getByName(staticRoomType);
        for (String room : rooms) {
            Integer roomNumber = Integer.parseInt(room);
            BookedRoom bookedRoom = bookedRoomService.getBookedRoomByRoomNumberAndRoomType(roomNumber, roomType.getName());
            if (!(Objects.isNull(bookedRoom))) {
                model.addAttribute("message", "Room is already booked, Please choose another room");
                return "bookRoom";
            }
        }
        for (String room : rooms) {
            Integer roomNumber = Integer.parseInt(room);
            BookedRoom bookedRoom = bookedRoomService.getBookedRoomByRoomNumberAndRoomType(roomNumber, roomType.getName());
            BookedRoom bookedRoom1 = new BookedRoom(staticRoomType, roomNumber, userId);
            bookedRoomService.saveBooking(bookedRoom1);
        }
        for (String room : rooms) {
            Integer roomNumber = Integer.parseInt(room);
//            Room selectedRoom = roomService.getRoomByNumberAndType(roomNumber, staticRoomType);
//            selectedRoom.setStatus("true");
//            roomService.saveRoom(selectedRoom);
        }
        model.addAttribute("userId", userId);
        model.addAttribute("roomTypeId", staticRoomType);
        model.addAttribute("roomCount", rooms.length);
        model.addAttribute("rooms", stringBuffer);
        model.addAttribute("bookedDate", bookedDate);
        Double amount = ((rooms.length) * (roomType.getRoomFare()))*(numberOfDays);
        model.addAttribute("amount", amount);
        Bookings history= new Bookings(userId, staticRoomType, bookedDate, rooms.length, stringBuffer.toString(), amount);
        bookingsService.saveBooking(history);
        return "payment";
    }

    /**
     * Method to show bookings of the user
     * @param model
     * @return myBookings.html
     */
    @RequestMapping("/myBookings")
    public String myBookings(Model model){
        List<Bookings> histories = bookingsService.getBookingsByUserId(userId);
        model.addAttribute("histories", histories);
        return "myBookings";
    }

    /**
     * Method to show existing types of room
     * @param model
     * @return addRoomType.html
     */
    @RequestMapping("/addRoomType")
    public String addRoomType(Model model){
        model.addAttribute("types", roomTypeService.getAllTypes());
        return "addRoomType";
    }

    /**
     * Method to return addRoomType page
     * @return addRoomType.html
     */
    @RequestMapping("/addType")
    public String addType(){
        return "addType";
    }

    /**
     * Method to return addType page after adding a type
     * @param request
     * @param model
     * @return addType.html
     */
    @PostMapping("/addType")
    public String afterAddingRoomType(HttpServletRequest request, Model model) {
        model.addAttribute("successMessage", "Room Type Added Successfully!");
        String roomType = request.getParameter("roomType");
        Integer maxAdults = Integer.parseInt(request.getParameter("maxAdults"));
        Integer maxChild = Integer.parseInt(request.getParameter("maxChild"));
        Integer numberOfBeds = Integer.parseInt(request.getParameter("numberOfBeds"));
        Double roomFare = Double.parseDouble(request.getParameter("roomFare"));
        RoomType addedType = new RoomType(roomType, roomFare, maxAdults, maxChild, numberOfBeds);
        roomTypeService.saveRoomType(addedType);
        return "addType";
    }

    @RequestMapping("/clearAll")
    public String clearAll(Model model){
        model.addAttribute("successMessage", "Clearing Successful!");
        bookingsService.deleteAll();
        bookedRoomService.deleteAll();
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "admin";
    }
}
