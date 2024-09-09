package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitGymOwnerDAOImplementation;
import com.flipkart.dao.FlipFitUpdatePasswordDAOImplementation;

/**
 * Implementation of the GymOwnerService interface, providing business logic for gym owner operations.
 * This class utilizes DAO implementations to interact with the data layer.
 *
 * @author Shriya, Shreya K
 */
public class GymOwnerServiceOperations implements GymOwnerService {

    private final FlipFitGymOwnerDAOImplementation flipFitGymOwnerDAOImplementation = new FlipFitGymOwnerDAOImplementation();
    private final FlipFitUpdatePasswordDAOImplementation flipFitUpdatePasswordDAOImplementation = new FlipFitUpdatePasswordDAOImplementation();

    /**
     * Adds a new gym to the system.
     *
     * @param gym the Gym object to be added
     * @return true if the gym was added successfully; false otherwise
     * @author Shriya, Shreya K
     */
    public boolean addGym(Gym gym) {
        return flipFitGymOwnerDAOImplementation.addGym(gym);
    }

    /**
     * Retrieves the list of gyms owned by a specific gym owner.
     *
     * @param gymOwnerId the unique identifier of the gym owner
     * @return a list of Gym objects owned by the specified gym owner
     * @author Shriya, Shreya K
     */
    public List<Gym> viewMyGyms(int gymOwnerId) {
        return flipFitGymOwnerDAOImplementation.viewMyGyms(gymOwnerId);
    }

    /**
     * Creates a new gym owner in the system.
     *
     * @param gymOwner the GymOwner object containing details of the new gym owner
     * @return true if the gym owner was created successfully; false otherwise
     * @author Shriya, Shreya K
     */
    public boolean createGymOwner(GymOwner gymOwner){
        return flipFitGymOwnerDAOImplementation.createGymOwner(gymOwner);
    }

    /**
     * Validates the credentials of a gym owner.
     *
     * @param email the email of the gym owner
     * @param password the current password of the gym owner
     * @return true if the email and password are valid; false otherwise
     * @author Shriya, Shreya K
     */
    public boolean validateGymOwner(String email, String password) {
        return flipFitGymOwnerDAOImplementation.validateGymOwner(email, password);
    }

    /**
     * Updates the password of a gym owner.
     *
     * @param email the email of the gym owner
     * @param password the current password of the gym owner
     * @param updatedPassword the new password to be set
     * @return true if the password was updated successfully; false otherwise
     * @author Shriya, Shreya K
     */
    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
        return flipFitUpdatePasswordDAOImplementation.updateGymOwnerPassword(email, password, updatedPassword);
    }

    /**
     * Updates the details of an existing gym owner.
     *
     * @param gymOwner the GymOwner object containing updated details of the gym owner
     * @return true if the gym owner details were updated successfully; false otherwise
     * @author Shriya, Shreya K
     */
    public boolean updateGymOwner(GymOwner gymOwner) {
        return flipFitGymOwnerDAOImplementation.updateGymOwner(gymOwner);
    }

    /**
     * Retrieves the unique identifier of a gym owner based on their email.
     *
     * @param email the email of the gym owner
     * @return the unique identifier of the gym owner
     * @author Shriya, Shreya K
     */
    public int getGymOwnerIdByEmail(String email) {
        return flipFitGymOwnerDAOImplementation.getGymOwnerIdByEmail(email);
    }

    /**
     * Updates the seat count for a specific gym slot.
     *
     * @param gymId the unique identifier of the gym
     * @param startTime the start time of the slot
     * @param seatCount the new seat count to be set for the slot
     * @return true if the seat count was updated successfully; false otherwise
     * @author Shriya, Shreya K
     */
    public boolean updateSeatCount(int gymId, int startTime, int seatCount) {
        return flipFitGymOwnerDAOImplementation.updateSeatCount(gymId, startTime, seatCount);
    }

    /**
     * Updates the details of a user.
     *
     * @param gym  the gym object containing updated gym details
     * @return  true if gym details update is successful, false otherwise
     * @author Shreya K
     */
    public boolean updateGymDetails(Gym gym) {
        return flipFitGymOwnerDAOImplementation.updateGymDetails(gym);
    }
}



