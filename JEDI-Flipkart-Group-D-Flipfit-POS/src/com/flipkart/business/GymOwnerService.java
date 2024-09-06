package com.flipkart.business;

import java.util.List;
import java.util.Map;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public interface GymOwnerService {

    void addGymWithSlots(Gym gym);

    List<Gym> viewMyGyms(int userId);

    boolean validateGymOwner(String email, String password);

    // boolean validateLogin(String email, String password);

    boolean createGymOwner(GymOwner gymOwner);

    boolean updateGymOwnerPassword(String email, String password, String updatedPassword);

    boolean updateGymOwner(GymOwner gymOwner);

    public int getGymOwnerIdByEmail(String email);

    public static Map<Integer, GymOwner> getGymOwnerMap() {
        return Map.of();
    }


}

