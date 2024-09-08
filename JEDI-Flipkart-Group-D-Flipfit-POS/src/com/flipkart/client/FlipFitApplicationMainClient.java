package com.flipkart.client;

import java.util.Scanner;

import static com.flipkart.constants.ColorConstants.*;

public class FlipFitApplicationMainClient {
    static Scanner scanner = new Scanner(System.in);

    static FlipFitGymOwnerClientMenu gymOwnerMenu = new FlipFitGymOwnerClientMenu();
    static FlipFitGymCustomerClientMenu customerMenu = new FlipFitGymCustomerClientMenu();
    static FlipFitGymAdminMenu adminMenu = new FlipFitGymAdminMenu();

    public static void main(String[] args) {
        System.out.println(ANSI_BOLD + ANSI_CYAN + "-----------------------------------------------------------------------------------");
        System.out.println("-----------------------Welcome to FlipFit: Your Fitness Partner--------------------");
        System.out.println("-----------------------------------------------------------------------------------" + ANSI_RESET);

        boolean inInApp = true;

        while (inInApp) {
            System.out.println(ANSI_BLUE + "Press 1 for Login");
            System.out.println("Press 2 for Registration");
            System.out.println("Press 3 for Update Password");
            System.out.println("Press 4 for Exit" + ANSI_RESET);
            int optionSelected = Integer.parseInt(scanner.nextLine());

            switch (optionSelected) {
                case 1:
                    System.out.println(ANSI_BOLD + ANSI_GREEN + "------------Login Page--------------" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "Select your role:" + ANSI_RESET);
                    System.out.println("Press 1 for admin");
                    System.out.println("Press 2 for gym owner");
                    System.out.println("Press 3 for gym customer");
                    int role = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter your email:");
                    String userMail = scanner.nextLine();
                    System.out.println("Please enter your password:");
                    String password = scanner.nextLine();

                    switch (role) {
                        case 1:
                            if (!adminMenu.verifyAdminCredentials(userMail, password)) {
                                System.out.println(ANSI_RED + "Invalid credentials! Please enter valid credentials to login" + ANSI_RESET);
                                break;
                            }
                            System.out.println(ANSI_CYAN + "Login successful! (Admin)" + ANSI_RESET);
                            boolean isLoggedIn = true;
                            while (isLoggedIn) {
                                System.out.println(ANSI_BOLD + ANSI_GREEN + "-----------------Admin Menu------------------" + ANSI_RESET);
                                System.out.println("Press 1 to view users");
                                System.out.println("Press 2 to view gyms");
                                System.out.println("Press 3 to view gym owners");
                                System.out.println("Press 4 to verify gym");
                                System.out.println("Press 5 to verify gym owners");
                                System.out.println("Press 6 to view pending gyms");
                                System.out.println("Press 7 to view pending gym owners");
                                System.out.println("Press 8 to exit");

                                optionSelected = Integer.parseInt(scanner.nextLine());

                                switch (optionSelected) {
                                    case 1:
                                        adminMenu.viewUsers();
                                        break;
                                    case 2:
                                        adminMenu.viewGyms();
                                        break;
                                    case 3:
                                        adminMenu.viewGymOwners();
                                        break;
                                    case 4:
                                        System.out.println("Enter the gym ID to be verified:");
                                        int gymId = Integer.parseInt(scanner.nextLine());
                                        if (adminMenu.verifyGym(gymId))
                                            System.out.println("Gym verified successfully!");
                                        else
                                            System.out.println("Gym not verified.");
                                        break;
                                    case 5:
                                        System.out.println("Enter the gym owner ID to be verified:");
                                        int gymOwnerId = Integer.parseInt(scanner.nextLine());
                                        if (adminMenu.verifyGymOwner(gymOwnerId))
                                            System.out.println("Gym owner verified successfully!");
                                        else
                                            System.out.println("Gym owner not verified.");
                                        break;
                                    case 6:
                                        adminMenu.viewUnverifiedGyms();
                                        break;
                                    case 7:
                                        adminMenu.viewUnverifiedGymOwners();
                                        break;
                                    case 8:
                                        isLoggedIn = false;
                                        break;
                                }
                                if (!isLoggedIn) break;
                            }
                            break;
                        case 2:
                            if (!gymOwnerMenu.gymOwnerLogin(userMail, password)) {
                                System.out.println(ANSI_RED + "Invalid credentials! Please enter valid credentials to login" + ANSI_RESET);
                                break;
                            }
                            break;
                        case 3:
                            if (!customerMenu.userLogin(userMail, password)) {
                                System.out.println(ANSI_RED + "Invalid credentials! Please enter valid credentials to login" + ANSI_RESET);
                                break;
                            }
                            break;
                        default:
                            System.out.println(ANSI_RED + "You have selected an invalid option. Please select a valid option" + ANSI_RESET);
                            break;
                    }
                    break;
                case 2:
                    System.out.println(ANSI_BOLD + ANSI_GREEN + "-------------Registration Page--------------" + ANSI_RESET);
                    System.out.println("Select your choice:");
                    System.out.println("Press 1 for gym user");
                    System.out.println("Press 2 for gym owner");
                    System.out.println("Press 3 to go back");
                    role = Integer.parseInt(scanner.nextLine());

                    switch (role) {
                        case 1:
                            customerMenu.createCustomer();
                            break;
                        case 2:
                            gymOwnerMenu.createGymOwner();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println(ANSI_BOLD + ANSI_GREEN + "-------------Reset Password Page--------------" + ANSI_RESET);
                    System.out.println("Select your role:");
                    System.out.println("Press 1 for gym user");
                    System.out.println("Press 2 for gym owner");
                    System.out.println("Press 3 for gym admin");
                    role = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter your email:");
                    userMail = scanner.nextLine();
                    System.out.println("Please enter your current password:");
                    password = scanner.nextLine();
                    System.out.println("Please enter new password:");
                    String updatedPassword = scanner.nextLine();

                    switch (role) {
                        case 1:
                            if (!customerMenu.validateUser(userMail, password)) {
                                System.out.println(ANSI_RED + "Invalid credentials! Please enter valid credentials" + ANSI_RESET);
                            } else {
                                if (customerMenu.updatePassword(userMail, password, updatedPassword))
                                    System.out.println(ANSI_CYAN + "Password updated successfully!" + ANSI_RESET);
                                else
                                    System.out.println(ANSI_RED + "Password doesn't match!" + ANSI_RESET);
                            }
                            break;
                        case 2:
                            if (!gymOwnerMenu.verifyGymOwner(userMail, password)) {
                                System.out.println(ANSI_RED + "Invalid credentials! Please enter valid credentials" + ANSI_RESET);
                            } else {
                                if (gymOwnerMenu.updatePassword(userMail, password, updatedPassword))
                                    System.out.println(ANSI_CYAN + "Password updated successfully!" + ANSI_RESET);
                                else
                                    System.out.println(ANSI_RED + "Password doesn't match!" + ANSI_RESET);
                            }
                            break;
                        case 3:
                            System.out.println(ANSI_RED + "Sorry! You don't have enough rights to do that." + ANSI_RESET);
                            break;
                    }
                    break;
                case 4:
                    inInApp = false;
                    System.out.println(ANSI_PURPLE + "Thank you for using FLipFit!" + ANSI_RESET);
                    break;
                default:
                    break;
            }
        }

    }
}
