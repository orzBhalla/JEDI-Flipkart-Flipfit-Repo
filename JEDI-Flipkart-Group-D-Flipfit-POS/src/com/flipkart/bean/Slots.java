package com.flipkart.bean;

public class Slots {
    private int slotsId;
    private int startTime;
    private int seatCount;

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