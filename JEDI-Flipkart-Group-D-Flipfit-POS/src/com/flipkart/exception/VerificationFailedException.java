package com.flipkart.exception;

// Custom exception class for handling verification failure scenarios
public class VerificationFailedException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Verification failed";
    }
}
