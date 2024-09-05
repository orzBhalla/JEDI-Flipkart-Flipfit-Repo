package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.bean.User;

import java.util.*;

public class UserServiceOperations {
    static Map<Integer,User> userMap=new HashMap<Integer,User>();
    static int userIdCounter = 1; // for generating user ID

    GymServiceOperations gymServiceOperations = new GymServiceOperations();
    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();

    public void createUser(User user){
        if (userMap.containsKey(user.getUserId())) {
            return;
        }
        user.setUserId(userIdCounter);
        userIdCounter++;
        userMap.put(user.getUserId(), user);
    }

    public boolean validateUser(String email, String password){
        for(User user : userMap.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void updateGymUserPassword(String email, String password, String updatedPassword) {
        for(User user : userMap.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                user.setPassword(updatedPassword);
                break;
            }
        }
    }

    public void updateUserDetails(User user) {
        if(userMap.containsKey(user.getUserId())){
            userMap.replace(user.getUserId(), user);
        }
    }

    public boolean bookSlot(int gymId, int time, String email) {
        int userId = -1;
        for(User user : userMap.values()){
            if(email.equals(user.getEmail())){
                userId = user.getUserId();
                break;
            }
        }
        if(userId == -1){
            return false;
        }
        if(!gymMap.containsKey(gymId)){
            return false;
        }
        Gym gym = gymMap.get(gymId);
        if(gym.getStatus().equals("unverified")) {
            return false;
        }
        int slotId = -1;
        for(Slots slots : gym.getSlots()){
            if(slots.getStartTime()==time) {
                slotId = slots.getSlotsId();
                break;
            }
        }
        if(slotId == -1){
            return false;
        }
        Bookings bookings = new Bookings();
        bookings.setGymId(gymId);
        bookings.setUserId(userId);
        bookings.setTime(time);
        bookings.setSlotId(slotId);

        return gymServiceOperations.addBookings(bookings);
    }

    public boolean cancelSlot(int bookingId) {
        return gymServiceOperations.cancelBooking(bookingId);
    }

    List<Bookings> viewAllBookings(int userId) {
        return gymServiceOperations.showBookings(userId);
    }

    public List<Gym> viewAllGymsWithSlots() {
        return gymServiceOperations.getAllGymsWithSlots();
    }

    public List<Gym> viewAllGymsByArea(String area) {
        return gymServiceOperations.getAllGymsByArea(area);
    }

    public static Map<Integer,User> getUserMap() {
        return userMap;
    }
}
