package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.GymOwnerServiceOperations;
import com.flipkart.validator.ValidateCredential;
import com.flipkart.validator.ValidateIdentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.constants.ColorConstants.*;
import static com.flipkart.utils.DateAndTime.displayCurrentDate;

public class FlipFitGymOwnerClientMenu {
    private Scanner scanner = new Scanner(System.in);
    private GymOwnerServiceOperations gymOwnerServiceOperations = new GymOwnerServiceOperations();
    private ValidateCredential validateCredential = new ValidateCredential();
    private ValidateIdentity validateIdentity = new ValidateIdentity();

    /// Verifies if the provided email and password match a registered gym owner.
    /// @param email Gym owner's email address.
    /// @param password Gym owner's password.
    /// @return true if the credentials are valid, false otherwise.
    boolean verifyGymOwner(String email, String password) {
        return gymOwnerServiceOperations.validateGymOwner(email, password);
    }

    /// Handles the gym owner login process and displays the menu options.
    /// @param email Gym owner's email address.
    /// @param password Gym owner's password.
    /// @return true if logout is successful, false otherwise.
    public boolean gymOwnerLogin(String email, String password) {
        if (!verifyGymOwner(email, password)) {
            return false;
        }
        System.out.println(ANSI_BOLD + "Login Successful! (Gym Owner)" + ANSI_RESET);
        displayCurrentDate();
        while (true) {
            System.out.println(ANSI_BOLD + ANSI_PURPLE + "-----------------Gym Owner Menu-----------------" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Press 1 to add a gym");
            System.out.println("Press 2 to update gym details");
            System.out.println("Press 3 to view all gyms");
            System.out.println("Press 4 to add slots");
            System.out.println("Press 5 to update seat count by");
            System.out.println("Press 6 to update your details");
            System.out.println("Press 7 to logout" + ANSI_RESET);

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addGym(email);
                    break;
                case 2:
                    updateGym(email);
                    break;
                case 3:
                    displayGyms(email);
                    break;
                case 4:
                    addSlots();
                    break;
                case 5:
                    updateSeatCount(email);
                    break;
                case 6:
                    if (updateGymOwnerDetails())
                        System.out.println(ANSI_BLUE + "Gym owner updated successfully!" + ANSI_RESET);
                    else
                        System.out.println(ANSI_BLUE + "Gym owner not updated" + ANSI_RESET);
                    break;
                case 7:
                    return true;
                default:
                    System.out.println(ANSI_BLUE + "Invalid option!" + ANSI_RESET);
            }
        }
    }

