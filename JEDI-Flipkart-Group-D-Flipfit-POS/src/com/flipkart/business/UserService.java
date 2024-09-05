package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean cancelSlot(int bookingId); // previous it was slot id

    List<Bookings> viewAllBookings(int userId);

    List<Gym> viewAllGymsWithSlots();

    List<Gym> viewAllGymsByArea(String area);

    boolean bookSlot(int gymId, int time, String email);

    boolean validateUser(String email, String password); // using email instead of username

    boolean createUser(User user);

    // public boolean verifyGymUserPassword(String email, String password, String updatedPassword);

    boolean updateGymUserPassword(String email, String password, String updatedPassword);

    boolean updateUserDetails(User user);

    int getUserIdByEmail(String email);

    public static Map<Integer, User> getUserMap() {
        return Map.of();
    }
}

