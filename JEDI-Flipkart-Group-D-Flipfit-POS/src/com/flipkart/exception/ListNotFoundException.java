package com.flipkart.exception;

// Custom exception class for handling scenarios where a list is not found
public class ListNotFoundException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "List not found";
    }
}

