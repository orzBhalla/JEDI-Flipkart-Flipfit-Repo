package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface CustomerDAOInterface {
    List<Gym> getAllGymsByArea();
    boolean bookSlot(int gymId, int time, String email);

    // List<Bookings> getAllBookingByUserID(String userId);

    List<Bookings> getAllBookingByUserID(String userId);

    boolean cancelBooking(int bookingId);
    boolean validateUser(String username, String pass);
    void createUser(User user);

    //boolean getUserByEmail(String email);
    boolean updateUserDetails(User user, User user1);

    int getUserIdByEmail(String email);

    List<Bookings> viewAllBookings(String userId);

    List<Gym> viewAllGymswithSlots();

    List<Gym> viewAllGymsByArea();

    boolean getUserByEmail(String email);
}
