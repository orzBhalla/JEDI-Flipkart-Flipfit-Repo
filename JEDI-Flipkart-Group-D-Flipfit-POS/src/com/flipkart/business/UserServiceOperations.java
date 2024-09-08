//package com.flipkart.business;
//
//import com.flipkart.bean.Bookings;
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.Slots;
//import com.flipkart.bean.User;
//
//import java.util.*;
//
//public class UserServiceOperations implements UserService {
//    static Map<Integer, User> userMap = new HashMap<Integer, User>();
//    static int userIdCounter = 1; // for generating user ID
//
//    GymServiceOperations gymServiceOperations = new GymServiceOperations();
//    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();
//
//    public boolean createUser(User user) {
//        if (userMap.containsKey(user.getUserId())) {
//            return false;
//        }
//        user.setUserId(userIdCounter);
//        userIdCounter++;
//        userMap.put(user.getUserId(), user);
//        return true;
//    }
//
//    public boolean validateUser(String email, String password) {
//        for (User user : userMap.values()) {
//            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateGymUserPassword(String email, String password, String updatedPassword) {
//        for (User user : userMap.values()) {
//            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
//                user.setPassword(updatedPassword);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateUserDetails(User user) {
//        for (User user1 : userMap.values()) {
//            if (user.getEmail().equals(user1.getEmail())) {
//                user1.setUserName(user.getUserName());
//                user1.setPhoneNumber(user.getPhoneNumber());
//                userMap.replace(user1.getUserId(), user1);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int getUserIdByEmail(String email) {
//        for (User user : userMap.values()) {
//            if (user.getEmail().equals(email)) {
//                return user.getUserId();
//            }
//        }
//        return -1;
//    }
//
//    public boolean bookSlot(int gymId, int time, String email) {
//        int userId = -1;
//        for (User user : userMap.values()) {
//            if (email.equals(user.getEmail())) {
//                userId = user.getUserId();
//                break;
//            }
//        }
//        if (userId == -1) {
//            return false;
//        }
//        if (!gymMap.containsKey(gymId)) {
//            return false;
//        }
//        Gym gym = gymMap.get(gymId);
//        if (gym.getStatus().equals("unverified")) {
//            return false;
//        }
//        int slotId = -1;
//        for (Slots slots : gym.getSlots()) {
//            if (slots.getStartTime() == time) {
//                slotId = slots.getSlotsId();
//                break;
//            }
//        }
//        if (slotId == -1) {
//            return false;
//        }
//        Bookings bookings = new Bookings();
//        bookings.setGymId(gymId);
//        bookings.setUserId(userId);
//        bookings.setTime(time);
//        bookings.setSlotId(slotId);
//
//        return gymServiceOperations.addBookings(bookings);
//    }
//
//    public boolean cancelSlot(int bookingId) {
//
//        return gymServiceOperations.cancelBooking(bookingId);
//    }
//
//    public List<Bookings> viewAllBookings(int userId) {
//
//        return gymServiceOperations.showBookings(userId);
//    }
//
//    public List<Gym> viewAllGymsWithSlots() {
//
//        return gymServiceOperations.getAllGymsWithSlots();
//    }
//
//    public List<Gym> viewAllGymsByArea(String area) {
//
//        return gymServiceOperations.getAllGymsByArea(area);
//    }
//
//    public static Map<Integer, User> getUserMap() {
//
//        return userMap;
//    }
//}

package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitCustomerDAOImplementation;
import com.flipkart.dao.FlipFitUpdatePasswordDAOImplementation;

import java.util.*;

public class UserServiceOperations implements UserService {

    FlipFitCustomerDAOImplementation flipFitCustomerDAOImplementation = new FlipFitCustomerDAOImplementation();
    FlipFitUpdatePasswordDAOImplementation flipFitUpdatePasswordDAOImplementation = new FlipFitUpdatePasswordDAOImplementation();

    public boolean createUser(User user) {
        return flipFitCustomerDAOImplementation.createUser(user);
    }

    public boolean validateUser(String email, String password) {
        return flipFitCustomerDAOImplementation.validateUser(email, password);
    }

    public boolean updateGymUserPassword(String email, String password, String updatedPassword) {
        return flipFitUpdatePasswordDAOImplementation.updateGymUserPassword(email, password, updatedPassword);
    }

    public boolean updateUserDetails(User user) {
        return flipFitCustomerDAOImplementation.updateUserDetails(user);
    }

    public int getUserIdByEmail(String email) {
        return flipFitCustomerDAOImplementation.getUserIdByEmail(email);
    }

    public boolean bookSlot(int gymId, int startTime, String email) {
        return flipFitCustomerDAOImplementation.bookSlot(gymId, startTime, email);
    }

    public boolean cancelSlot(int bookingId) {
        return flipFitCustomerDAOImplementation.cancelBooking(bookingId);
    }

    public List<Bookings> viewAllBookings(int userId) {
        return flipFitCustomerDAOImplementation.getAllBookingsByUserID(userId);
    }

    public List<Gym> viewAllGymsWithSlots() {
        return flipFitCustomerDAOImplementation.viewAllGymsWithSlots();
    }

    public List<Gym> viewAllGymsByArea(String area) {
        return flipFitCustomerDAOImplementation.viewAllGymsByArea(area);
    }

    public int getSeatCount(int gymId, int startTime) {
        return flipFitCustomerDAOImplementation.getSeatCount(gymId, startTime);
    }
}