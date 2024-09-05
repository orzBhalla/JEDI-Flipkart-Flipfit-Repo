package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminServiceOperations implements AdminService{
    Map<Integer, User> userMap = UserServiceOperations.getUserMap();
    Map<Integer, GymOwner> gymOwnerMap = GymOwnerServiceOperations.getGymOwnerMap();
    Map<Integer, Gym> gymMap = GymServiceOperations.getGymMap();

    public void viewUsers() {
        for(Map.Entry<Integer, User> entry : userMap.entrySet()) {
            System.out.println("User ID: " + entry.getValue().getUserId());
            System.out.println("Name: " + entry.getValue().getUserName());
            System.out.println("Email: " + entry.getValue().getEmail());
            System.out.println("Phone Number: " + entry.getValue().getPhoneNumber());
            System.out.println("Location: " + entry.getValue().getLocation());
            System.out.println("Address: " + entry.getValue().getAddress() + "\n");
        }
    }

    public void viewGymOwners() {
        for(Map.Entry<Integer, GymOwner> entry : gymOwnerMap.entrySet()) {
            System.out.println("Gym Owner ID: " + entry.getValue().getOwnerId());
            System.out.println("Name: " + entry.getValue().getOwnerName());
            System.out.println("Email: " + entry.getValue().getOwnerEmail());
            System.out.println("Phone Number: " + entry.getValue().getPhoneNo());
            System.out.println("GST: " + entry.getValue().getGST());
            System.out.println("National ID: " + entry.getValue().getNationalId());
            System.out.println("Verification Status: " + entry.getValue().getVerificationStatus());
            System.out.println("PAN: " + entry.getValue().getPAN() + "\n");
        }
    }

    public void viewGyms() {
        for(Map.Entry<Integer, Gym> entry : gymMap.entrySet()) {
            System.out.println("Gym ID: " + entry.getValue().getGymId());
            System.out.println("Name: " + entry.getValue().getGymName());
            System.out.println("Address " + entry.getValue().getGymAddress());
            System.out.println("Location: " + entry.getValue().getLocation());
            System.out.println("Owner ID: " + entry.getValue().getOwnerId());
            System.out.println("Status: " + entry.getValue().getStatus());
        }
    }

    public boolean verifyGym(int gymId) {
        if(gymMap.containsKey(gymId)) {
            Gym gym = gymMap.get(gymId);
            gym.setStatus("verified");
            gymMap.replace(gymId, gym);
            return true;
        }
        return false;
    }

    public boolean verifyGymOwner(int gymOwnerId) {
        if(gymOwnerMap.containsKey(gymOwnerId)) {
            GymOwner gymOwner = gymOwnerMap.get(gymOwnerId);
            gymOwner.setStatus("verified");
            gymOwnerMap.replace(gymOwnerId, gymOwner);
            return true;
        }
        return false;
    }

    public List<GymOwner> getUnverifiedGymOwners() {
        List<GymOwner> gymOwnerList = new ArrayList<GymOwner>();
        for(Map.Entry<Integer, GymOwner> entry : gymOwnerMap.entrySet()) {
            if(entry.getValue().getStatus().equals("unverified")) {
                gymOwnerList.add(entry.getValue());
            }
        }
        return gymOwnerList;
    }

    public List<Gym> getUnverifiedGyms() {
        List<Gym> gymList = new ArrayList<Gym>();
        for(Map.Entry<Integer, Gym> entry : gymMap.entrySet()) {
            if(entry.getValue().getStatus().equals("unverified")) {
                gymList.add(entry.getValue());
            }
        }
        return gymList;
    }
}
