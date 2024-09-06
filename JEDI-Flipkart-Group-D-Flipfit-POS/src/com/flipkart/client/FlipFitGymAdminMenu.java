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

    public boolean verifyGymOwner(int id) {
        return adminServiceOperations.verifyGymOwner(id);
    }

    public void viewUnverifiedGyms() {
        List<Gym> gyms = adminServiceOperations.getUnverifiedGyms();
        if(gyms.isEmpty()) {
            return;
        }
        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+");
        System.out.format("| Gym   |     Name             | Gym ID |           Address                        |   Location           |     Status       |");
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+");

        int gymCounter = 1;
        for (Gym g : gyms) {
            System.out.format(leftAlignFormat, gymCounter, g.getGymName(), g.getGymId(), g.getGymAddress(), g.getLocation(), g.getStatus());
            gymCounter++;
        }
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+\n");
    }

    public void viewUnverifiedGymOwners() {
        List<GymOwner> g =  adminServiceOperations.getUnverifiedGymOwners();
        int gymOwnerCounter = 1;
        for (GymOwner gymOwner : g) {
            System.out.println("GymOwner " + gymOwnerCounter + " --> ID: "
                    + gymOwner.getOwnerId() + ", Name: "
                    + gymOwner.getOwnerName() + ", Email: "
                    + gymOwner.getOwnerEmail()
                    + ", Phone Number: "
                    + gymOwner.getPhoneNo()
                    + ", Verification Status: "
                    + gymOwner.getVerificationStatus());
            gymOwnerCounter++;
            System.out.println("-------------------------------------------------------------");
        }
    }

    public boolean verifyAdminCredentials(String id, String pass) {
        try {
            // verify from database
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}