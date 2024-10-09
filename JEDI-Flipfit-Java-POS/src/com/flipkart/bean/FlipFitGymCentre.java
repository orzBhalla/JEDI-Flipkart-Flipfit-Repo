package com.flipkart.bean;

/**
 * Represents a gym center in the FlipFit system.
 */
public class FlipFitGymCenter {
    private String gymCenterId;
    private String ownerID;
    private String gymCenterName;
    protected String gstin;
    private String city;
    private int capacity;
    private int price;
    private Boolean isApproved;

    /**
     * Default constructor.
     */
    public FlipFitGymCenter() {

    }

    /**
     * Parameterized constructor to initialize gym center details.
     * @param gymCenterId ID of the gym center
     * @param ownerID ID of the owner of the gym center
     * @param gymCenterName Name of the gym center
     * @param gstin GST identification number of the gym center
     * @param city City where the gym center is located
     * @param capacity Maximum capacity of the gym center
     * @param price Price associated with the gym center
     * @param isApproved Approval status of the gym center
     */
    public FlipFitGymCenter(String gymCenterId, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price, Boolean isApproved) {
        this.gymCenterId = gymCenterId;
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = isApproved;
    }

    /**
     * Retrieves the GST identification number of the gym center.
     * @return GST identification number
     */
    public String getGstin() {
        return gstin;
    }

    /**
     * Sets the GST identification number of the gym center.
     * @param gstin GST identification number to set
     */
    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    /**
     * Retrieves the price associated with the gym center.
     * @return Price of the gym center
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price associated with the gym center.
     * @param price Price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the ID of the gym center.
     * @return ID of the gym center
     */
    public String getGymCenterId() {
        return gymCenterId;
    }

    /**
     * Sets the ID of the gym center.
     * @param gymCenterId ID to set
     */
    public void setGymCenterId(String gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    /**
     * Retrieves the city where the gym center is located.
     * @return City of the gym center
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the gym center is located.
     * @param city City to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the maximum capacity of the gym center.
     * @return Capacity of the gym center
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the maximum capacity of the gym center.
     * @param capacity Capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Retrieves the name of the gym center.
     * @return Name of the gym center
     */
    public String getGymCenterName() {
        return gymCenterName;
    }

    /**
     * Sets the name of the gym center.
     * @param gymCenterName Name to set
     */
    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    /**
     * Retrieves the ID of the owner of the gym center.
     * @return Owner ID of the gym center
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * Sets the ID of the owner of the gym center.
     * @param ownerID Owner ID to set
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * Checks if the gym center is approved.
     * @return True if the gym center is approved, false otherwise
     */
    public Boolean isApproved() {
        return isApproved;
    }

    /**
     * Sets the approval status of the gym center.
     * @param approved Approval status to set
     */
    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}