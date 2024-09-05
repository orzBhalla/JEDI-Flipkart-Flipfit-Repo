package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FlipFitGymOwnerClientMenu {
    static Scanner scanner = new Scanner(System.in);

    boolean verifyGymOwner(String email, String password) {
        return true;
    }

    boolean gymOwnerLogin(String email, String password) {
        // first verify with email and password
        if (true) {
            System.out.println("Login Successful!");
            while (true) {
                System.out.println("-----------------Gym Owner Menu-----------------");
                System.out.println("Press 1 to add a gym");
                System.out.println("Press 2 to view all gyms");
                System.out.println("Press 3 to delete a customer");
                System.out.println("Press 4 to update gym details");
                System.out.println("Press 5 to update your details");
                System.out.println("Press 6 to logout");

                int y = Integer.parseInt(scanner.nextLine());

                switch (y) {
                    case 1:
                        addGym(email);
                        break;
                    case 2:
                        displayGyms(email);
                        break;
                    case 3:
                        // delete a customer
                        break;
                    case 4:
                        // update gym details
                        break;
                    case 5:
                        // update gym owner details
                        break;
                    case 6:
                        return true;
                    default:
                        System.out.println("Invalid option!");
                }
            }
        } else
            return false;
    }

    void addGym(String userId) {
        Gym gym = new Gym();
        gym.setOwnerId(userId);

        System.out.println("Gym Name:");
        String gymName = scanner.nextLine();
        System.out.println("Gym Address:");
        String address = scanner.nextLine();
        System.out.println("Gym Location:");
        String location = scanner.nextLine();
        String gymStatus = "unverified";

        gym.setGymAddress(address);
        gym.setLocation(location);
        gym.setGymName(gymName);
        gym.setStatus(gymStatus);

        List<Slots> slots = new ArrayList<>();
        System.out.println("Please enter number of slots:");
        int slotCount = Integer.parseInt(scanner.nextLine());
        int currentCount = 1;
        while (currentCount <= slotCount) {
            System.out.println("Add for slot number " + currentCount + ": ");
            System.out.println("Enter start time:");
            int startTime = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter available seats:");
            int seatCount = Integer.parseInt(scanner.nextLine());
            Slots slot = new Slots(currentCount - 1, startTime, seatCount);
            slots.add(slot);
            currentCount++;
        }

        gym.setSlots(slots);
    }
    
    void createGymOwner() {
        System.out.println("Your Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println("Your Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNo = scanner.nextLine();
        System.out.println("Nation ID: ");
        String nationalId = scanner.nextLine();

        if (nationalId.length() != 12) {
            System.out.println("Invalid national ID! Length must be 12");
            return;
        }

        System.out.println("GST: ");
        String GST = scanner.nextLine();
        System.out.println("PAN Number: ");
        String PAN = scanner.nextLine();
        String gymOwnerStatus = "unverified";

        if (PAN.length() != 10) {
            System.out.println("Invalid PAN Card Number. Length must be 10");
            return;
        }

        GymOwner gymOwner = new GymOwner();
        List<Gym> emptyGymList = new ArrayList<>();
        gymOwner.setOwnerEmail(ownerEmail);
        gymOwner.setPAN(PAN);
        gymOwner.setOwnerName(ownerName);
        gymOwner.setGST(GST);
        gymOwner.setPassword(password);
        gymOwner.setNationalId(nationalId);
        gymOwner.setPhoneNo(phoneNo);
        gymOwner.setGyms(emptyGymList);
        gymOwner.setStatus(gymOwnerStatus);
    }

    void displayGyms(String userId) {
        List<Gym> gymsList = new ArrayList<>(); // get all gyms from GymOwnerService
        int counter = 1;
        for (Gym gym : gymsList) {
            System.out.println("Gym " + counter + ": ");
            System.out.println("Name: " + gym.getGymName() + "\nAddress: " + gym.getGymAddress() + "\nLocation: " + gym.getLocation());
            System.out.println("Slots: ");
            for (Slots slot : gym.getSlots()) {
                System.out.println("Slot: " + slot.getSlotsId() + "\nSlot Time: " + slot.getStartTime() + " - " + (slot.getStartTime() + 1) + "\nSeats: " + slot.getSeatCount());
            }
            counter++;
        }
    }
}