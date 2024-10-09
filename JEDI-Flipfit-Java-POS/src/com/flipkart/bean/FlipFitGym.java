package com.flipkart.bean;

import java.util.List;

public class FlipFitGym {

    private int gymId;

    private String gymName;

    private String gymAddress;

    private String location;

    private List<FlipFitSlot> slots;

    private int ownerId;

    private String Status;

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<FlipFitSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<FlipFitSlot> slots) {
        this.slots = slots;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}