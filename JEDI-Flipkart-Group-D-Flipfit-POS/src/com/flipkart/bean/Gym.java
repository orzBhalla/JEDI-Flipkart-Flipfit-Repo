package com.flipkart.bean;

import java.util.List;

public class Gym {
    private int gymId;
    private String gymName;
    private String gymAddress;
    private String location;
    private List<Slots> slots;
    private String ownerId;
    private String Status;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Slots> getSlots() {
        return slots;
    }

    public void setSlots(List<Slots> slots) {
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