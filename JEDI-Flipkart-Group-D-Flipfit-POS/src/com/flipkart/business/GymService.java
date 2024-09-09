package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;

import java.util.List;
import java.util.Map;

/**
 * Interface for gym-related operations.
 * Provides methods for booking management, retrieving gym details, and listing gyms.
 *
 * @author Adarsh, Nitish
 */
public interface GymService {

    /**
     * Adds a new booking to the system.
     *
     * @param bookings the Bookings object containing booking details
     * @return true if the booking was added successfully; false otherwise
     * @author Adarsh, Nitish
     */
    boolean addBookings(Bookings bookings);

    /**
     * Cancels an existing booking based on the booking ID.
     *
     * @param bookingId the unique identifier of the booking to be canceled
     * @return true if the booking was canceled successfully; false otherwise
     * @author Adarsh, Nitish
     */
    boolean cancelBooking(int bookingId);

    /**
     * Retrieves a list of bookings made by a specific user.
     *
     * @param userId the unique identifier of the user whose bookings are to be retrieved
     * @return a list of Bookings objects for the specified user
     * @author Adarsh, Nitish
     */
    List<Bookings> showBookings(int userId);

    /**
     * Retrieves a list of all gyms with their slots.
     *
     * @return a list of Gym objects, each containing details of the gym and its slots
     * @author Adarsh, Nitish
     */
    List<Gym> getAllGymsWithSlots();

    /**
     * Retrieves a list of gyms located in a specific area.
     *
     * @param areaName the name of the area where gyms are to be searched
     * @return a list of Gym objects located in the specified area
     * @author Adarsh, Nitish
     */
    List<Gym> getAllGymsByArea(String areaName);

    /**
     * Lists all gyms in the system.
     *
     * This method provides a simple listing of all gyms without any specific filtering.
     *
     * @author Adarsh, Nitish
     */
    void listAllGyms();

    /**
     * Lists all gyms in a specific area.
     *
     * @param areaName the name of the area where gyms are to be listed
     * @author Adarsh, Nitish
     */
    void listAllGymsWithArea(String areaName);
}


//package com.flipkart.business;
//
//import com.flipkart.bean.Bookings;
//import com.flipkart.bean.Gym;
//
//import java.util.List;
//import java.util.Map;
//
//public interface GymService {
//
//    public boolean addBookings(Bookings bookings);
//
//    public boolean cancelBooking(int bookingId);
//
//    public List<Bookings> showBookings(int userId);
//
//    public List<Gym> getAllGymsWithSlots();
//
//    public List<Gym> getAllGymsByArea(String areaName);
//
//    void listAllGyms();
//
//    void listAllGymsWithArea(String areaName);
//
//}
