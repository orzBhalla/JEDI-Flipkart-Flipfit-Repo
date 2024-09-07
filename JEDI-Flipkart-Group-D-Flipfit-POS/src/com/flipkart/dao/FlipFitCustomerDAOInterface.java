package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface FlipFitCustomerDAOInterface {
    boolean bookSlot(int gymId, int startTime, String email);

    List<Bookings> getAllBookingsByUserID(int userId);

    boolean cancelBooking(int bookingId);

    boolean validateUser(String email, String password);

    boolean createUser(User user);

    boolean updateUserDetails(User user);

    int getUserIdByEmail(String email);

    List<Gym> viewAllGymsWithSlots();

    List<Gym> viewAllGymsByArea(String area);
}
