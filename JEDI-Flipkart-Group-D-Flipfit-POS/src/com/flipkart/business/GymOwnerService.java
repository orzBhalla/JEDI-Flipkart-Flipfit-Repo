package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public interface GymOwnerService {

    boolean addGym(Gym gym);

    List<Gym> viewMyGyms(int gymOwnerId);

    boolean validateGymOwner(String email, String password);

    boolean createGymOwner(GymOwner gymOwner);

    boolean updateGymOwnerPassword(String email, String password, String updatedPassword);

    boolean updateGymOwner(GymOwner gymOwner);

    int getGymOwnerIdByEmail(String email);

    boolean updateSeatCount(int gymId, int startTime, int seatCount);
}

