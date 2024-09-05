package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface UserServices {

        boolean cancelSlot(int bookingId); // previous it was slot id

        List<Bookings> viewAllBookings(String userId);

        List<Gym> viewAllGymsWithSlots();

        List<Gym> viewAllGymsByArea(String area);

        boolean bookSlot(int gymId, int time, String email);

        boolean validateUser(String email, String password); // using email instead of username

        void createUser(User user);

        public boolean verifyGymUserPassword(String email, String password, String updatedPassword);

        void updateGymUserPassword(String email, String password, String updatedPassword);

        void updateUserDetails(User user);
}

