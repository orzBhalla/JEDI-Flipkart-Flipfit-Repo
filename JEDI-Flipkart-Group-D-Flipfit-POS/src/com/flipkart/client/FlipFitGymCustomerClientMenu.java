package com.flipkart.client;

import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.UserServiceOperations;

import static com.flipkart.constants.ColorConstants.*;

import java.util.Scanner;


public class FlipFitGymCustomerClientMenu {
    Scanner scanner = new Scanner(System.in);
    UserServiceOperations userServiceOperations = new UserServiceOperations();

    public boolean userLogin(String email, String password) {
        if (validateUser(email, password)) {
            boolean isLoggedIn = true;
            System.out.println(ANSI_BOLD + "Login Successful! (Customer)" + ANSI_RESET);
            while (isLoggedIn) {
                System.out.println(ANSI_RED + "-------------CUSTOMER MENU-------------");
                System.out.println("Press 1 to view all gyms with slots");
                System.out.println("Press 2 to book slot");
                System.out.println("Press 3 to cancel slot");
                System.out.println("Press 4 to view all bookings");
                System.out.println("Press 5 to view all gyms by area");
                System.out.println("Press 6 to update your details");
                System.out.println("Press 7 to logout" + ANSI_RESET);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Gym> gyms1 = viewAllGymsWithSlots();
                        printGyms(gyms1);
                        break;
                    case 2:
                        List<Gym> gyms2 = viewAllGymsWithSlots();
                        printGyms(gyms2);
                        System.out.println(ANSI_BOLD + ANSI_RED + "Enter the following: " + ANSI_RESET);
                        System.out.println(ANSI_CYAN + "Gym ID: " + ANSI_RESET);
                        int gymId = Integer.parseInt(scanner.nextLine());
                        ;
                        System.out.println(ANSI_GREEN + "Slot Time: " + ANSI_RESET);
                        int time = Integer.parseInt(scanner.nextLine());
                        ;

                        if (bookSlot(gymId, time, email)) {
                            System.out.println(ANSI_CYAN + "Booked successfully!" + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_CYAN + "Booking unsuccessful" + ANSI_RESET);
                        }
                        break;
                    case 3:
                        System.out.println(ANSI_GREEN + "My Bookings: " + ANSI_RESET);
                        System.out.println(viewAllBookings(email));
                        System.out.println(ANSI_RED + "Enter Booking ID: " + ANSI_RESET);
                        int bookingId = Integer.parseInt(scanner.nextLine());
                        if (cancelSlot(bookingId))
                            System.out.println(ANSI_CYAN + "Booking cancelled!" + ANSI_RESET);
                        else
                            System.out.println(ANSI_CYAN + "Booking not cancelled!" + ANSI_RESET);
                        break;
                    case 4:
                        System.out.println(ANSI_BOLD + ANSI_RED + "My Bookings: " + ANSI_RESET);


                        List<Bookings> bookings = viewAllBookings(email);
                        if (bookings.isEmpty()) {
                            System.out.println("No bookings found.");
                        } else {
                            String leftAlignFormat = "| %-10s | %-15s | %-10s | %-10s |%n";
                            System.out.format("+------------+---------------+------------+------------+");
                            System.out.format("| Booking ID |     Status    |    Time    |  Gym ID    |");
                            System.out.format("+------------+---------------+------------+------------+");

                            for (Bookings booking : bookings) {
                                System.out.format(leftAlignFormat, booking.getBookingId(), booking.getBookingStatus(), booking.getTime(), booking.getGymId());
                            }
                            System.out.format("+------------+---------------+------------+------------+\n");
                        }
                        break;
                    case 5:
                        String location = scanner.nextLine();
                        List<Gym> gyms3 = viewAllGymsByArea(location);
                        printGyms(gyms3);
                        break;
                    case 6:
                        if (updateUserDetails())
                            System.out.println(ANSI_RED + "User updated successfully!" + ANSI_RESET);
                        else
                            System.out.println(ANSI_RED + "Update was unsuccessful" + ANSI_RESET);
                        break;
                    case 7:
                        isLoggedIn = false;
                        break;
                    default:
                        System.out.println(ANSI_BOLD + ANSI_RED + "Wrong choice!" + ANSI_RESET);
                }
            }
        } else
            return false;
        return true;
    }


    private void printGyms(List<Gym> gyms) {
        if (gyms.isEmpty()) {
            System.out.println("No gyms found.");
            return;
        }

        String gymLeftAlignFormat = "| %-5d | %-20s | %-20s | %-40s | %-15s |%n";
        System.out.println("Gym List:");

        for (Gym gym : gyms) {
            System.out.format("+-------+----------------------+----------------------+------------------------------------------+------------------+\n");
            System.out.format("| Gym ID|     Name             |     Location         |           Address                         |     Status       |\n");
            System.out.format("+-------+----------------------+----------------------+------------------------------------------+------------------+\n");
            System.out.format(gymLeftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymAddress(), gym.getStatus());
            System.out.format("+-------+----------------------+----------------------+------------------------------------------+------------------+\n");

            System.out.println("Slot List:");
            String slotLeftAlignFormat = "| %-15s | %-15s | %-15d |%n";
            System.out.format("+-----------------+-----------------+-----------------+\n");
            System.out.format("| Start Time      |   End Time      | Remaining Seats |\n");
            System.out.format("+-----------------+-----------------+-----------------+\n");

            for (Slots slot : gym.getSlots()) {
                System.out.format(slotLeftAlignFormat, slot.getStartTime(), (slot.getStartTime() + 1), slot.getSeatCount());
            }
            System.out.format("+-----------------+-----------------+-----------------+\n");
            System.out.println();
        }
    }

    public boolean validateUser(String email, String password) {
        return userServiceOperations.validateUser(email, password);
    }

    List<Gym> viewAllGymsWithSlots() {
        return userServiceOperations.viewAllGymsWithSlots();
    }

    public boolean bookSlot(int gymId, int startTime, String email) {
        return userServiceOperations.bookSlot(gymId, startTime, email);
    }

    public boolean cancelSlot(int bookingId) {
        return userServiceOperations.cancelSlot(bookingId);
    }

    public List<Bookings> viewAllBookings(String email) {
        int userId = userServiceOperations.getUserIdByEmail(email);
        return userServiceOperations.viewAllBookings(userId);
    }

    List<Gym> viewAllGymsByArea(String location) {
        return userServiceOperations.viewAllGymsByArea(location);
    }

    public void createCustomer() {
        System.out.println(ANSI_BLUE + "Enter customer details: " + ANSI_RESET);
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Password: " + ANSI_RESET);
        String password = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Address: " + ANSI_RESET);
        String address = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Location: " + ANSI_RESET);
        String location = scanner.nextLine();

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(address);
        user.setLocation(location);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        if (userServiceOperations.createUser(user))
            System.out.println("User created!");
        else
            System.out.println("User not created!");
    }

    public boolean updateUserDetails() {
        System.out.println(ANSI_PURPLE + "Enter customer details: " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Email: " + ANSI_RESET);
        String ownerEmail = scanner.nextLine();
        System.out.println(ANSI_PURPLE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_PURPLE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        // System.out.println("Address: ");
        // String address = scanner.nextLine();
        // System.out.println("Location: ");
        // String location = scanner.nextLine();

        User user = new User();
        user.setEmail(ownerEmail);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        return userServiceOperations.updateUserDetails(user);
    }

    public boolean updatePassword(String userMail, String password, String updatedPassword) {
        return userServiceOperations.updateGymUserPassword(userMail, password, updatedPassword);
    }
}


