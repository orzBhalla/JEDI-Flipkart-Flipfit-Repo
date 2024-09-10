package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

/**
 * Interface representing the operations that an Admin can perform related to gyms and gym owners.
 * Includes methods for viewing and verifying gyms and gym owners, as well as retrieving lists of unverified entities.
 *
 * @author Chahat, Navaratna
 */
public interface AdminService {

    /**
     * Views the list of gym owners.
     *
     * This method retrieves and displays all registered gym owners.
     *
     * @author Chahat, Navaratna
     */
    List<GymOwner> viewGymOwners();

    /**
     * Views the list of gyms.
     *
     * This method retrieves and displays all registered gyms.
     *
     * @author Chahat, Navaratna
     */
    List<Gym> viewGyms();

    /**
     * Returns the list of users.
     *
     * This method retrieves and returns all registered users.
     *
     * @author Chahat, Navaratna
     */
    List<User> viewUsers();

    /**
     * Verifies the legitimacy of a gym.
     *
     * @param gymId the unique identifier of the gym to be verified
     * @return true if the gym is verified successfully; false otherwise
     * @author Chahat, Navaratna
     */
    boolean verifyGym(int gymId);

    /**
     * Verifies the legitimacy of a gym owner.
     *
     * @param gymOwnerId the unique identifier of the gym owner to be verified
     * @return true if the gym owner is verified successfully; false otherwise
     * @author Chahat, Navaratna
     */
    boolean verifyGymOwner(int gymOwnerId);

    /**
     * Retrieves a list of unverified gym owners.
     *
     * @return a list of GymOwner objects representing the gym owners who have not yet been verified
     * @author Chahat, Navaratna
     */
    List<GymOwner> getUnverifiedGymOwners();

    /**
     * Retrieves a list of unverified gyms.
     *
     * @return a list of Gym objects representing the gyms that have not yet been verified
     * @author Chahat, Navaratna
     */
    List<Gym> getUnverifiedGyms();
}



//package com.flipkart.business;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import java.util.List;
//
//public interface AdminService {
//    void viewGymOwners();
//
//    void viewGyms();
//
//    void viewUsers();
//
//    boolean verifyGym(int gymId);
//
//    boolean verifyGymOwner(int gymOwnerId);
//
//    List<GymOwner> getUnverifiedGymOwners();
//
//    List<Gym> getUnverifiedGyms();
//}