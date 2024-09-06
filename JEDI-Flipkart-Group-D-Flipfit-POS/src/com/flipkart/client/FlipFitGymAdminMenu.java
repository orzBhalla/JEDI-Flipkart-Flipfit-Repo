package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminServiceOperations;

import java.util.List;

public class FlipFitGymAdminMenu {
    AdminServiceOperations adminServiceOperations = new AdminServiceOperations();

    public void viewGyms() {
        adminServiceOperations.viewGyms();
    }

    public void viewUsers() {
        adminServiceOperations.viewUsers();
    }

    public void viewGymOwners() {
        adminServiceOperations.viewGymOwners();
    }

    public boolean verifyGym(int id) {
        return adminServiceOperations.verifyGym(id);
    }

    public boolean verifyGymOwner(int gymOwnerId) {
        return adminServiceOperations.verifyGymOwner(gymOwnerId);
    }

    public void viewUnverifiedGyms() {
        List<Gym> gyms = adminServiceOperations.getUnverifiedGyms();
        if(gyms.isEmpty()) {
            System.out.println("No unverified gyms found.");
            return;
        }
        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+");
        System.out.format("| S.No   |     Name            | Gym ID |           Address                        |   Location           |     Status       |");
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+");

        int gymCounter = 1;
        for (Gym g : gyms) {
            System.out.format(leftAlignFormat, gymCounter, g.getGymName(), g.getGymId(), g.getGymAddress(), g.getLocation(), g.getStatus());
            gymCounter++;
        }
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+\n");
    }


//    public void viewUnverifiedGymOwners() {
//        List<GymOwner> gymOwnerList =  adminServiceOperations.getUnverifiedGymOwners();
//        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
//        int gymOwnerCounter = 1;
//        for (GymOwner gymOwner : gymOwnerList) {
//            System.out.println("GymOwner " + gymOwnerCounter + " --> ID: "
//                    + gymOwner.getOwnerId() + ", Name: "
//                    + gymOwner.getOwnerName() + ", Email: "
//                    + gymOwner.getOwnerEmail()
//                    + ", Phone Number: "
//                    + gymOwner.getPhoneNo()
//                    + ", Verification Status: "
//                    + gymOwner.getVerificationStatus());
//            gymOwnerCounter++;
//            System.out.println("-------------------------------------------------------------");
//        }
//    }

    public void viewUnverifiedGymOwners() {
        List<GymOwner> gymOwnerList = adminServiceOperations.getUnverifiedGymOwners();
        if(gymOwnerList.isEmpty()) {
            System.out.println("No unverified gym owners found.");
            return;
        }

        String leftAlignFormat = "| %-5d | %-10d | %-20s | %-20s | %-15s |%n";
        System.out.format("+-------+----------+----------------------+----------------------+------------------+");
        System.out.format("| S.No  | Owner ID |     Owner Name       |     Email            |     Status       |");
        System.out.format("+-------+----------+----------------------+----------------------+------------------+");

        int gymOwnerCounter = 1;
        for (GymOwner gymOwner : gymOwnerList) {
            System.out.format(leftAlignFormat, gymOwnerCounter, gymOwner.getOwnerId(), gymOwner.getOwnerName(), gymOwner.getOwnerEmail(), gymOwner.getVerificationStatus());
            gymOwnerCounter++;
        }
        System.out.format("+-------+----------+----------------------+----------------------+------------------+\n");
    }


    public boolean verifyAdminCredentials(String userId, String password) {
        try {
            // verify from database
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}