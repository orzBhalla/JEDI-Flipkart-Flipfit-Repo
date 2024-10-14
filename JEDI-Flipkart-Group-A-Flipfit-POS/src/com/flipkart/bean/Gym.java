package com.flipkart.bean;

import java.util.List;

/**
 * Represents a gym in the system with details such as name, address, location, and available slots.
 * Contains information about the gym's ID, name, address, location, owner, and associated slots.
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

     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the unique identifier for the owner of the gym.
     *
     * @param ownerId the ownerId to set, which is the unique identifier for the gym's owner.
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the status of the gym.
     *
     * @return the status of the gym (e.g., "open", "closed").
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets the status of the gym.
     *
     * @param status the status to set for the gym (e.g., "open", "closed").
     */
    public void setStatus(String status) {
        Status = status;
    }

    /**
     * Gets the list of slots available in the gym.
     *
     * @return the list of available slots.
     */
    public List<Slots> getSlots() {
        return slots;
    }

    /**
     * Sets the list of slots available in the gym.
     *
     * @param slots the list of slots to set for the gym.
     */
    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

    /**
     * Gets the unique identifier for the gym.
     *
     * @return the gymId, which is the unique identifier for the gym.
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the unique identifier for the gym.
     *
     * @param gymId the gymId to set, which is the unique identifier for the gym.
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the name of the gym.
     *
     * @return the gymName, which is the name of the gym.
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets the name of the gym.
     *
     * @param gymName the gymName to set, which is the name of the gym.
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Gets the address of the gym.
     *
     * @return the gymAddress, which is the address of the gym.
     */
    public String getGymAddress() {
        return gymAddress;
    }

    /**
     * Sets the address of the gym.
     *
     * @param gymAddress the gymAddress to set, which is the address of the gym.
     */
    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    /**
     * Gets the location of the gym.
     *
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the gym.
     *
     * @param location the location to set for the gym.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}



