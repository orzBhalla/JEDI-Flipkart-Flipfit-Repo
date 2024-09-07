package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.util.List;

public interface FlipFitGymOwnerDAOInterface {
    List<Gym> viewMyGyms(int ownerId);

    boolean createGymOwner(GymOwner gymOwner);

    boolean updateGymOwner(GymOwner gymOwner);

    boolean addGym(Gym gym);

    boolean updateSeatCount(int gymId, int startTime, int seatCount);

    boolean addSlots(int gymId, List<Slots> slots);

    boolean validateGymOwner(String email, String password);

    List<Slots> getSlotsByGymId(int gymId);

    int getGymOwnerIdByEmail(String email);
}
