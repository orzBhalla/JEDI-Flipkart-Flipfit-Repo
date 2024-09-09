package com.flipkart.exception;

// Custom exception class for handling slot insertion failure scenarios
public class SlotInsertionFailedException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Slot insertion failed!";
    }
}
