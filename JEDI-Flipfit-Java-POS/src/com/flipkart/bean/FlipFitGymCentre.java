package com.flipkart.bean;

public class FlipFitGymCentre {
    private String gymCenterId;

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(String gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    public String getGymCenterName() {
        return gymCenterName;
    }

    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private String ownerID;
    private String gymCenterName;
    private String city;
    private int capacity;
}
