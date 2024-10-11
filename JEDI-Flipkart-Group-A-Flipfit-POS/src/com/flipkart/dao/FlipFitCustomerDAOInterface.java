package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface FlipFitCustomerDAOInterface {

    /**
     * Book a slot at a specific gym for a given time using the user's email.
     * @param gymId - The ID of the gym
     * @param startTime - The time slot to be booked
     * @param email - The email of the user making the booking
     * @return True if the booking is successful, false otherwise
     */

    boolean bookSlot(int gymId, int startTime, String email);

    /**
     * Retrieve a list of all bookings made by a specific user.
     * @param userId - The ID of the user
     * @return List of bookings made by the user
     */

    List<Bookings> getAllBookingsByUserID(int userId);

    /**
     * Cancel a specific booking by its ID.
     * @param bookingId - The ID of the booking to be canceled
     * @return True if the booking is successfully canceled, false otherwise
     */

    boolean cancelBooking(int bookingId);


    Bookings getBooking(int bookingId);

    /**
     * Validate a user's credentials (username and password).
     * @param email - The username of the user
     * @param password - The password of the user
     * @return True if the user's credentials are valid, false otherwise
     */

    boolean validateUser(String email, String password);

    /**
     * Create a new user.
     * @param user - The user object to be created
     * @return True if the user is created suceessfully
     */

    boolean createUser(User user);

    /**
     * Updates the details of an existing user in the system.
     * @param user - The User object containing the updated details of the user.
     * @return True if the user details were successfully updated ,false otherwise
     */
    boolean updateUserDetails(User user);

    /**
     * Retrieves the user ID associated with the given email address.
     * @param email The email address of the user whose ID is to be retrieved.
     * @return  Returns the user ID associated with the provided email address.
     */

    int getUserIdByEmail(String email);

    /**
     * Retrieves a list of all gyms that have available slots.
     * @return  A list of Gym objects representing gyms with available slots.
     */

    List<Gym> viewAllGymsWithSlots();

    /**
     * Retrieves a list of gyms located in the specified area.
     * @param area The area  used to filter the gyms.
     * @return A list of Gym objects representing gyms located in the specified area. If no gyms are found in the given area, an empty list is returned.
     */

    List<Gym> viewAllGymsByArea(String area);
}
