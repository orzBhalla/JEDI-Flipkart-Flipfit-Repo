package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymServiceOperations implements GymService {
    static HashMap<Integer, Gym> gymMap = new HashMap<Integer, Gym>();
    static HashMap<Integer, Bookings> bookingsMap = new HashMap<Integer, Bookings>();
    int gymIdCounter = 0;
    int bookingsIdCounter = 0;

    @Override
    public boolean addGym(Gym gym) {
        if (gymMap.containsKey(gym.getGymId())) {
            return false;
        }
        gym.setGymId(++gymIdCounter);
        gymMap.put(gym.getGymId(), gym);
        return true;
    }

    @Override
    public boolean addBookings(Bookings bookings) {
        if (bookingsMap.containsKey(bookings.getBookingId())) {
            return false;
        }
        bookings.setBookingStatus(1);
        bookings.setBookingId(++bookingsIdCounter);
        bookingsMap.put(bookings.getBookingId(), bookings);
        return true;
    }

    public boolean cancelBooking(int bookingId) {
        if (bookingsMap.containsKey(bookingId)) {
            Bookings bookings = bookingsMap.get(bookingId);
            bookings.setBookingStatus(0);
            bookingsMap.put(bookingId, bookings);
            return true;
        }
        return false;
    }

    public List<Bookings> showBookings(int userId) {
        List<Bookings> bookings = new ArrayList<Bookings>();
        for (Bookings booking : bookingsMap.values()) {
            if (booking.getUserId() == userId) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    @Override
    public void listAllGyms() {
        for (Gym gym : gymMap.values()) {
            System.out.println("Gym ID: " + gym.getGymId());
            System.out.println("Name: " + gym.getGymName());
            System.out.println("Address: " + gym.getGymAddress());
            System.out.println("Location: " + gym.getLocation());
            System.out.println("Owner ID: " + gym.getOwnerId());
            System.out.println("Status: " + gym.getStatus());
            System.out.println("-------------------------------------------------------------");
        }
    }

    @Override
    public void listAllGymsWithArea(String areaName) {
        for (Gym gym : gymMap.values()) {
            if (gym.getGymAddress().contains(areaName) || gym.getLocation().contains(areaName)) {
                System.out.println("Gym ID: " + gym.getGymId());
                System.out.println("Name: " + gym.getGymName());
                System.out.println("Address: " + gym.getGymAddress());
                System.out.println("Location: " + gym.getLocation());
                System.out.println("Owner ID: " + gym.getOwnerId());
                System.out.println("Status: " + gym.getStatus());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    @Override
    public List<Gym> getAllGymsByArea(String areaName) {
        List<Gym> gyms = new ArrayList<>();
        for (Gym gym : gymMap.values()) {
            if (gym.getGymAddress().contains(areaName) || gym.getLocation().contains(areaName)) {
                gyms.add(gym);
            }
        }
        return gyms;
    }

    @Override
    public List<Gym> getAllGymsWithSlots() {
        List<Gym> gyms = new ArrayList<>();
        gyms.addAll(gymMap.values());
        return gyms;
    }

    @Override
    public boolean updateSeatCount(int gymId, int slotId, int seatCount) {
        if(!gymMap.containsKey(gymId)) {
            return false;
        }
        Gym gym = gymMap.get(gymId);
        List<Slots> slots = gym.getSlots();
        for (Slots slot : slots) {
            if (slot.getSlotsId() == slotId) {
                slot.setSeatCount(seatCount);
                break;
            }
        }
        gym.setSlots(slots);
        gymMap.put(gymId, gym);
        return true;
    }

    public static Map<Integer, Gym> getGymMap() {
        return gymMap;
    }
}
