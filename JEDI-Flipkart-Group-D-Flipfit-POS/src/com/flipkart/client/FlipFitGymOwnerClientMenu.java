package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.GymOwnerServiceOperations;
import com.flipkart.business.GymServiceOperations;
import com.flipkart.business.UserServiceOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FlipFitGymOwnerClientMenu {
    Scanner scanner = new Scanner(System.in);
    GymServiceOperations gymService = new GymServiceOperations();
    GymOwnerServiceOperations gymOwnerServiceOperations = new GymOwnerServiceOperations();
    UserServiceOperations userServiceOperations = new UserServiceOperations();

    boolean verifyGymOwner(String email, String password) {
        return gymOwnerServiceOperations.validateGymOwner(email, password);
    }

    boolean gymOwnerLogin(String email, String password) {
        if(!verifyGymOwner(email, password)) {
            return false;
        }
        System.out.println("Login Successful! (Gym Owner)");
        while (true) {
            System.out.println("-----------------Gym Owner Menu-----------------");
            System.out.println("Press 1 to add a gym");
            System.out.println("Press 2 to view all gyms");
            System.out.println("Press 3 to delete a customer");
            System.out.println("Press 4 to update seat count");
            System.out.println("Press 5 to update your details");
            System.out.println("Press 6 to logout");

            int y = scanner.nextInt();

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
                    System.out.println("Enter gym ID: ");
                    int gymId = scanner.nextInt();
                    System.out.println("Enter slot ID: ");
                    int slotId = scanner.nextInt();
                    System.out.println("Enter updated seat count: ");
                    int seatCount = scanner.nextInt();
                    if(gymService.updateSeatCount(gymId, slotId, seatCount))
                        System.out.println("Seat count updated!");
                    else
                        System.out.println("Seat count not updated");
                    break;
                case 5:
                    if(updateGymOwnerDetails())
                        System.out.println("Gym owner updated successfully!");
                    else
                        System.out.println("Update was unsuccessful");
                    break;
                case 6:
                    return true;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    void addGym(String email) {
        Gym gym = new Gym();
        int userId = userServiceOperations.getUserIdByEmail(email);
        gym.setOwnerId(userId);

        System.out.println("Enter details of the gym: ");
        System.out.println("Name: ");
        String gymName = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Location: ");
        String location = scanner.nextLine();
        String gymStatus = "unverified";

        gym.setGymAddress(address);
        gym.setLocation(location);
        gym.setGymName(gymName);
        gym.setStatus(gymStatus);

        List<Slots> slots = new ArrayList<>();
        System.out.println("Please enter number of slots: ");
        int slotCount = Integer.parseInt(scanner.nextLine());
        int currentCount = 1;
        while (currentCount <= slotCount) {
            System.out.println("Add for slot number " + currentCount + ": ");
            System.out.println("Enter start time: ");
            int startTime = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter available seats: ");
            int seatCount = Integer.parseInt(scanner.nextLine());
            Slots slot = new Slots(currentCount - 1, startTime, seatCount);
            slots.add(slot);
            currentCount++;
        }

        gym.setSlots(slots);
        if(gymService.addGym(gym))
            System.out.println("Gym added successfully!");
        else
            System.out.println("Gym already exists!");
    }
    
    void createGymOwner() {
        System.out.println("Enter gym owner details:");
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println("Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNo = scanner.nextLine();
        System.out.println("National ID: ");
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

        if(gymOwnerServiceOperations.createGymOwner(gymOwner)) {
            System.out.println("Gym Owner Created!");
        } else {
            System.out.println("Gym Owner Creation Failed!");
        }
    }

    boolean updateGymOwnerDetails() {
        System.out.println("Enter gym owner details:");
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println("Name: ");
        String ownerName = scanner.nextLine();
        // System.out.println("Password: ");
        // String password = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNo = scanner.nextLine();
        // System.out.println("National ID: ");
        // String nationalId = scanner.nextLine();

        // if (nationalId.length() != 12) {
            // System.out.println("Invalid national ID! Length must be 12");
            // return;
        // }

        // System.out.println("GST: ");
        // String GST = scanner.nextLine();
        // System.out.println("PAN Number: ");
        // String PAN = scanner.nextLine();
        // String gymOwnerStatus = "unverified";

        // if (PAN.length() != 10) {
            // System.out.println("Invalid PAN Card Number. Length must be 10");
            // return;
        // }

        GymOwner gymOwner = new GymOwner();
        // List<Gym> emptyGymList = new ArrayList<>();
        gymOwner.setOwnerEmail(ownerEmail);
        // gymOwner.setPAN(PAN);
        gymOwner.setOwnerName(ownerName);
        // gymOwner.setGST(GST);
        // gymOwner.setPassword(password);
        // gymOwner.setNationalId(nationalId);
        gymOwner.setPhoneNo(phoneNo);
        // gymOwner.setGyms(emptyGymList);
        // gymOwner.setStatus(gymOwnerStatus);

        return gymOwnerServiceOperations.updateGymOwner(gymOwner);
    }

    public boolean updatePassword(String userMail, String password, String updatedPassword) {
        return gymOwnerServiceOperations.updateGymOwnerPassword(userMail, password, updatedPassword);
    }

    void displayGyms(String email) {
        int userId = userServiceOperations.getUserIdByEmail(email);
        List<Gym> gymsList = gymOwnerServiceOperations.viewMyGyms(userId); // get all gyms from GymOwnerService
        for (Gym gym : gymsList) {
            System.out.println("Gym " + gym.getGymId() + ": ");
            System.out.println("Name: " + gym.getGymName() + "\nAddress: " + gym.getGymAddress() + "\nLocation: " + gym.getLocation());
            System.out.println("Slots: ");
            for (Slots slot : gym.getSlots()) {
                System.out.println("Slot: " + slot.getSlotsId() + "\nSlot Time: " + slot.getStartTime() + " - " + (slot.getStartTime() + 1) + "\nSeats: " + slot.getSeatCount());
            }
            System.out.println("-------------------------------------------------------------");
        }
    }
}