package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminDAOInterface {

    public void viewGyms();

    public void viewUsers();

    public void viewGymOwners();

    public void verifyGymOwners(int id);

    public void verifyGyms(int id);

    public List<Gym> getUnverifiedGyms();

    public List<GymOwner> getUnverifiedGymOwner();
}
