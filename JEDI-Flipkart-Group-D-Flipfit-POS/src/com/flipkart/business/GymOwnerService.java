package com.flipkart.business;

import java.util.List;
import java.util.Map;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public interface GymOwnerService {

    void addGymWithSlots(Gym gym);

    List<Gym> viewMyGyms(String userId);

    boolean validateGymOwner(String email, String password);

    // boolean validateLogin(String email, String password);

    void createGymOwner(GymOwner gymOwner);

    void updateGymOwnerPassword(String email, String password, String updatedPassword);

    public static Map<Integer, GymOwner> getGymOwnerMap() {
        return Map.of();
    }
}

