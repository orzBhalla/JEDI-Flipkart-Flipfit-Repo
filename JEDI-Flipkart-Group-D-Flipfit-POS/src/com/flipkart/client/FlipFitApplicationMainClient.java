package com.flipkart.client;
import java.util.Scanner;

public class FlipFitApplicationMainClient {
    static Scanner scanner = new Scanner(System.in);

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
                case 1 :
                    System.out.println("------------Login Page--------------");
                    System.out.println("Please enter your email:");
                    String userMail = scanner.nextLine();
                    System.out.println("Please enter your password:");
                    String password = scanner.nextLine();
                    System.out.println("Select your role:");
                    System.out.println("Press 1 for Admin");
                    System.out.println("Press 2 for Gym Owner");
                    System.out.println("Press 3 for Gym User");
                    int role = Integer.parseInt(scanner.nextLine());

                    switch (role) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("You selected an invalid option. Please select a valid option.");
                            break;

                    }
                    break;
                case 2 :
                    System.out.println("-------------Registration Page--------------");
                    System.out.println("Select your role:");
                    System.out.println("Press 1 for Gym User");
                    System.out.println("Press 2 for Gym Owner");
                    System.out.println("Press 3 to Go Back");
                    role = Integer.parseInt(scanner.nextLine());

                    switch (role) {
                        case 1:
                            break;
                        case 2:
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
                    System.out.println("Press 1 for Admin");
                    System.out.println("Press 2 for Gym Owner");
                    System.out.println("Press 3 for Gym User");
                    role = Integer.parseInt(scanner.nextLine());

                    switch (role) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
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
