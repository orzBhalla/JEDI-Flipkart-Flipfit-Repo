package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import java.util.List;

public interface AdminService {

    public void viewGymOwners();

    public void viewGyms();

    public void viewUsers();

    public void verifyGym(int gymId);

    public void verifyGymOwner(int gymOwnerId);

    public List<GymOwner> getUnverifiedGymOwners();

    public List<Gym> getUnverifiedGyms();

}