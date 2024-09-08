package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface UserService {

    boolean cancelSlot(int bookingId);

    List<Bookings> viewAllBookings(int userId);

    List<Gym> viewAllGymsWithSlots();

    List<Gym> viewAllGymsByArea(String area);

    boolean bookSlot(int gymId, int startTime, String email);

    boolean validateUser(String email, String password); // using email instead of username

    boolean createUser(User user);

    boolean updateGymUserPassword(String email, String password, String updatedPassword);

    boolean updateUserDetails(User user);

    int getUserIdByEmail(String email);

    int getSeatCount(int gymId, int startTime);
}

