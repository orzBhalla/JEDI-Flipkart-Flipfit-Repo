package com.flipkart.exception;

// Custom exception class for handling invalid Aadhaar card scenarios
public class InvalidAadhaarCardException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid Aadhaar Card. Please enter correct Aadhaar Card";
    }
}
