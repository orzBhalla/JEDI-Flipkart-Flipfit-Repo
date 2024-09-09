//package com.flipkart.business;
//
//import static com.flipkart.client.FlipFitApplicationMainClient.scanner;
//
//public class PaymentsServiceOperations {
//    public void processPayments()  {
//        if (collectCardDetails());
//        if (validateCardDetails()) {
//            System.out.println("Card details validated successfully.");
//            requestOTP();
//        } else {
//            System.out.println("Invalid card details. Payment failed.");
//        }
//    }
//
//    private void requestOTP() {
//        System.out.print("Enter the OTP sent to your registered mobile number: ");
//        String enteredOTP = scanner.nextLine();
//
//        if (OTP.equals(enteredOTP)) {
//            System.out.println("OTP verified successfully. Payment successful!");
//        } else {
//            System.out.println("Invalid OTP. Payment failed.");
//        }
//    }
//
//    private boolean validateCardDetails() {
//        // Simple validation checks
//        if (cardNumber <= 0 || expiryDate.isEmpty() || name.isEmpty() || cvv.length() != 3) {
//            return false;
//        }
//        // Additional validation logic can be added here (e.g., check if the card number format is correct)
//        return true;
//    }
//
//    private boolean collectCardDetails(String cardNumber, String expiryDate,  String name, String cvv) {
////        System.out.print("Enter card number: ");
////        cardNumber = Integer.parseInt(scanner.nextLine());
////
////        System.out.print("Enter expiry date (MM/YY): ");
////        expiryDate = scanner.nextLine();
////
////        System.out.print("Enter cardholder's name: ");
////        name = scanner.nextLine();
////
////        System.out.print("Enter CVV: ");
////        cvv = scanner.nextLine();
//        return true;
//    }
//
//}


package com.flipkart.business;

import com.flipkart.bean.Payments;

import java.util.Random;
import java.util.Scanner;

public class PaymentsServiceOperations {

    Scanner scanner = new Scanner(System.in);

    public boolean validateCardDetails(Payments payments) {
        // validation logic
        int serverOTP = requestOTP(payments);
        System.out.println("Your OTP is: " + serverOTP);
        return validateOTP(serverOTP);
    }

    public int requestOTP(Payments payments) {
        Random random = new Random();
        int randomNumber = 1000  + random.nextInt(9000);
        int OTP = randomNumber;
        return OTP;
    }

    public boolean validateOTP(int serverOTP) {
        System.out.println("Enter OTP: ");
        int OTP = Integer.parseInt(scanner.nextLine());
        return (OTP == serverOTP);
    }
}