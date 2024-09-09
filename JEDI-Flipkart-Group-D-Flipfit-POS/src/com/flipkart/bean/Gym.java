package com.flipkart.bean;

import java.util.List;

/**
 * Represents a gym in the system with details such as name, address, location, and available slots.
 * Contains information about the gym's ID, name, address, location, owner, and associated slots.
 *
 * @author Shreya K, Navratna
 */
public class Gym {

    /**
     * Unique identifier for the gym.
     */
    private int gymId;

    /**
     * Name of the gym.
     */
    private String gymName;

    /**
     * Address of the gym.
     */
    private String gymAddress;

    /**
     * Location of the gym.
     */
    private String location;

    /**
     * List of slots available in the gym.
     */
    private List<Slots> slots;

    /**
     * Unique identifier for the owner of the gym.
     */
    private int ownerId;

    /**
     * Status of the gym (e.g., open, closed).
     */
    private String Status;

    /**
     * Gets the unique identifier for the owner of the gym.
     *
     * @return the ownerId, which is the unique identifier for the gym's owner.
     * @author Shreya K, Navratna
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the unique identifier for the owner of the gym.
     *
     * @param ownerId the ownerId to set, which is the unique identifier for the gym's owner.
     * @author Shreya K, Navratna
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the status of the gym.
     *
     * @return the status of the gym (e.g., "open", "closed").
     * @author Shreya K, Navratna
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets the status of the gym.
     *
     * @param status the status to set for the gym (e.g., "open", "closed").
     * @author Shreya K, Navratna
     */
    public void setStatus(String status) {
        Status = status;
    }

    /**
     * Gets the list of slots available in the gym.
     *
     * @return the list of available slots.
     * @author Shreya K, Navratna
     */
    public List<Slots> getSlots() {
        return slots;
    }

    /**
     * Sets the list of slots available in the gym.
     *
     * @param slots the list of slots to set for the gym.
     * @author Shreya K, Navratna
     */
    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

    /**
     * Gets the unique identifier for the gym.
     *
     * @return the gymId, which is the unique identifier for the gym.
     * @author Shreya K, Navratna
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the unique identifier for the gym.
     *
     * @param gymId the gymId to set, which is the unique identifier for the gym.
     * @author Shreya K, Navratna
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the name of the gym.
     *
     * @return the gymName, which is the name of the gym.
     * @author Shreya K, Navratna
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets the name of the gym.
     *
     * @param gymName the gymName to set, which is the name of the gym.
     * @author Shreya K, Navratna
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Gets the address of the gym.
     *
     * @return the gymAddress, which is the address of the gym.
     * @author Shreya K, Navratna
     */
    public String getGymAddress() {
        return gymAddress;
    }

    /**
     * Sets the address of the gym.
     *
     * @param gymAddress the gymAddress to set, which is the address of the gym.
     * @author Shreya K, Navratna
     */
    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    /**
     * Gets the location of the gym.
     *
     * @return the location of the gym.
     * @author Shreya K, Navratna
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the gym.
     *
     * @param location the location to set for the gym.
     * @author Shreya K, Navratna
     */
    public void setLocation(String location) {
        this.location = location;
    }
}





//package com.flipkart.bean;
//import java.util.List;
//
//public class Gym {
//    private int gymId;
//    private String gymName;
//    private String gymAddress;
//    private String location;
//    private List<Slots> slots;
//    private int ownerId;
//    private String Status;
//
//    public int getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(int ownerId) {
//        this.ownerId = ownerId;
//    }
//
//    public String getStatus() {
//        return Status;
//    }
//
//    public void setStatus(String status) {
//        Status = status;
//    }
//
//    public List<Slots> getSlots() {
//        return slots;
//    }
//
//    public void setSlots(List<Slots> slots) {
//        this.slots = slots;
//    }
//
//    public int getGymId() {
//        return gymId;
//    }
//
//    public void setGymId(int gymId) {
//        this.gymId = gymId;
//    }
//
//    public String getGymName() {
//        return gymName;
//    }
//
//    public void setGymName(String gymName) {
//        this.gymName = gymName;
//    }
//
//    public String getGymAddress() {
//        return gymAddress;
//    }
//
//    public void setGymAddress(String gymAddress) {
//        this.gymAddress = gymAddress;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//}