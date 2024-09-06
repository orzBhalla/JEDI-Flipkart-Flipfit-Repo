package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.GymServiceOperations;
import com.flipkart.business.UserServiceOperations;
import static com.flipkart.constants.ColorConstants.*;

import java.util.ArrayList;
import java.util.Scanner;


public class FlipFitGymCustomerClientMenu {
    Scanner scanner = new Scanner(System.in);
    User user = new User();
    UserServiceOperations userServiceOperations = new UserServiceOperations();
    GymServiceOperations gymServiceOperations = new GymServiceOperations();

    public boolean userLogin(String email, String pass) {
        if (validateUser(email, pass)) {
            boolean isLoggedIn = true;
            System.out.println("Login Successful! (Customer)");
            while (isLoggedIn) {
                System.out.println(ANSI_RED+"-------------CUSTOMER MENU-------------");
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
                        System.out.println("Enter the following: ");
                        System.out.println("Gym ID: ");
                        int gymId = Integer.parseInt(scanner.nextLine());;
                        System.out.println("Slot Time: ");
                        int time = Integer.parseInt(scanner.nextLine());;

                        if (bookSlot(gymId, time, email)) {
                            System.out.println("Booked successfully!");
                        } else {
                            System.out.println("Booking unsuccessful");
                        }
                        break;
                    case 3:
                        System.out.println("My Bookings: ");
                        System.out.println(viewAllBookings(email));
                        System.out.println("Enter Booking ID: ");
                        int bookingId = Integer.parseInt(scanner.nextLine());
                        if(cancelSlot(bookingId))
                            System.out.println("Booking cancelled!");
                        else
                            System.out.println("Booking not cancelled!");
                        break;
                    case 4:
//                        System.out.println("My Bookings: ");
//                        List<Bookings> bookings = viewAllBookings(email);
//                        for (Bookings booking : bookings) {
//                            System.out.println("Booking ID: " + booking.getBookingId() +
//                                    ", Status: " + booking.getBookingStatus() + ", Time: "
//                                    + booking.getTime() + ", Gym ID: " + booking.getGymId());
//                            System.out.println("-------------------------------------------------------------");
//                        }
                        System.out.println("My Bookings: ");
                        List<Bookings> bookings = viewAllBookings(email);
                        if(bookings.isEmpty()) {
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
                        String location = scanner.nextLine(); // can modify this to take user input for location
                        List<Gym> gyms3 = viewAllGymsByArea(location);
                        printGyms(gyms3);
                        break;
                    case 6:
                        if(updateUserDetails())
                            System.out.println("User updated successfully!");
                        else
                            System.out.println("Update was unsuccessful");
                        break;
                    case 7:
                        isLoggedIn = false;
                        break;
                    default:
                        System.out.println("Wrong choice!");
                }
            }
        } else
            return false;
        return true;
    }

//    private void printGyms(List<Gym> y) {
//        for (Gym gym : y) {
//
//            System.out.println("Gym ID: " + gym.getGymId() +
//                    ", Name: " + gym.getGymName() +
//                    ", Location: " + gym.getLocation() +
//                    ", Address: " + gym.getGymAddress() +
//                    ", Status: " + gym.getStatus());
//            System.out.println("Slot List:");
//
//            String leftAlignFormat = "| %-15d | %-15d | %-20d |%n";
//            System.out.format("+-----------------+-----------------+----------------------+\n");
//            System.out.format("| Start Time      |   End Time      | Remaining Seats      |\n");
//            System.out.format("+-----------------+-----------------+----------------------+\n");
//
//            for (Slots slot : gym.getSlots()) {
//                System.out.format(leftAlignFormat, slot.getStartTime(), (slot.getStartTime() + 1), slot.getSeatCount());
//            }
//            System.out.format("+-----------------+-----------------+----------------------+\n");
//        }
//    }
private void printGyms(List<Gym> gyms) {
    if(gyms.isEmpty()) {
        System.out.println("No gyms found.");
        return;
    }

    String gymLeftAlignFormat = "| %-5d | %-20s | %-20s | %-40s | %-15s |%n";
    System.out.println("Gym List:");
    System.out.format("+-------+----------------------+----------------------+------------------------------------------+------------------+\n");
    System.out.format("| Gym ID|     Name             |     Location         |           Address                         |     Status       |\n");
    System.out.format("+-------+----------------------+----------------------+------------------------------------------+------------------+\n");

    for (Gym gym : gyms) {
        System.out.format(gymLeftAlignFormat, gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymAddress(), gym.getStatus());
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
        return gymServiceOperations.getAllGymsWithSlots(); // get list of all gyms from service layer
    }

    public boolean bookSlot(int gymId, int time, String email) {
        return userServiceOperations.bookSlot(gymId, time, email);
    }

    public boolean cancelSlot(int bookingId) {
        // use service layer to cancel
        return gymServiceOperations.cancelBooking(bookingId);
    }

    public List<Bookings> viewAllBookings(String email) {
        // get list of all bookings from service layer
        int userId = userServiceOperations.getUserIdByEmail(email);
        return gymServiceOperations.showBookings(userId);
    }

    List<Gym> viewAllGymsByArea(String location) {
        // get list of all gyms from service layer
        return gymServiceOperations.getAllGymsByArea(location);
    }

    public void createCustomer() {
        System.out.println("Enter customer details: ");
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println("Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNo = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Location: ");
        String location = scanner.nextLine();

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(address);
        user.setLocation(location);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        if(userServiceOperations.createUser(user))
            System.out.println("User created!");
        else
            System.out.println("User not created!");
    }

    public boolean updateUserDetails() {
        System.out.println("Enter customer details: ");
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println("Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Phone Number: ");
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


