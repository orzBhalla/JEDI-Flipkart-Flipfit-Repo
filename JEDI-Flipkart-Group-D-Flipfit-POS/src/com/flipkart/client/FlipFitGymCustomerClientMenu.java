package com.flipkart.client;

import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.PaymentsServiceOperations;
import com.flipkart.business.UserServiceOperations;
import com.flipkart.validator.ValidateCredential;
import com.flipkart.validator.ValidateIdentity;

import static com.flipkart.constants.ColorConstants.*;

import java.util.Scanner;


public class FlipFitGymCustomerClientMenu {
    Scanner scanner = new Scanner(System.in);
    UserServiceOperations userServiceOperations = new UserServiceOperations();
    ValidateCredential validateCredential = new ValidateCredential();
    PaymentsServiceOperations payerServiceOperations = new PaymentsServiceOperations();
    ValidateIdentity validateIdentity = new ValidateIdentity();

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
                System.out.println("Press 6 to view a slot's availability");
                System.out.println("Press 7 to update your details");
                System.out.println("Press 8 to logout" + ANSI_RESET);
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
                        if(!validateIdentity.validateId(gymId)) {
                            System.out.println(ANSI_RED + "Gym ID invalid!" + ANSI_RESET);
                            break;
                        }
                        System.out.println(ANSI_GREEN + "Slot Time: " + ANSI_RESET);
                        int time = Integer.parseInt(scanner.nextLine());

                        if (bookSlot(gymId, time, email)) {
                            System.out.println(ANSI_CYAN + "Slot booked successfully!" + ANSI_RESET);
                        }
                        break;
                    case 3:
                        viewAllBookings(email);
                        System.out.println(ANSI_RED + "Enter Booking ID: " + ANSI_RESET);
                        int bookingId = Integer.parseInt(scanner.nextLine());
                        if(!validateIdentity.validateId(bookingId)) {
                            System.out.println(ANSI_RED + "Booking ID invalid!" + ANSI_RESET);
                            break;
                        }
                        if (cancelSlot(bookingId))
                            System.out.println(ANSI_CYAN + "Booking cancelled successfully!" + ANSI_RESET);
                        else
                            System.out.println(ANSI_CYAN + "Booking cancellation failed." + ANSI_RESET);
                        break;
                    case 4:
                        viewAllBookings(email);
                        break;
                    case 5:
                        String location = scanner.nextLine();
                        List<Gym> gyms3 = viewAllGymsByArea(location);
                        printGyms(gyms3);
                        break;
                    case 6:
                        System.out.println(ANSI_RED + "Enter gym ID: " + ANSI_RESET);
                        int _gymId = Integer.parseInt(scanner.nextLine());
                        if(!validateIdentity.validateId(_gymId)) {
                            System.out.println(ANSI_RED + "Gym ID invalid!" + ANSI_RESET);
                            break;
                        }
                        System.out.println(ANSI_RED + "Enter start time: " + ANSI_RESET);
                        int _startTime = Integer.parseInt(scanner.nextLine());
                        int availableSeatCount = userServiceOperations.getSeatCount(_gymId, _startTime);
                        if(availableSeatCount == -1) {
                            System.out.println("Seat count is not available. Please try again." + ANSI_RESET);
                            break;
                        }
                        System.out.println(ANSI_GREEN + "Available seat count: " + availableSeatCount + ANSI_RESET);
                        break;
                    case 7:
                        if (updateUserDetails())
                            System.out.println(ANSI_RED + "User updated successfully!" + ANSI_RESET);
                        else
                            System.out.println(ANSI_RED + "User update was unsuccessful" + ANSI_RESET);
                        break;
                    case 8:
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

    public boolean collectAndValidateCardDetails() {
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Enter expiry date (MM/YY): ");
        String expiryDate = scanner.nextLine();

        System.out.print("Enter cardholder's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();

        Payments payments = new Payments();
        payments.setCardNumber(cardNumber);
        payments.setExpiryDate(expiryDate);
        payments.setName(name);
        payments.setCvv(cvv);

        return payerServiceOperations.validateCardDetails(payments);
    }

    public boolean processPayments() {
        return collectAndValidateCardDetails();
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

    public void viewAllBookings(String email) {
        System.out.println(ANSI_BOLD + ANSI_RED + "My Bookings: " + ANSI_RESET);
        int userId = userServiceOperations.getUserIdByEmail(email);
        if (userId == -1) {
            System.out.println("No such user exists with email: " + email);
            return;
        }
        List<Bookings> bookings = userServiceOperations.viewAllBookings(userId);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            String leftAlignFormat = "| %-10s | %-15s | %-10s | %-10s | %n";
            System.out.format("+------------+---------------+------------+------------+\n");
            System.out.format("| Booking ID |     Status    |    Time    |  Gym ID    |\n");
            System.out.format("+------------+---------------+------------+------------+\n");

            for (Bookings booking : bookings) {
                System.out.format(leftAlignFormat, booking.getBookingId(), booking.getBookingStatus(), booking.getTime(), booking.getGymId());
            }
            System.out.format("+------------+---------------+------------+------------+\n");
        }
    }

    List<Gym> viewAllGymsByArea(String location) {
        return userServiceOperations.viewAllGymsByArea(location);
    }

    public void createCustomer() {
        System.out.println(ANSI_BLUE + "Enter customer details: " + ANSI_RESET);
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        if(!validateCredential.validateEmail(ownerEmail)){
            System.out.println(ANSI_RED + "Invalid Email address! Try Again!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_BLUE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Password: " + ANSI_RESET);
        String password = scanner.nextLine();
        if(!validateCredential.validatePassword(password)){
            System.out.println(ANSI_RED + "Password length should be in between 10 to 20" + ANSI_RESET);
            System.out.println(ANSI_RED + "It must also contain a number, lowercase, uppercase and special character." + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_BLUE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        if(!validateIdentity.validatePhoneNumber(phoneNo)){
            System.out.println(ANSI_RED + "Phone Number invalid! Try again!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_BLUE + "Address: " + ANSI_RESET);
        String address = scanner.nextLine();
        if(!validateIdentity.validateAddress(address)){
            System.out.println(ANSI_RED + "Address invalid! Try again!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_BLUE + "Location: " + ANSI_RESET);
        String location = scanner.nextLine();
        if(!validateIdentity.validateLocation(location)){
            System.out.println(ANSI_RED + "Location invalid! Try again!" + ANSI_RESET);
            return;
        }

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
        if(!validateCredential.validateEmail(ownerEmail)){
            System.out.println(ANSI_RED + "Invalid Email address! Try Again!" + ANSI_RESET);
            return false;
        }
        System.out.println(ANSI_PURPLE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_PURPLE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        if(!validateIdentity.validatePhoneNumber(phoneNo)){
            System.out.println(ANSI_RED + "Phone Number invalid! Try again!" + ANSI_RESET);
            return false;
        }
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


