package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;

import java.util.List;
import java.util.Map;

public interface GymService {

    public boolean addBookings(Bookings bookings); // user

    public boolean cancelBooking(int bookingId); // user

    public List<Bookings> showBookings(int userId); // user

    public List<Gym> getAllGymsWithSlots(); // user

    public List<Gym> getAllGymsByArea(String areaName); // user

    void listAllGyms(); // user

    void listAllGymsWithArea(String areaName); // users

}
