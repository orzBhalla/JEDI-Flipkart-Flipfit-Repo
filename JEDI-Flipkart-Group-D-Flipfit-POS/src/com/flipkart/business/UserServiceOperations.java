package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.dao.CustomerDAOImplementation;


import java.util.*;
public abstract class UserServiceOperations implements UserService {

    CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation() {
        @Override
        public boolean getUserByEmail(String email) {
            return false;
        }

        @Override
        public boolean updateUserDetails(com.flipkart.bean.User user, com.flipkart.bean.User user1) {
            return false;
        }

        @Override
        public int getUserIdByEmail(String email) {
            return 0;
        }

        @Override
        public List<Bookings> viewAllBookings(String userId) {
            return List.of();
        }

        @Override
        public List<Gym> viewAllGymswithSlots() {
            return List.of();
        }

        @Override
        public List<Gym> viewAllGymsByArea() {
            return List.of();
        }
    };
   // UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImplementation();
    static Map<Integer,User> userMap=new HashMap<Integer,User>();
    static int userIdCounter = 1; // for generating user ID

    GymServiceOperations gymServiceOperations = new GymServiceOperations();
    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();
    private com.flipkart.bean.User User;

//    public boolean createUser(User user){
//        if (userMap.containsKey(user.getUserId())) {
//            return false;
//        }
//        user.setUserId(userIdCounter);
//        userIdCounter++;
//        userMap.put(user.getUserId(), user);
//        return true;
//    }

    public boolean createUser(User user) {
        customerDAOInterface.createUser(user);
        return false;
    }


//    public boolean validateUser(String email, String password){
//        for(User user : userMap.values()){
//            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }

public boolean validateUser(String username, String password) {
    return customerDAOInterface.validateUser(username,password);
}

    public boolean updateGymUserPassword(String email, String password, String updatedPassword) {
        for(User user : userMap.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                user.setPassword(updatedPassword);
                return true;
            }
        }
        return false;
    }


//    public boolean updateUserDetails(User user) {
//        for(User user1 : userMap.values()){
//            if(user.getEmail().equals(user1.getEmail())){
//                user1.setUserName(user.getUserName());
//                user1.setPhoneNumber(user.getPhoneNumber());
//                userMap.replace(user1.getUserId(), user1);
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean updateUserDetails(User user) {
        return customerDAOInterface.updateUserDetails(User,user);
   }

//    public int getUserIdByEmail(String email) {
//        for(User user : userMap.values()){
//            if(user.getEmail().equals(email)){
//                return user.getUserId();
//            }
//        }
//        return -1;
//    }
    public int getUserIdByEmail(String email){
        return customerDAOInterface.getUserIdByEmail(email);
    }

    public boolean getUserByEmail(String email) {
        return customerDAOInterface.getUserByEmail(email);
    }

//    public boolean bookSlot(int gymId, int time, String email) {
//        int userId = -1;
//        for(User user : userMap.values()){
//            if(email.equals(user.getEmail())){
//                userId = user.getUserId();
//                break;
//            }
//        }
//        if(userId == -1){
//            return false;
//        }
//        if(!gymMap.containsKey(gymId)){
//            return false;
//        }
//        Gym gym = gymMap.get(gymId);
//        if(gym.getStatus().equals("unverified")) {
//            return false;
//        }
//        int slotId = -1;
//        for(Slots slots : gym.getSlots()){
//            if(slots.getStartTime()==time) {
//                slotId = slots.getSlotsId();
//                break;
//            }
//        }
//        if(slotId == -1){
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

    public boolean bookSlots(int gymId, int time, String email) {
        return customerDAOInterface.bookSlot(gymId,time,email);
    }

//    public boolean cancelSlot(int bookingId) {
//
//        return gymServiceOperations.cancelBooking(bookingId);
//    }
    public boolean cancelSlots(int bookingId) {
        // TODO Auto-generated method stub
        return customerDAOInterface.cancelBooking(bookingId);
    }

//    public List<Bookings> viewAllBookings(int userId) {
//
//        return gymServiceOperations.showBookings(userId);
//    }
//
public List<Bookings> viewAllBookings(String userId) {
    // TODO Auto-generated method stub

    return customerDAOInterface.viewAllBookings( userId);
}

//    public List<Gym> viewAllGymsWithSlots() {
//
//        return gymServiceOperations.getAllGymsWithSlots();
//    }

    public List<Gym> viewAllGymsWithSlots() {
        // TODO Auto-generated method stub
        return customerDAOInterface.viewAllGymswithSlots();
    }

//    public List<Gym> viewAllGymsByArea(String area) {
//
//        return gymServiceOperations.getAllGymsByArea(area);
//    }
public List<Gym> viewAllGymsByArea(String area) {
    // TODO Auto-generated method stub
    return customerDAOInterface.viewAllGymsByArea();

}

//    public static Map<Integer,User> getUserMap() {
//
//        return userMap;
//    }
}
