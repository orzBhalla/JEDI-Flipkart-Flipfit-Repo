package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymServiceOperations implements GymService {
    static HashMap<Integer, Gym> gymMap = new HashMap<>();
    int gymIdCounter = 0;

    @Override
    public void addGym(Gym gym) {
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
            System.out.println("Address: " + gym.getGymAddress());
            System.out.println("Location: " + gym.getLocation());
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
                System.out.println("Address: " + gym.getGymAddress());
                System.out.println("Location: " + gym.getLocation());
                System.out.println("Owner ID: " + gym.getOwnerId());
                System.out.println("Status: " + gym.getStatus());
            }
        }
    }

    @Override
    public void updateGymSlots(Integer gymId, Integer slotId, Integer seatCount) {
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
    }

    public static Map<Integer, Gym> getGymMap() {
        return gymMap;
    }
}
