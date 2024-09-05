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

    public void verifyGym(int id) {
        adminServiceOperations.verifyGym(id);
    }

    public void verifyGymOwner(int id) {
        adminServiceOperations.verifyGymOwner(id);
    }

    public void viewUnverifiedGyms() {
        List<Gym> gyms = adminServiceOperations.getUnverifiedGyms();
        // get list from service layer
        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+");
        System.out.format("| Gym   |     Name             | Gym ID |           Address                        |   Location           |     Status       |");
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+");

        int counter = 1;
        for (Gym g : gyms) {
            System.out.format(leftAlignFormat, counter, g.getGymName(), g.getGymId(), g.getGymAddress(), g.getLocation(), g.getStatus());
            counter++;
        }
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+\n");

    }

    public void viewUnverifiedGymOwners() {
        List<GymOwner> g =  adminServiceOperations.getUnverifiedGymOwners();
        // get list from service layer
        int counter = 1;
        for (GymOwner gymOwner : g) {
            System.out.println("GymOwner " + counter + "-->  Gym Owner ID: "
                    + gymOwner.getOwnerId() + ", Email: "
                    + gymOwner.getOwnerEmail()
                    + ", Phone Number: "
                    + gymOwner.getPhoneNo()
                    + ", Status: "
                    + gymOwner.getStatus());
            counter++;
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