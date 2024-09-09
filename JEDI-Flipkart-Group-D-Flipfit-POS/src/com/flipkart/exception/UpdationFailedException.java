package com.flipkart.exception;

// Custom exception class for handling scenarios where an update operation fails
public class UpdationFailedException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Updation failed. Please try again";
    }
}
