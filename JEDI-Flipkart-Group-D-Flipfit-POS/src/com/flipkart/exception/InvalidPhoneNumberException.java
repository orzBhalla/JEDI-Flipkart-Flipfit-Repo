package com.flipkart.exception;

// Custom exception class for handling invalid phone number scenarios
public class InvalidPhoneNumberException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid phone number. Please enter correct phone number";
    }
}
