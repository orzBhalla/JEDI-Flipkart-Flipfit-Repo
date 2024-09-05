package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.Scanner;


public class FlipFitGymCustomerClientMenu {
    static Scanner scanner = new Scanner(System.in);
    User user = new User();

    public boolean userLogin(String username, String pass) {
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful!");
            while (flag) {
                System.out.println("-------------CUSTOMER MENU-------------");
                System.out.println("Press 1 to view all gyms with slots");
                System.out.println("Press 2 to book slot");
                System.out.println("Press 3 to cancel slot");
                System.out.println("Press 4 to view all bookings");
                System.out.println("Press 5 to view all gyms by area");
                System.out.println("Press 6 to update your details");
                System.out.println("Press 7 to logout");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Gym> gyms1 = viewAllGymsWithSlots();
                        printGyms(gyms1);
                        break;
                    case 2:
                        List<Gym> gyms2 = viewAllGymsWithSlots();
                        printGyms(gyms2);
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID:");
                        int gymId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Slot Time:");
                        int time = Integer.parseInt(scanner.nextLine());

                        if (bookSlot(gymId, time, username)) {
                            System.out.println("Booked successfully!");
                        } else {
                            System.out.println("Booking unsuccessful");
                        }
                        break;
                    case 3:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("My Bookings:");
                        System.out.println(viewAllBookings(username));
                        System.out.println("Enter Booking ID:");
                        int bookingId = sc.nextInt();
                        cancelSlot(bookingId);
                        break;
                    case 4:
                        System.out.println("My Bookings:");
                        List<Bookings> bookings = viewAllBookings(username);
                        for (Bookings booking : bookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() +
                                    ", Status: " + booking.getStatus() + ", Time: "
                                    + booking.getTime() + ", Gym ID: " + booking.getGymId());
                        }
                        break;
                    case 5:
                        String location = "bangalore"; // can modify this to take user input for location
                        List<Gym> gyms3 = viewAllGymsByArea(location);
                        printGyms(gyms3);
                        break;
                    case 6:
                        // update user details
                        break;
                    case 7:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong choice!");
                }
            }
        } else
            return false;
        return true;
    }

    private void printGyms(List<Gym> y) {
        for (Gym gym : y) {
            System.out.println("--------------------------------");
            System.out.println("Gym Name: " + gym.getGymName() +
                    ", ID: " + gym.getGymId() +
                    ", Location: " + gym.getLocation() +
                    ", Address: " + gym.getGymAddress());
            System.out.println("Slot List:");

            String leftAlignFormat = "| %-15d | %-15d | %-20d |%n";
            System.out.format("+-----------------+-----------------+----------------------+\n");
            System.out.format("| Start Time      |   End Time      | Remaining Seats      |\n");
            System.out.format("+-----------------+-----------------+----------------------+\n");

            for (Slots slot : gym.getSlots()) {
                System.out.format(leftAlignFormat, slot.getStartTime(), (slot.getStartTime() + 1), slot.getSeatCount());
            }
            System.out.format("+-----------------+-----------------+----------------------+\n");
        }
    }

    public boolean validateUser(String username, String pass) {
        return true;
    }

    List<Gym> viewAllGymsWithSlots() {
        System.out.println("List of gyms:");
        List<Gym> gymList = new ArrayList<>(); // get list of all gyms from service layer
        return gymList;
    }

    public boolean bookSlot(int gymId, int time, String email) {
        return true;
    }

    public void cancelSlot(int bookingId) {
        System.out.println("Slot Cancelled!");
        // use service layer to cancel
    }

    public List<Bookings> viewAllBookings(String userid) {
        List<Bookings> myBookings = new ArrayList<>(); // get list of all bookings from service layer
        return myBookings;
    }

    List<Gym> viewAllGymsByArea(String location) {
        System.out.println("List of gyms:");
        List<Gym> gymList = new ArrayList<>(); // get list of all gyms from service layer
        return gymList;
    }

    public void createCustomer() {
        System.out.println("Your Email: ");
        String ownerEmail = scanner.nextLine();
        System.out.println("Your Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNo = scanner.nextLine();
        System.out.println("Enter Address: ");
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
    }
}
