package com.flipkart.exception;

// Custom exception class for handling invalid Pan Card scenarios
public class InvalidPanCardException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid Pan Card. Please enter correct details";
    }
}
