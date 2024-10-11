package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.AdminServiceOperations;
import com.flipkart.constants.AdminCredentials;

import java.util.List;

import static com.flipkart.constants.ColorConstants.ANSI_CYAN;
import static com.flipkart.constants.ColorConstants.ANSI_RESET;

/// Handles the menu operations for the admin in the FlipFit application.
/// Provides functionality for viewing gyms, gym owners, and unverified entities,
/// as well as verifying gyms, gym owners, and admin credentials.
///

public class FlipFitGymAdminMenu {

    /**
     * Service operations for admin tasks.
     */
    AdminServiceOperations adminServiceOperations = new AdminServiceOperations();

    /**
     * Credentials for admin login.
     */
    AdminCredentials adminCredentials = new AdminCredentials();

    /// Displays a list of gyms.
    /// Calls the viewGyms method from AdminServiceOperations.
    ///
    public void viewGyms() {
        List<Gym> gyms = adminServiceOperations.viewGyms();
        if (gyms.isEmpty()) {
            System.out.println("No gyms found.");
            return;
        }

        String leftAlignFormat = "| %-6s | %-20s | %-40s | %-20s | %-10s | %-10s |%n";
        System.out.format(ANSI_CYAN + "+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");
        System.out.format("| Gym ID |     Name             | Address                                | Location             | Owner ID | Status   |%n");
        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n" + ANSI_RESET);

        for (Gym gym : gyms) {
            System.out.format(leftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getGymAddress(), gym.getLocation(), gym.getOwnerId(), gym.getStatus());
        }
        System.out.format("+--------+----------------------+----------------------------------------+----------------------+----------+----------+%n");

    }

    /// Displays a list of users.
    /// Calls the viewUsers method from AdminServiceOperations.
    ///
    public void viewUsers() {
        List<User> users = adminServiceOperations.viewUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        String leftAlignFormat = "| %-8s | %-20s | %-30s | %-15s | %-20s | %-40s |%n";
        System.out.format(ANSI_CYAN + "+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
        System.out.format("| User ID  |     Name             | Email                         | Phone Number  | Location           | Address                              |%n");
        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n" + ANSI_RESET);

        for (User user : users) {
            System.out.format(leftAlignFormat, user.getUserId(), user.getUserName(), user.getEmail(), user.getPhoneNumber(), user.getLocation(), user.getAddress());
        }
        System.out.format("+----------+----------------------+-------------------------------+---------------+--------------------+--------------------------------------+%n");
    }

    /// Displays a list of gym owners.
    /// Calls the viewGymOwners method from AdminServiceOperations.
    ///
    public void viewGymOwners() {
        List<GymOwner> gymOwners = adminServiceOperations.viewGymOwners();
        if (gymOwners.isEmpty()) {
            System.out.println("No gym owners found.");
            return;
        }

        String leftAlignFormat = "| %-13s | %-20s | %-30s | %-15s | %-10s | %-20s | %-20s | %-20s |%n";
        System.out.format(ANSI_CYAN + "+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");
        System.out.format("| Gym Owner ID  |     Name             | Email                         | Phone Number  | GST        | National ID          | Verification Status  | PAN                  |%n");
        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n" + ANSI_RESET);

        for (GymOwner gymOwner : gymOwners) {
            System.out.format(leftAlignFormat, gymOwner.getOwnerId(), gymOwner.getOwnerName(), gymOwner.getOwnerEmail(), gymOwner.getPhoneNo(), gymOwner.getGST(), gymOwner.getNationalId(), gymOwner.getVerificationStatus(), gymOwner.getPAN());
        }
        System.out.format("+---------------+----------------------+-------------------------------+---------------+------------+----------------------+----------------------+----------------------+%n");

    }

    /// Verifies a gym by its ID.
    ///
    /// @param gymId ID of the gym to be verified.
    /// @return true if the gym is verified, false otherwise.
    public boolean verifyGym(int gymId) {
        return adminServiceOperations.verifyGym(gymId);
    }

    /// Verifies a gym owner by their ID.
    ///
    /// @param gymOwnerId ID of the gym owner to be verified.
    /// @return true if the gym owner is verified, false otherwise.
    public boolean verifyGymOwner(int gymOwnerId) {
        return adminServiceOperations.verifyGymOwner(gymOwnerId);
    }

    /// Displays a list of unverified gyms.
    /// Calls getUnverifiedGyms from AdminServiceOperations and formats the output for display.
    ///
    public void viewUnverifiedGyms() {
        List<Gym> gyms = adminServiceOperations.getUnverifiedGyms();
        if (gyms.isEmpty()) {
            System.out.println("No unverified gyms found.");
            return;
        }

        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
        System.out.format(ANSI_CYAN + "+-------+----------------------+--------+------------------------------------------+----------------------+------------------+%n");
        System.out.format("| S.No  |     Name             | Gym ID |           Address                        |   Location           |     Status       |%n");
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+%n" + ANSI_RESET);

        int gymCounter = 1;
        for (Gym g : gyms) {
            System.out.format(leftAlignFormat, gymCounter, g.getGymName(), g.getGymId(), g.getGymAddress(), g.getLocation(), g.getStatus());
            gymCounter++;
        }
        System.out.format("+-------+----------------------+--------+------------------------------------------+----------------------+------------------+%n");
    }

    /// Displays a list of unverified gym owners.
    /// Calls getUnverifiedGymOwners from AdminServiceOperations and formats the output for display.
    ///
    public void viewUnverifiedGymOwners() {
        List<GymOwner> gymOwnerList = adminServiceOperations.getUnverifiedGymOwners();
        if (gymOwnerList.isEmpty()) {
            System.out.println("No unverified gym owners found.");
            return;
        }

        String leftAlignFormat = "| %-5d | %-10d | %-20s | %-20s | %-15s |%n";
        System.out.format(ANSI_CYAN + "+-------+----------+----------------------+----------------------+------------------+%n");
        System.out.format("| S.No  | Owner ID |     Owner Name       |     Email            |     Status       |%n");
        System.out.format("+-------+----------+----------------------+----------------------+------------------+%n" + ANSI_RESET);

        int gymOwnerCounter = 1;
        for (GymOwner gymOwner : gymOwnerList) {
            System.out.format(leftAlignFormat, gymOwnerCounter, gymOwner.getOwnerId(), gymOwner.getOwnerName(), gymOwner.getOwnerEmail(), gymOwner.getVerificationStatus());
            gymOwnerCounter++;
        }
        System.out.format("+-------+----------+----------------------+----------------------+------------------+%n");
    }

    /// Verifies admin credentials.
    ///
    /// @param userMail Email of the admin.
    /// @param password Password of the admin.
    /// @return true if credentials match the predefined admin credentials, false otherwise.
    public boolean verifyAdminCredentials(String userMail, String password) {
        try {
            return userMail.equals(AdminCredentials.ADMIN_EMAIL) && password.equals(AdminCredentials.ADMIN_PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
