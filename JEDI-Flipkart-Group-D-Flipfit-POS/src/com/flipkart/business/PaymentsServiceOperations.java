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
        int serverOTP = randomNumber;
        return serverOTP;
    }

    public boolean validateOTP(int serverOTP) {
        System.out.println("Enter OTP: ");
        int OTP = Integer.parseInt(scanner.nextLine());
        return (OTP == serverOTP);
    }
}