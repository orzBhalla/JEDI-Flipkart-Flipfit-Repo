package com.flipkart.bean;

import java.util.List;

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
    }
}