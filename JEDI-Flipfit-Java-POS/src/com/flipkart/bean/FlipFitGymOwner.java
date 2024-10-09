package com.flipkart.bean;

import java.util.List;


public class FlipFitGymOwner {

    private int ownerId;

    private String ownerEmail;

    private String password;

    private String phoneNo;

    private String nationalId;

    private String GST;

    private List<FlipFitGym> gyms;

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

    public List<FlipFitGym> getGyms() {
        return gyms;
    }

    public void setGyms(List<FlipFitGym> gyms) {
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
    }
}