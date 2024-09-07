package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;

import java.util.List;
import java.util.Map;

public interface GymService {

    public boolean addBookings(Bookings bookings);

    public boolean cancelBooking(int bookingId);

    public List<Bookings> showBookings(int userId);

    public List<Gym> getAllGymsWithSlots();

    public List<Gym> getAllGymsByArea(String areaName);

    void listAllGyms();

    void listAllGymsWithArea(String areaName);

}
