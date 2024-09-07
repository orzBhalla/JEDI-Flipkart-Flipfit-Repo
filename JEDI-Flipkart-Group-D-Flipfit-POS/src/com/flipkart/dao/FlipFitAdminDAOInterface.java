package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

public interface FlipFitAdminDAOInterface {
    List<GymOwner> viewGymOwners();

    List<Gym> viewGyms();

    List<User> viewUsers();

    boolean verifyGym(int gymId);

    boolean verifyGymOwner(int gymOwnerId);

    List<GymOwner> getUnverifiedGymOwners();

    List<Gym> getUnverifiedGyms();
}
