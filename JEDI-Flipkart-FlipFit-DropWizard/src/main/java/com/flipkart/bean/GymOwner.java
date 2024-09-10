package com.flipkart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GymOwner {
    private int ownerId; // Unique identifier for the gym owner
    private String ownerEmail; // Email address of the gym owner
    private String password; // Password for the gym owner's account
    private String phoneNo; // Phone number of the gym owner
    private String nationalId; // National ID of the gym owner
    private String GST; // GST (Goods and Services Tax) number of the gym owner
    private List<Gym> gyms; // List of gyms owned by the gym owner
    private String PAN; // PAN (Permanent Account Number) of the gym owner
    private String ownerName; // Name of the gym owner
    private String status; // Current status of the gym owner
    private String verificationStatus; // Verification status of the gym owner
}
