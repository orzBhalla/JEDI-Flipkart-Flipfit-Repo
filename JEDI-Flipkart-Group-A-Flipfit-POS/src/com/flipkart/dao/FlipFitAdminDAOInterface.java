package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

public interface FlipFitAdminDAOInterface {
    /**
     * Admin Can View All the Gym Owners
     *@return A list of GymOwner objects representing all registered gym owners. If no gym owners are found, an empty list is returned.*/
    List<GymOwner> viewGymOwners();
    /**
     * Admin Can View All the Gyms
     * @return A list of Gym objects representing all registered gyms. If no gyms are found, an empty list is returned.
     */
    List<Gym> viewGyms();
    /**
     * Admin Can View All the Users
     * @return A list of User objects representing all registered users. If no users are found, an empty list is returned.
     */
    List<User> viewUsers();
    /**
     * Admin Can Verify the Gyms and change their Status Like Verified Profile
     * @return  True if the gym with the specified ID exists and is valid otherwise false if the gym is not found or is invalid.
     * @param gymId- The ID of the gym to be verified
     */
    boolean verifyGym(int gymId);
    /**
     * Admin Can Verify the Gym Owners and change their Status Like Verified Profile
     * @return  True if the gym owner with the specified ID is valid and exists otherwise false if the gym owner is not found or is invalid.
     * @param gymOwnerId - The ID of the gym owner to be verified
     */
    boolean verifyGymOwner(int gymOwnerId);
    /**
     * Get a list of unverified gyms
     * @return List of unverified gyms
     */
    List<GymOwner> getUnverifiedGymOwners();
    /**
     * Get a list of unverified gym owners
     * @return List of unverified gym owners
     */
    List<Gym> getUnverifiedGyms();
}
