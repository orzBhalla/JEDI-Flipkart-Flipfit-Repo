package com.flipkart.client;
import java.util.Scanner;

public class FlipFitApplicationMainClient {
    static Scanner scanner = new Scanner(System.in);

    static FlipFitGymOwnerClientMenu gymOwnerMenu = new FlipFitGymOwnerClientMenu();
    static FlipFitGymCustomerClientMenu customerMenu = new FlipFitGymCustomerClientMenu();
    static FlipFitGymAdminMenu adminMenu = new FlipFitGymAdminMenu();

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------Welcome to FlipFit: Your Fitness Partner--------------------");
        System.out.println("-----------------------------------------------------------------------------------");

        boolean inInApp = true;

        while (inInApp) {
            System.out.println("Press 1 for Login");
            System.out.println("Press 2 for Registration");
            System.out.println("Press 3 for Update Password");
            System.out.println("Press 4 for Exit");
            int optionSelected = Integer.parseInt(scanner.nextLine());

            switch (optionSelected) {
                case 1:
                    System.out.println("------------Login Page--------------");
                    System.out.println("Please enter your email:");
                    String userMail = scanner.nextLine();
                    System.out.println("Please enter your password:");
                    String password = scanner.nextLine();
                    System.out.println("Select your role:");
                    System.out.println("Press 1 for Admin");
                    System.out.println("Press 2 for Gym Owner");
                    System.out.println("Press 3 for Gym Customer");
                    int role = Integer.parseInt(scanner.nextLine());

                    switch (role) {
                        case 1:
                            if (!adminMenu.verifyAdminCredentials(userMail,password)) {
                                System.out.println("Invalid Credentials! Please enter valid credentials to login");
                                break;
                            }

                            boolean isLoggedIn = true;
                            while (isLoggedIn) {
                                System.out.println("-----------------Admin Menu------------------");
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
                                        System.out.println("Enter the Gym ID to be verified");
                                        int gymId = Integer.parseInt(scanner.nextLine());
                                        adminMenu.verifyGym(gymId);
                                        break;
                                    case 5:
                                        System.out.println("Enter the Gym Owner ID to be verified");
                                        int gymOwnerId = Integer.parseInt(scanner.nextLine());
                                        adminMenu.verifyGymOwner(gymOwnerId);
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
                            if (!gymOwnerMenu.gymOwnerLogin(userMail,password)) {
                                System.out.println("Invalid Credentials! Please enter valid credentials to login");
                                break;
                            }
                            break;
                        case 3:
                            if(!customerMenu.userLogin(userMail,password)){
                                System.out.println("Invalid Credentials! Please enter valid credentials to login");
                                break;
                            }
                            break;
                        default:
                            System.out.println("You selected an invalid option. Please select a valid option");
                            break;

                    }
                    break;
                case 2:
                    System.out.println("-------------Registration Page--------------");
                    System.out.println("Select your role:");
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
                case 3 :
                    System.out.println("-------------Reset Password Page--------------");
                    System.out.println("Please enter your email:");
                    userMail = scanner.nextLine();
                    System.out.println("Please enter your current password:");
                    password = scanner.nextLine();
                    System.out.println("Please enter new password:");
                    String updatedPassword = scanner.nextLine();
                    System.out.println("Select your role:");
                    System.out.println("Press 1 for gym user");
                    System.out.println("Press 2 for gym owner");
                    System.out.println("Press 3 for gym admin");
                    role = Integer.parseInt(scanner.nextLine());

                    switch (role) {
                        case 1:
                            if (!customerMenu.validateUser(userMail,password)) {
                                System.out.println("Invalid credentials! Please enter valid credentials");
                            }
                            else {
                                // update the password here
                            }
                            break;
                        case 2:
                            if (!gymOwnerMenu.verifyGymOwner(userMail,password)) {
                                System.out.println("Invalid credentials! Please enter valid credentials");
                            }
                            else{
                                // update the password here
                            }
                            break;
                        case 3:
                            if (!adminMenu.verifyAdminCredentials(userMail,password)) {
                                System.out.println("Invalid credentials! Please enter valid credentials");
                            }
                            else{
                                // update the password here
                            }
                            break;
                    }
                    break;
                case 4 :
                    inInApp = false;
                    System.out.println("Thank you for using FLipFit!");
                    break;
                default:
                    break;
            }
        }

    }
}
