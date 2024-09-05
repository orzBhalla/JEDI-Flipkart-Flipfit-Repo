package com.flipkart.business;

import com.flipkart.bean.Gym;

import java.util.Map;

public interface GymService {

    void addGym(Gym gym);

    void listAllGyms();

    void listAllGymsWithArea(String areaName);

    void updateGymSlots(Integer gymId, Integer slotId, Integer seatCount);

    public static Map<Integer, Gym> getGymMap() {
        return Map.of();
    }

}
