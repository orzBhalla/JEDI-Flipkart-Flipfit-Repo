package com.flipkart.business;

import com.flipkart.bean.Gym;

import java.util.HashMap;
import java.util.Map;

public class GymServiceOperations implements GymService {

    static HashMap<Integer, Gym> gymMap = new HashMap<>();
    int gymIdCounter = 0;

    @Override
    public void createGym(Gym gym) {
        if (gymMap.containsKey(gym.getGymId())) {
            return;
        }
        gym.setGymId(++gymIdCounter);
        gymMap.put(gym.getGymId(), gym);

    }

    @Override
    public void listAllGyms() {
        for (Gym gym : gymMap.values()) {
            System.out.println("Gym ID: " + gym.getGymId());
            System.out.println("Name: " + gym.getGymName());
            System.out.println("Address " + gym.getGymAddress());
            System.out.println("Location: " +gym.getLocation());
            System.out.println("Owner ID: " + gym.getOwnerId());
            System.out.println("Status: " + gym.getStatus());
        }
    }

    @Override
    public void listAllGymsWithArea(String areaName) {
        for (Gym gym : gymMap.values()) {
            if (gym.getGymAddress().contains(areaName)) {
                System.out.println("Gym ID: " + gym.getGymId());
                System.out.println("Name: " + gym.getGymName());
                System.out.println("Address " + gym.getGymAddress());
                System.out.println("Location: " +gym.getLocation());
                System.out.println("Owner ID: " + gym.getOwnerId());
                System.out.println("Status: " + gym.getStatus());
            }
        }
    }

    public static Map<Integer, Gym> getGymMap() {
        return gymMap;
    }

}
