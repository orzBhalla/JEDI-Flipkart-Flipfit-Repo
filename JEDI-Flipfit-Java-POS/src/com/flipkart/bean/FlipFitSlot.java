package com.flipkart.bean;

import java.time.LocalTime;

/**
 * Represents a slot of a FlipFit GymCentre
 */

public class FlipFitSlot {
    private String slotId;
    private String centerID;
    private LocalTime time;

    /**
     * Constructor for FlipFitSlot.
     * @param slotId the ID of the slot
     * @param centerID the ID of the center where the slot is located
     * @param time the time of the slot (LocalTime object)
     */
    public FlipFitSlot(String slotId, String centerID, LocalTime time) {
        this.slotId = slotId;
        this.centerID = centerID;
        this.time = time;
    }

    /**
     * Getter for the slot ID.
     * @return the slot ID
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Setter for the slot ID.
     * @param slotId the slot ID to set
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Getter for the center ID.
     * @return the center ID
     */
    public String getCenterID() {
        return centerID;
    }

    /**
     * Setter for the center ID.
     * @param centerID the center ID to set
     */
    public void setCenterID(String centerID) {
        this.centerID = centerID;
    }

    /**
     * Getter for the time of the slot.
     * @return the time of the slot (LocalTime object)
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Setter for the time of the slot.
     * @param time the time to set for the slot (LocalTime object)
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
