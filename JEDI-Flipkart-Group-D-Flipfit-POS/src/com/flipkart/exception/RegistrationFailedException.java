package com.flipkart.exception;

// Custom exception class for handling registration failure scenarios
public class RegistrationFailedException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Registration failed. Please try again";
    }
}
