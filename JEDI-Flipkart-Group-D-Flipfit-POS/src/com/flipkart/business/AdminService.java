package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import java.util.List;

public interface AdminService {

    public void viewGymOwners();

    public void viewGyms();

    public void viewUsers();

    public boolean verifyGym(int gymId);

    public boolean verifyGymOwner(int gymOwnerId);

    public List<GymOwner> getUnverifiedGymOwners();

    public List<Gym> getUnverifiedGyms();

}