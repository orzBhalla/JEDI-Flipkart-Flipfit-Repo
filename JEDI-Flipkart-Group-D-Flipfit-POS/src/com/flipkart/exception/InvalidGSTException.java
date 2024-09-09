package com.flipkart.exception;

// Custom exception class for handling invalid GST scenarios
public class InvalidGSTException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid GST. Please enter correct GST";
    }
}
