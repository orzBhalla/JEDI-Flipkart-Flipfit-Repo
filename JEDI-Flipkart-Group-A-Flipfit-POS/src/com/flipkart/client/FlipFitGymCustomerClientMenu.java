package com.flipkart.client;

import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.PaymentsServiceOperations;
import com.flipkart.business.UserServiceOperations;
import com.flipkart.validator.*;

import static com.flipkart.constants.ColorConstants.*;
import static com.flipkart.utils.DateAndTime.displayCurrentDate;

import java.util.Scanner;

/// Handles the customer menu operations for the FlipFit application.
/// Provides functionality for user login, viewing and managing gym slots, bookings,
/// and updating user details.
///
public class FlipFitGymCustomerClientMenu {

    /**
     * Scanner instance for user input.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Service operations for user-related tasks.
     */
    UserServiceOperations userServiceOperations = new UserServiceOperations();

    /**
     * Validator for user credentials.
     */
    ValidateCredential validateCredential = new ValidateCredential();

    /**
     * Service operations for payment-related tasks.
     */
    PaymentsServiceOperations payerServiceOperations = new PaymentsServiceOperations();

    /**
     * Validator for user identity.
     */
    ValidateIdentity validateIdentity = new ValidateIdentity();

    /**
     * Validator for card details.
     */
    ValidateCard validateCard = new ValidateCard();

    /**
     * Manages user login and displays the customer menu.
     *
     * @param email    User's email address.
     * @param password User's password.
     * @return true if login is successful, false otherwise.
     */
    public boolean userLogin(String email, String password) {
        if (validateUser(email, password)) {
            boolean isLoggedIn = true;
            System.out.println(ANSI_BOLD + "Customer Login Successful!!" + ANSI_RESET);
            displayCurrentDate();
            while (isLoggedIn) {
                System.out.println(ANSI_YELLOW + "-------------CUSTOMER MENU-------------");
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
                        if (gyms2.isEmpty()) {
                            break;
                        }
                        System.out.println(ANSI_BOLD + ANSI_RED + "Enter the following: " + ANSI_RESET);
                        System.out.println(ANSI_CYAN + "Gym ID: " + ANSI_RESET);
                        int gymId = Integer.parseInt(scanner.nextLine());
                        if (!validateIdentity.validateId(gymId)) {
                            System.out.println(ANSI_RED + "Gym ID invalid!" + ANSI_RESET);
                            break;
                        }
                        System.out.println(ANSI_GREEN + "Slot Time: " + ANSI_RESET);
                        int time = Integer.parseInt(scanner.nextLine());
                        if (processPayments()) {
                            System.out.println("Payment was successful");
                            if (bookSlot(gymId, time, email)) {
                                System.out.println(ANSI_CYAN + "Slot booked successfully!" + ANSI_RESET);
                            }
                        } else {
                            System.out.println("Payment failed. Please try again");
                        }
                        break;
                    case 3:
                        if (!viewAllBookings(email)) {
                            break;
                        }
                        System.out.println(ANSI_RED + "Enter Booking ID: " + ANSI_RESET);
                        int bookingId = Integer.parseInt(scanner.nextLine());
                        if (!validateIdentity.validateId(bookingId)) {
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
                        System.out.println(ANSI_RED + "Enter location you want find gyms in: " + ANSI_RESET);
                        String location = scanner.nextLine();
                        List<Gym> gyms3 = viewAllGymsByArea(location);
                        printGyms(gyms3);
                        break;
                    case 6:
                        System.out.println(ANSI_RED + "Enter gym ID: " + ANSI_RESET);
                        int _gymId = Integer.parseInt(scanner.nextLine());
                        if (!validateIdentity.validateId(_gymId)) {
                            System.out.println(ANSI_RED + "Gym ID invalid!" + ANSI_RESET);
                            break;
                        }
                        System.out.println(ANSI_RED + "Enter start time: " + ANSI_RESET);
                        int _startTime = Integer.parseInt(scanner.nextLine());
                        int availableSeatCount = userServiceOperations.getSeatCount(_gymId, _startTime);
                        if (availableSeatCount == -1) {
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
        } else {
            return false;
        }
        return true;
    }

    /**
     * Prints the list of gyms and their slots.
     *
     * @param gyms List of gyms to be printed.
     */
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
                if (slot.getSeatCount() > 0)
                    System.out.format(slotLeftAlignFormat, slot.getStartTime(), (slot.getStartTime() + 1), slot.getSeatCount());
            }
            System.out.format("+-----------------+-----------------+-----------------+\n");
            System.out.println();
        }
    }

