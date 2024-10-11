package com.flipkart.bean;

/**
 * Represents a time slot with details such as slot ID, start time, and seat count.
 * Contains information about a specific slot's unique identifier, starting time, and the number of seats available.
 *
 */
public class Slots {

    /**
     * Unique identifier for the time slot.
     */
    private int slotsId;

    /**
     * Starting time of the time slot, represented as an integer (e.g., in minutes from midnight).
     */
    private int startTime;

    /**
     * Number of seats available in the time slot.
     */
    private int seatCount;

    /**
     * Constructs a Slots object with the specified slot ID, start time, and seat count.
     *
     * @param slotsId the unique identifier for the slot
     * @param startTime the starting time of the slot
     * @param seatCount the number of seats available in the slot
     */
    public Slots(int slotsId, int startTime, int seatCount) {
        this.setSlotsId(slotsId);
        this.setStartTime(startTime);
        this.setSeatCount(seatCount);
    }

    /**
     * Gets the unique identifier for the time slot.
     *
     * @return the slotsId, which is the unique identifier for the slot.
     * */
    public int getSlotsId() {
        return slotsId;
    }

    /**
     * Sets the unique identifier for the time slot.
     *
     * @param slotsId the slotsId to set, which is the unique identifier for the slot.
     */
    public void setSlotsId(int slotsId) {
        this.slotsId = slotsId;
    }

    /**
     * Gets the starting time of the time slot.
     *
     * @return the startTime of the slot, represented as an integer.
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Sets the starting time of the time slot.
     *
     * @param startTime the startTime to set, represented as an integer.
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the number of seats available in the time slot.
     *
     * @return the seatCount, which is the number of seats available in the slot.
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Sets the number of seats available in the time slot.
     *
     * @param seatCount the seatCount to set, which is the number of seats available in the slot.
     */
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}