//package com.flipkart.business;
//
//import java.util.*;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import com.flipkart.bean.User;
//
//public class GymOwnerServiceOperations implements GymOwnerService {
//
//    static Map<Integer,GymOwner> gymOwnerMap = new HashMap<Integer,GymOwner>();
//    static int counter = 1;
//    GymServiceOperations gymServiceOperations = new GymServiceOperations();
//    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();
//
//    public void addGymWithSlots(Gym gym) {
//        gymServiceOperations.addGym(gym);
//    }
//
//    public List<Gym> viewMyGyms(int userId){
//        List<Gym> myGyms = new ArrayList<Gym>();
//        for(Gym gym : gymMap.values()){
//            if(gym.getOwnerId() == userId){
//                myGyms.add(gym);
//            }
//        }
//        return myGyms;
//    }
//
//    public boolean createGymOwner(GymOwner gymOwner){
//        if(gymOwnerMap.containsKey(gymOwner.getOwnerId())){
//            return false;
//        }
//        gymOwner.setOwnerId(counter);
//        counter++;
//        gymOwnerMap.put(gymOwner.getOwnerId(), gymOwner);
//        return true;
//    }
//
//    public boolean validateGymOwner(String email, String password) {
//        for(GymOwner gymOwner : gymOwnerMap.values()){
//            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
//        for(GymOwner gymOwner : gymOwnerMap.values()){
//            if(gymOwner.getOwnerEmail().equals(email) && gymOwner.getPassword().equals(password)){
//                gymOwner.setPassword(updatedPassword);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateGymOwner(GymOwner gymOwner) {
//        for(GymOwner gymOwner1 : gymOwnerMap.values()){
//            if(gymOwner1.getOwnerEmail().equals(gymOwner.getOwnerEmail())){
//                gymOwner1.setOwnerName(gymOwner.getOwnerName());
//                gymOwner1.setPhoneNo(gymOwner.getPhoneNo());
//                gymOwnerMap.replace(gymOwner1.getOwnerId(), gymOwner1);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static Map<Integer, GymOwner> getGymOwnerMap() {
//        return gymOwnerMap;
//    }
//
//    public int getGymOwnerIdByEmail(String email) {
//        for(GymOwner gymOwner : gymOwnerMap.values()){
//            if(gymOwner.getOwnerEmail().equals(email)){
//                return gymOwner.getOwnerId();
//            }
//        }
//        return -1;
//    }
//}
//

//package com.flipkart.business;
//
//import java.util.*;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import com.flipkart.dao.FlipFitGymOwnerDAOImplementation;
//import com.flipkart.dao.FlipFitUpdatePasswordDAOImplementation;
//
//public class GymOwnerServiceOperations implements GymOwnerService {
//
//    FlipFitGymOwnerDAOImplementation flipFitGymOwnerDAOImplementation = new FlipFitGymOwnerDAOImplementation();
//    FlipFitUpdatePasswordDAOImplementation flipFitUpdatePasswordDAOImplementation = new FlipFitUpdatePasswordDAOImplementation();
//
//    public boolean addGym(Gym gym) {
//        return flipFitGymOwnerDAOImplementation.addGym(gym);
//    }
//
//    public List<Gym> viewMyGyms(int gymOwnerId) {
//        return flipFitGymOwnerDAOImplementation.viewMyGyms(gymOwnerId);
//    }
//
//    public boolean createGymOwner(GymOwner gymOwner){
//        return flipFitGymOwnerDAOImplementation.createGymOwner(gymOwner);
//    }
//
//    public boolean validateGymOwner(String email, String password) {
//        return flipFitGymOwnerDAOImplementation.validateGymOwner(email, password);
//    }
//
//    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
//        return flipFitUpdatePasswordDAOImplementation.updateGymOwnerPassword(email, password, updatedPassword);
//    }
//
//    public boolean updateGymOwner(GymOwner gymOwner) {
//        return flipFitGymOwnerDAOImplementation.updateGymOwner(gymOwner);
//    }
//
//    public int getGymOwnerIdByEmail(String email) {
//        return flipFitGymOwnerDAOImplementation.getGymOwnerIdByEmail(email);
//    }
//
//    public boolean updateSeatCount(int gymId, int startTime, int seatCount) {
//        return flipFitGymOwnerDAOImplementation.updateSeatCount(gymId, startTime, seatCount);
//    }
//}