    /**
     * Validates user credentials.
     *
     * @param email    User's email address.
     * @param password User's password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean validateUser(String email, String password) {
        return userServiceOperations.validateUser(email, password);
    }

    /**
     * Collects and validates card details for payment.
     *
     * @return true if card details are valid, false otherwise.
     */
    public boolean collectAndValidateCardDetails() {
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();
        if (!validateCard.validateCardNumber(cardNumber)) {
            System.out.println(ANSI_RED + "Card number invalid!" + ANSI_RESET);
            return false;
        }
        System.out.print("Enter expiry date (MM/YY): ");
        String expiryDate = scanner.nextLine();
        if (!validateCard.validateExpiryDate(expiryDate)) {
            System.out.println(ANSI_RED + "Expiry Date invalid!" + ANSI_RESET);
            return false;
        }

        System.out.print("Enter cardholder's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();
        if (!validateCard.validateCVV(cvv)) {
            System.out.println(ANSI_RED + "CVV invalid!" + ANSI_RESET);
            return false;
        }

        Payments payments = new Payments();
        payments.setCardNumber(cardNumber);
        payments.setExpiryDate(expiryDate);
        payments.setName(name);
        payments.setCvv(cvv);

        return payerServiceOperations.validateCardDetails(payments);
    }

    /**
     * Processes the payment by collecting and validating card details.
     *
     * @return true if payment is successful, false otherwise.
     */
    public boolean processPayments() {
        return collectAndValidateCardDetails();
    }

    /**
     * Retrieves the list of all gyms with available slots.
     *
     * @return List of gyms with slots.
     */
    List<Gym> viewAllGymsWithSlots() {
        return userServiceOperations.viewAllGymsWithSlots();
    }

    /**
     * Books a slot in a gym.
     *
     * @param gymId     ID of the gym.
     * @param startTime Start time of the slot.
     * @param email     User's email address.
     * @return true if slot is booked successfully, false otherwise.
     */
    public boolean bookSlot(int gymId, int startTime, String email) {
        return userServiceOperations.bookSlot(gymId, startTime, email);
    }

    /**
     * Cancels a booking.
     *
     * @param bookingId ID of the booking to be cancelled.
     * @return true if booking is cancelled successfully, false otherwise.
     */
    public boolean cancelSlot(int bookingId) {
        return userServiceOperations.cancelSlot(bookingId);
    }

    /// Displays all bookings made by the user.
    ///
    /// @param email User's email address.
    public boolean viewAllBookings(String email) {
        System.out.println(ANSI_BOLD + ANSI_RED + "My Bookings: " + ANSI_RESET);
        int userId = userServiceOperations.getUserIdByEmail(email);
        if (userId == -1) {
            System.out.println("No such user exists with email: " + email);
            return false;
        }
        List<Bookings> bookings = userServiceOperations.viewAllBookings(userId);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return false;
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
        return true;
    }

    /// Retrieves the list of all gyms by a specified area.
    ///
    /// @param location Location to filter gyms.
    /// @return List of gyms in the specified area.
    List<Gym> viewAllGymsByArea(String location) {
        return userServiceOperations.viewAllGymsByArea(location);
    }

    /// Creates a new customer account.
    public void createCustomer() {
        System.out.println(ANSI_BLUE + "Enter customer details: " + ANSI_RESET);
//        Name
        System.out.println(ANSI_BLUE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
//        Mobile Number
        System.out.println(ANSI_BLUE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        if (!validateIdentity.validatePhoneNumber(phoneNo)) {
            System.out.println(ANSI_RED + "Phone Number invalid! Try again!" + ANSI_RESET);
            return;
        }
//        Address
        System.out.println(ANSI_BLUE + "Address: " + ANSI_RESET);
        String address = scanner.nextLine();
        if (!validateIdentity.validateAddress(address)) {
            System.out.println(ANSI_RED + "Address invalid! Try again!" + ANSI_RESET);
            return;
        }

//        Location
        System.out.println(ANSI_BLUE + "Location: " + ANSI_RESET);
        String location = scanner.nextLine();
        if (!validateIdentity.validateLocation(location)) {
            System.out.println(ANSI_RED + "Location invalid! Try again!" + ANSI_RESET);
            return;
        }
//        Email
        System.out.println("Email: ");
        String ownerEmail = scanner.nextLine();
        if (!validateCredential.validateEmail(ownerEmail)) {
            System.out.println(ANSI_RED + "Invalid Email address! Try Again!" + ANSI_RESET);
            return;
        }
//        Password
        System.out.println(ANSI_BLUE + "Password: " + ANSI_RESET);
        String password = scanner.nextLine();
        if (!validateCredential.validatePassword(password)) {
            System.out.println(ANSI_RED + "Password length should be in between 10 to 20" + ANSI_RESET);
            System.out.println(ANSI_RED + "It must also contain a number, lowercase, uppercase and special character." + ANSI_RESET);
            return;
        }





        User user = new User();
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);
        user.setAddress(address);
        user.setLocation(location);
        user.setEmail(ownerEmail);

        user.setPassword(password);


        if (userServiceOperations.createUser(user))
            System.out.println("User created!");
        else
            System.out.println("User not created!");
    }

    /// Updates the details of an existing user.
    ///
    /// @return true if user details are updated successfully, false otherwise.
    public boolean updateUserDetails() {
        System.out.println(ANSI_PURPLE + "Enter customer details: " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Email: " + ANSI_RESET);
        String ownerEmail = scanner.nextLine();
        if (!validateCredential.validateEmail(ownerEmail)) {
            System.out.println(ANSI_RED + "Invalid Email address! Try Again!" + ANSI_RESET);
            return false;
        }
        System.out.println(ANSI_PURPLE + "Name: " + ANSI_RESET);
        String ownerName = scanner.nextLine();
        System.out.println(ANSI_PURPLE + "Phone Number: " + ANSI_RESET);
        String phoneNo = scanner.nextLine();
        if (!validateIdentity.validatePhoneNumber(phoneNo)) {
            System.out.println(ANSI_RED + "Phone Number invalid! Try again!" + ANSI_RESET);
            return false;
        }

        User user = new User();
        user.setEmail(ownerEmail);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        return userServiceOperations.updateUserDetails(user);
    }

    /// Updates the password of a user.
    ///
    /// @param userMail        User's email address.
    /// @param password        Current password.
    /// @param updatedPassword New password.
    /// @return true if password is updated successfully, false otherwise.
    public boolean updatePassword(String userMail, String password, String updatedPassword) {
        return userServiceOperations.updateGymUserPassword(userMail, password, updatedPassword);
    }
}
