package com.flipkart.bean;

/**
 * This class represents a time slot for gym bookings in the GymFlipFit application.
 * It stores information about the slot ID, start time, and available seat count.
 */

public class Slots {

    private int slotsId; // Unique identifier for the slot
    private int startTime; // Start time of the slot
    private int seatCount; // Number of available seats in the slot

    public Slots(int slotsId, int startTime, int seatCount) {
        this.setSlotsId(slotsId);
        this.setStartTime(startTime);
        this.setSeatCount(seatCount);
    }

    public int getSlotsId() {
        return slotsId;
    }

    public void setSlotsId(int slotsId) {
        this.slotsId = slotsId;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getStartTime() {
        return startTime;
    }
}