package com.flipkart.bean;

import java.util.List;

<<<<<<< HEAD
/**
 * Represents a gym owner in the FlipFit system, extending FlipFitUser.
 * Contains owner-specific details such as PAN number, associated gym center IDs,
 * card details, and approval status.
 */
public class FlipFitGymOwner extends FlipFitUser {
    private String panNumber;
    private List<String> gymCentreIDs;
    private String cardDetails;
    private boolean isApproved;

    /**
     * Default constructor.
     */
    public FlipFitGymOwner() {

    }

    /**
     * Parameterized constructor to initialize gym owner details.
     * @param id User ID of the gym owner
     * @param userName Username of the gym owner
     * @param email Email of the gym owner
     * @param password Password of the gym owner
     * @param panNumber PAN number of the gym owner
     * @param cardDetails Card details of the gym owner
     */
    public FlipFitGymOwner(String id, String userName, String email, String password, String panNumber, String cardDetails) {
        super(id, userName, email, password, FlipFitRole.GYM_OWNER);
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = false;
    }

    /**
     * Retrieves the PAN number of the gym owner.
     * @return PAN number of the gym owner
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * Sets the PAN number of the gym owner.
     * @param panNumber PAN number to set
     */
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * Retrieves the list of gym center IDs associated with the gym owner.
     * @return List of gym center IDs
     */
    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    /**
     * Sets the list of gym center IDs associated with the gym owner.
     * @param gymCentreIDs List of gym center IDs to set
     */
    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    /**
     * Adds a gym center ID to the list associated with the gym owner.
     * @param gymCentreId Gym center ID to add
     */
    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    /**
     * Retrieves the card details of the gym owner.
     * @return Card details of the gym owner
     */
    public String getCardDetails() {
        return cardDetails;
    }

    /**
     * Sets the card details of the gym owner.
     * @param cardDetails Card details to set
     */
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    /**
     * Checks if the gym owner is approved.
     * @return True if the gym owner is approved, false otherwise
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Sets the approval status of the gym owner.
     * @param approved Approval status to set
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
     * Overrides the getUserID method from the parent class.
     * @return User ID of the gym owner
     */
    public String getUserID() {
        return super.getUserID();
=======

public class FlipFitGymOwner {

    private int ownerId;

    private String ownerEmail;

    private String password;

    private String phoneNo;

    private String nationalId;

    private String GST;

    private List<Gym> gyms;

    private String PAN;

    private String ownerName;

    /**
     * Status of the gym owner's account (e.g., active, inactive).
     * Note: This field is commented out in the provided code. It may be intended for future use or was temporarily removed.
     */
    // private String status; // what is the use?

    /**
     * Verification status of the gym owner's account (e.g., verified, unverified).
     */
    private String verificationStatus;


    public int getOwnerId() {
        return ownerId;
    }


    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    public String getOwnerEmail() {
        return ownerEmail;
    }


    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public List<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(List<Gym> gyms) {
        this.gyms = gyms;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
>>>>>>> cdf7f8ef0cbdc40b7dfb65f4f2c7738112163a03
    }
}