package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;

import java.util.List;
import java.util.Map;

public interface GymService {

    void addGym(Gym gym);

    public boolean addBookings(Bookings bookings);

    public boolean cancelBooking(int bookingId);

    public List<Bookings> showBookings(int userId);

    public List<Gym> getAllGymsWithSlot();

    public List<Gym> getAllGymsByArea(String areaName);

    void listAllGyms();

    void listAllGymsWithArea(String areaName);

    void updateGymSlots(Integer gymId, Integer slotId, Integer seatCount);

    public static Map<Integer, Gym> getGymMap() {
        return Map.of();
    }
}