    /// Adds a new gym to the system.
    /// @param email Gym owner's email address (used to fetch the owner ID).
    private void addGym(String email) {
        Gym gym = new Gym();
        int gymOwnerId = gymOwnerServiceOperations.getGymOwnerIdByEmail(email);
        if (gymOwnerId == -1) {
            System.out.println("No such gym owner exists with email: " + email);
            return;
        }
        gym.setOwnerId(gymOwnerId);

        System.out.println(ANSI_BOLD + ANSI_YELLOW + "Enter details of the gym: " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Name: " + ANSI_RESET);
        String gymName = scanner.nextLine();
        System.out.println(ANSI_PURPLE + "Address: " + ANSI_RESET);
        String address = scanner.nextLine();
        if (!validateIdentity.validateAddress(address)) {
            System.out.println(ANSI_RED + "Invalid address!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_PURPLE + "Location: " + ANSI_RESET);
        String location = scanner.nextLine();
        if (!validateIdentity.validateLocation(location)) {
            System.out.println(ANSI_RED + "Invalid location!" + ANSI_RESET);
            return;
        }
        String gymStatus = "unverified";

        gym.setGymAddress(address);
        gym.setLocation(location);
        gym.setGymName(gymName);
        gym.setStatus(gymStatus);

        List<Slots> slots = new ArrayList<>();
        System.out.println(ANSI_PURPLE + "Please enter number of slots: " + ANSI_RESET);
        int slotCount = Integer.parseInt(scanner.nextLine());
        if (!validateIdentity.validateSlots(slotCount)) {
            System.out.println(ANSI_RED + "Invalid number of slots!" + ANSI_RESET);
            return;
        }
        int currentCount = 1;
        while (currentCount <= slotCount) {
            System.out.println("Add details for slot number " + currentCount + ": ");
            System.out.println("Enter start time: ");
            int startTime = Integer.parseInt(scanner.nextLine());
            if (!validateIdentity.validateTime(startTime)) {
                System.out.println(ANSI_RED + "Invalid start time!" + ANSI_RESET);
                continue;
            }
            System.out.println("Enter available seats: ");
            int seatCount = Integer.parseInt(scanner.nextLine());
            if (!validateIdentity.validateSlots(seatCount)) {
                System.out.println(ANSI_RED + "Invalid seat count!" + ANSI_RESET);
                continue;
            }
            Slots slot = new Slots(-1, startTime, seatCount);
            slots.add(slot);
            currentCount++;
        }

        gym.setSlots(slots);
        if (gymOwnerServiceOperations.addGym(gym))
            System.out.println(ANSI_PURPLE + "Gym added successfully!" + ANSI_RESET);
        else
            System.out.println(ANSI_PURPLE + "Gym could not be added!" + ANSI_RESET);
    }

    private void addSlots() {
        System.out.println(ANSI_CYAN + "Gym ID: " + ANSI_RESET);
        int gymId = Integer.parseInt(scanner.nextLine());
        if (!validateIdentity.validateId(gymId)) {
            System.out.println(ANSI_RED + "Gym ID invalid!" + ANSI_RESET);
            return;
        }
        List<Slots> slots = new ArrayList<>();
        System.out.println(ANSI_PURPLE + "Please enter number of slots: " + ANSI_RESET);
        int slotCount = Integer.parseInt(scanner.nextLine());
        if (!validateIdentity.validateSlots(slotCount)) {
            System.out.println(ANSI_RED + "Invalid number of slots!" + ANSI_RESET);
            return;
        }
        int currentCount = 1;
        while (currentCount <= slotCount) {
            System.out.println("Add details for slot number " + currentCount + ": ");
            System.out.println("Enter start time: ");
            int startTime = Integer.parseInt(scanner.nextLine());
            if (!validateIdentity.validateTime(startTime)) {
                System.out.println(ANSI_RED + "Invalid start time!" + ANSI_RESET);
                continue;
            }
            System.out.println("Enter available seats: ");
            int seatCount = Integer.parseInt(scanner.nextLine());
            if (!validateIdentity.validateSlots(seatCount)) {
                System.out.println(ANSI_RED + "Invalid seat count!" + ANSI_RESET);
                continue;
            }
            Slots slot = new Slots(-1, startTime, seatCount);
            slots.add(slot);
            currentCount++;
        }
        if(gymOwnerServiceOperations.addSlots(gymId, slots))
            System.out.println(ANSI_GREEN + "Gym added successfully!" + ANSI_RESET);
        else
            System.out.println(ANSI_RED + "Gym could not be added!" + ANSI_RESET);
    }

    /**
     * Handles the creation of a new gym owner account.
     */
    public void createGymOwner() {
        System.out.println(ANSI_BOLD + ANSI_YELLOW + "Enter gym owner details:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Email: " + ANSI_RESET);
        String ownerEmail = scanner.nextLine();
        if (!validateCredential.validateEmail(ownerEmail)) {
            System.out.println(ANSI_RED + "Invalid Email address! Try Again!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_YELLOW + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_YELLOW + "Password: " + ANSI_RESET);
        String password = scanner.nextLine();
        if (!validateCredential.validatePassword(password)) {
            System.out.println(ANSI_RED + "Password length should be between 10 to 20 characters and include numbers, lowercase, uppercase, and special characters." + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_YELLOW + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        if (!validateIdentity.validatePhoneNumber(phoneNo)) {
            System.out.println(ANSI_RED + "Phone Number invalid! Try again!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_YELLOW + "National ID: " + ANSI_RESET);
        String nationalId = scanner.nextLine();
        if (!ValidateIdentity.validateAadhaar(nationalId)) {
            System.out.println(ANSI_RED + "Aadhaar Card invalid! Try again!" + ANSI_RESET);
            return;
        }

        if (nationalId.length() != 12) {
            System.out.println(ANSI_YELLOW + "Invalid national ID! Length must be 12" + ANSI_RESET);
            return;
        }

        System.out.println(ANSI_YELLOW + "GST: " + ANSI_RESET);
        String GST = scanner.nextLine();
        if (!ValidateIdentity.GSTValidator.validateGST(GST)) {
            System.out.println(ANSI_YELLOW + "Invalid GST number!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_YELLOW + "PAN Number: " + ANSI_RESET);
        String PAN = scanner.nextLine();
        if (!ValidateIdentity.PANCardValidator.validatePAN(PAN)) {
            System.out.println(ANSI_RED + "PAN invalid! Try again!" + ANSI_RESET);
            return;
        }
        if (PAN.length() != 10) {
            System.out.println(ANSI_YELLOW + "Invalid PAN Card Number. Length must be 10" + ANSI_RESET);
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
        gymOwner.setVerificationStatus("unverified");

        if (gymOwnerServiceOperations.createGymOwner(gymOwner)) {
            System.out.println(ANSI_YELLOW + "Gym owner created!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_YELLOW + "Gym owner not created!" + ANSI_RESET);
        }
    }

    /// Updates the details of an existing gym owner.
    /// @return true if the update is successful, false otherwise.
    private boolean updateGymOwnerDetails() {
        System.out.println(ANSI_BLUE + ANSI_BOLD + "Enter gym owner details:" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Email: " + ANSI_RESET);
        String ownerEmail = scanner.nextLine();
        if (!validateCredential.validateEmail(ownerEmail)) {
            System.out.println(ANSI_RED + "Invalid Email address! Try Again!" + ANSI_RESET);
            return false;
        }
        System.out.println(ANSI_BLUE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        if (!validateIdentity.validatePhoneNumber(phoneNo)) {
            System.out.println(ANSI_RED + "Phone Number invalid! Try again!" + ANSI_RESET);
            return false;
        }

        GymOwner gymOwner = new GymOwner();
        gymOwner.setOwnerEmail(ownerEmail);
        gymOwner.setOwnerName(ownerName);
        gymOwner.setPhoneNo(phoneNo);

        return gymOwnerServiceOperations.updateGymOwner(gymOwner);
    }

    /// Updates the gym owner's password.
    /// @param userMail Gym owner's email address.
    /// @param password Current password.
    /// @param updatedPassword New password.
    /// @return true if the password update is successful, false otherwise.
    public boolean updatePassword(String userMail, String password, String updatedPassword) {
        return gymOwnerServiceOperations.updateGymOwnerPassword(userMail, password, updatedPassword);
    }

    /// Displays all gyms owned by the logged-in gym owner.
    /// @param email Gym owner's email address.
    private void displayGyms(String email) {
        int gymOwnerId = gymOwnerServiceOperations.getGymOwnerIdByEmail(email);
        if (gymOwnerId == -1) {
            System.out.println("No such gym owner exists with email: " + email);
            return;
        }

        List<Gym> gymsList = gymOwnerServiceOperations.viewMyGyms(gymOwnerId);
        if (gymsList.isEmpty()) {
            System.out.println("No gyms found for the gym owner with email: " + email);
            return;
        }

        String gymLeftAlignFormat = "| %-5d | %-20s | %-40s | %-20s |%n";
        String slotLeftAlignFormat = "| %-5d | %-15s | %-5d |%n";

        for (Gym gym : gymsList) {
            System.out.format("+-------+----------------------+------------------------------------------+----------------------+\n");
            System.out.format("| Gym ID|     Name             |           Address                        |     Location         |\n");
            System.out.format("+-------+----------------------+------------------------------------------+----------------------+\n");
            System.out.format(gymLeftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), gym.getLocation());
            System.out.format("+-------+----------------------+------------------------------------------+----------------------+\n");
            System.out.println("Slots: ");
            System.out.format("+-------+---------------+-------+\n");
            System.out.format("|Slot ID|     Time      | Seats |\n");
            System.out.format("+-------+---------------+-------+\n");

            for (Slots slot : gym.getSlots()) {
                System.out.format(slotLeftAlignFormat, slot.getSlotsId(), slot.getStartTime() + " - " + (slot.getStartTime() + 1), slot.getSeatCount());
            }
            System.out.format("+-------+---------------+-------+\n");
            System.out.println();
        }
    }

    /**
     * Updates the seat count for a specific gym and slot.
     */
    private void updateSeatCount(String email) {
        displayGyms(email);
        System.out.println(ANSI_BLUE + "Enter gym ID: " + ANSI_RESET);
        int gymId = Integer.parseInt(scanner.nextLine());

        System.out.println(ANSI_BLUE + "Enter start time: " + ANSI_RESET);
        int startTime = Integer.parseInt(scanner.nextLine());

        System.out.println(ANSI_BLUE + "Update seat count by: " + ANSI_RESET);
        int seatCount = Integer.parseInt(scanner.nextLine());

        if (gymOwnerServiceOperations.updateSeatCount(gymId, startTime, seatCount))
            System.out.println(ANSI_BLUE + "Seat count updated!" + ANSI_RESET);
        else
            System.out.println(ANSI_BLUE + "Seat count not updated" + ANSI_RESET);
    }

    /**
     * Updates the details of an existing gym.
     * @param email email of the gymOwner
     * @return true if gym details are updated successfully, false otherwise.
     * */
    public boolean updateGym(String email) {
        displayGyms(email);

        System.out.println(ANSI_BLUE + "Enter gym ID: " + ANSI_RESET);
        int gymId = Integer.parseInt(scanner.nextLine());

        System.out.println(ANSI_PURPLE + "Enter gym details: " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Name: " + ANSI_RESET);
        String gymName = scanner.nextLine();
        System.out.println(ANSI_PURPLE + "Gym Address: " + ANSI_RESET);
        String gymAddress = scanner.nextLine();
        if (!validateIdentity.validateAddress(gymAddress)) {
            System.out.println(ANSI_RED + "Address invalid! Try again!" + ANSI_RESET);
            return false;
        }
        System.out.println(ANSI_PURPLE + "Gym Location: " + ANSI_RESET);
        String gymALocation = scanner.nextLine();
        if (!validateIdentity.validateLocation(gymALocation)) {
            System.out.println(ANSI_RED + "Location invalid! Try again!" + ANSI_RESET);
            return false;
        }

        Gym gym = new Gym();
        gym.setGymName(gymName);
        gym.setGymAddress(gymAddress);
        gym.setLocation(gymALocation);
        gym.setGymId(gymId);

        return gymOwnerServiceOperations.updateGymDetails(gym);
    }
}