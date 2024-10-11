package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitCustomerDAOImplementation;
import com.flipkart.dao.FlipFitUpdatePasswordDAOImplementation;

import java.util.*;

/**
 * Provides operations related to user services including user creation, updating user details,
 * validating users, and managing bookings.
 * Implements UserService interface.
 *
 */
public class UserServiceOperations implements UserService {

    /**
     * Data access object for customer-related operations.
     */
    FlipFitCustomerDAOImplementation flipFitCustomerDAOImplementation = new FlipFitCustomerDAOImplementation();

    /**
     * Data access object for updating user passwords.
     */
    FlipFitUpdatePasswordDAOImplementation flipFitUpdatePasswordDAOImplementation = new FlipFitUpdatePasswordDAOImplementation();

    /**
     * Creates a new user in the system.
     *
     * @param user  the user object containing the user's details
     * @return  true if user creation is successful, false otherwise
     */
    public boolean createUser(User user) {
        return flipFitCustomerDAOImplementation.createUser(user);
    }

    /**
     * Updates the password of a user.
     *
     * @param email  the email of the user
     * @param password  the current password of the user
     * @param updatedPassword  the new password to set
     * @return  false, as the implementation is not provided
     */
    @Override
    public boolean updateUserPassword(String email, String password, String updatedPassword) {
        return false;
    }

    /**
     * Validates a user's credentials.
     *
     * @param email  the email of the user
     * @param password  the password of the user
     * @return  true if the user is valid, false otherwise
     */
    public boolean validateUser(String email, String password) {
        return flipFitCustomerDAOImplementation.validateUser(email, password);
    }

    /**
     * Updates the password for a gym user.
     *
     * @param email  the email of the gym user
     * @param password  the current password of the gym user
     * @param updatedPassword  the new password to set
     * @return  true if password update is successful, false otherwise
     */
    public boolean updateGymUserPassword(String email, String password, String updatedPassword) {
        return flipFitUpdatePasswordDAOImplementation.updateGymUserPassword(email, password, updatedPassword);
    }

    /**
     * Updates the details of a user.
     *
     * @param user  the user object containing updated user details
     * @return  true if user details update is successful, false otherwise
     */
    public boolean updateUserDetails(User user) {
        return flipFitCustomerDAOImplementation.updateUserDetails(user);
    }

    /**
     * Retrieves the user ID associated with a given email.
     *
     * @param email  the email of the user
     * @return  the user ID associated with the given email
     */
    public int getUserIdByEmail(String email) {
        return flipFitCustomerDAOImplementation.getUserIdByEmail(email);
    }

    /**
     * Books a slot at a gym for a user.
     *
     * @param gymId  the ID of the gym
     * @param startTime  the start time of the slot
     * @param email  the email of the user
     * @return  true if the booking is successful, false otherwise
     */
    public boolean bookSlot(int gymId, int startTime, String email) {
        return flipFitCustomerDAOImplementation.bookSlot(gymId, startTime, email);
    }

    /**
     * Cancels a booking.
     *
     * @param bookingId  the ID of the booking to cancel
     * @return  true if the cancellation is successful, false otherwise
     */
    public boolean cancelSlot(int bookingId) {
        return flipFitCustomerDAOImplementation.cancelBooking(bookingId);
    }

    /**
     * Retrieves all bookings made by a user.
     *
     * @param userId  the ID of the user
     * @return  a list of bookings associated with the user
     */
    public List<Bookings> viewAllBookings(int userId) {
        return flipFitCustomerDAOImplementation.getAllBookingsByUserID(userId);
    }

    /**
     * Retrieves all gyms that have available slots.
     *
     * @return  a list of gyms with available slots
     */
    public List<Gym> viewAllGymsWithSlots() {
        return flipFitCustomerDAOImplementation.viewAllGymsWithSlots();
    }

    /**
     * Retrieves all gyms in a specified area.
     *
     * @param area  the area to search for gyms
     * @return  a list of gyms located in the specified area
     */
    public List<Gym> viewAllGymsByArea(String area) {
        return flipFitCustomerDAOImplementation.viewAllGymsByArea(area);
    }

    /**
     * Retrieves the seat count available at a gym for a given time slot.
     *
     * @param gymId  the ID of the gym
     * @param startTime  the start time of the slot
     * @return  the number of available seats at the gym for the given time
     */
    public int getSeatCount(int gymId, int startTime) {
        return flipFitCustomerDAOImplementation.getSeatCount(gymId, startTime);
    }
}
