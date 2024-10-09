package com.flipkart.client;

import java.util.Scanner;

public class GymFlipFitApplication {
   static GymFlipFitCustomerMenu GymFlipFitCustomer = new GymFlipFitCustomerMenu();
    static GymFlipFitAdminMenu GymFlipFitAdminMenu =new GymFlipFitAdminMenu();
    static GymFlipFitOwnerMenu GymFlipFitOwnerMenu =new GymFlipFitOwnerMenu();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Flipfit application:");

//        do {
            displayMainMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleLogin(scanner);
                    break;
                case 2:
                    System.out.println("Customer Registration...");
                    // Add logic for customer registration
                    break;
                case 3:
                    System.out.println("Gym Owner Registration...");
                    // Add logic for gym owner registration
                    break;
                case 4:
                    System.out.println("Updating password...");
                    // Add logic for password update
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
//        } while (choice != 5);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Registration of the Customer");
        System.out.println("3. Registration of GymOwner");
        System.out.println("4. Update password");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleLogin(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        System.out.println("Enter your Role: ");
        String role = scanner.next();

        switch (role) {
            case "Admin":
                System.out.println("Admin Menu:");
                GymFlipFitAdminMenu.displayAdminMenu();
                break;
            case "Owner":
                System.out.println("Gym Owner Menu:");
                GymFlipFitOwnerMenu.displayOwnerMenu();
                break;
            case "Customer":
                System.out.println("Customer Menu:");
                GymFlipFitCustomerMenu.displayCustomerMenu();
                break;
            default:
                System.out.println("Invalid credentials or role.");
        }

    }
}
