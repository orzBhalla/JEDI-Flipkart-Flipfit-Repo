package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

/**
 * Interface for user-related operations.
 * Provides methods for booking and canceling slots, viewing gyms, and managing user details.
 *
 */
public interface UserService {

    /**
     * Cancels a slot booking based on the booking ID.
     *
     * @param bookingId the ID of the booking to be canceled
     * @return true if the cancellation was successful; false otherwise
     */
    boolean cancelSlot(int bookingId);

    /**
     * Retrieves all bookings made by the user.
     *
     * @param userId the ID of the user whose bookings are to be retrieved
     * @return a list of bookings made by the user
     */
    List<Bookings> viewAllBookings(int userId);

    /**
     * Retrieves all gyms with available slots.
     *
     * @return a list of gyms with available slots
     */
    List<Gym> viewAllGymsWithSlots();

    /**
     * Retrieves all gyms in a specified area.
     *
     * @param area the area in which to search for gyms
     * @return a list of gyms located in the specified area
     */
    List<Gym> viewAllGymsByArea(String area);

    /**
     * Books a slot at a specified gym.
     *
     * @param gymId the ID of the gym where the slot is to be booked
     * @param startTime the start time of the slot
     * @param email the email of the user making the booking
     * @return true if the booking was successful; false otherwise
     */
    boolean bookSlot(int gymId, int startTime, String email);

    /**
     * Validates a user based on email and password.
     *
     * @param email the email of the user
     * @param password the password of the user
     * @return true if the credentials are valid; false otherwise
     */
    boolean validateUser(String email, String password);

    /**
     * Creates a new user.
     *
     * @param user the User object containing user details
     * @return true if the user was created successfully; false otherwise
     */
    boolean createUser(User user);

    /**
     * Updates the password for a user.
     *
     * @param email the email of the user
     * @param password the current password of the user
     * @param updatedPassword the new password to be set
     * @return true if the password was updated successfully; false otherwise
     */
    boolean updateUserPassword(String email, String password, String updatedPassword);

    /**
     * Updates user details.
     *
     * @param user the User object containing updated user details
     * @return true if the user details were updated successfully; false otherwise
     */
    boolean updateUserDetails(User user);

    /**
     * Retrieves the user ID based on the user's email.
     *
     * @param email the email of the user
     * @return the ID of the user associated with the email
     */
    int getUserIdByEmail(String email);

    /**
     * Retrieves the number of available seats at a specified gym and start time.
     *
     * @param gymId the ID of the gym
     * @param startTime the start time of the slot
     * @return the number of available seats
     */
    int getSeatCount(int gymId, int startTime);
}


//package com.flipkart.business;
//
//import com.flipkart.bean.Bookings;
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.User;
//
//import java.util.List;
//
//public interface UserService {
//
//    boolean cancelSlot(int bookingId);
//
//    List<Bookings> viewAllBookings(int userId);
//
//    List<Gym> viewAllGymsWithSlots();
//
//    List<Gym> viewAllGymsByArea(String area);
//
//    boolean bookSlot(int gymId, int startTime, String email);
//
//    boolean validateUser(String email, String password); // using email instead of username
//
//    boolean createUser(User user);
//
//    boolean updateGymUserPassword(String email, String password, String updatedPassword);
//
//    boolean updateUserDetails(User user);
//
//    int getUserIdByEmail(String email);
//
//    int getSeatCount(int gymId, int startTime);
//}

