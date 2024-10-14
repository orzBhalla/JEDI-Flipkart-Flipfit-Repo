package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * Interface representing the operations that a Gym Owner can perform.
 * Includes methods for adding gyms, viewing owned gyms, validating gym owners,
 * and updating gym owner details.
 *
 */
public interface GymOwnerService {

    /**
     * Adds a new gym.
     *
     * @param gym the Gym object to be added
     * @return true if the gym was added successfully; false otherwise
     */
    boolean addGym(Gym gym);

    /**
     * Views the list of gyms owned by a specific gym owner.
     *
     * @param gymOwnerId the unique identifier of the gym owner whose gyms are to be viewed
     * @return a list of Gym objects owned by the specified gym owner
     */
    List<Gym> viewMyGyms(int gymOwnerId);

    /**
     * Validates a gym owner's credentials.
     *
     * @param email the email of the gym owner
     * @param password the current password of the gym owner
     * @return true if the email and password are valid; false otherwise
     */
    boolean validateGymOwner(String email, String password);

    /**
     * Creates a new gym owner.
     *
     * @param gymOwner the GymOwner object containing details of the new gym owner
     * @return true if the gym owner was created successfully; false otherwise
     */
    boolean createGymOwner(GymOwner gymOwner);

    /**
     * Updates the password for a gym owner.
     *
     * @param email the email of the gym owner
     * @param password the current password of the gym owner
     * @param updatedPassword the new password to be set
     * @return true if the password was updated successfully; false otherwise
     */
    boolean updateGymOwnerPassword(String email, String password, String updatedPassword);

    /**
     * Updates the details of an existing gym owner.
     *
     * @param gymOwner the GymOwner object containing updated details of the gym owner
     * @return true if the gym owner details were updated successfully; false otherwise
     */
    boolean updateGymOwner(GymOwner gymOwner);

    /**
     * Retrieves the unique identifier of a gym owner based on their email.
     *
     * @param email the email of the gym owner
     * @return the unique identifier of the gym owner
     */
    int getGymOwnerIdByEmail(String email);

    /**
     * Updates the seat count for a specific gym slot.
     *
     * @param gymId the unique identifier of the gym
     * @param startTime the start time of the slot
     * @param seatCount the new seat count to be set for the slot
     * @return true if the seat count was updated successfully; false otherwise
     */
    boolean updateSeatCount(int gymId, int startTime, int seatCount);

    /**
     * Updates user details.
     *
     * @param gym the Gym object containing updated gym details
     * @return true if the gym details were updated successfully; false otherwise
     */
    boolean updateGymDetails(Gym gym);
}

