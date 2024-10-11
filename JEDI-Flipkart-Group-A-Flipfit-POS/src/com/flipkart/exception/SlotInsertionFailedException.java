package com.flipkart.exception;

/**
 * Custom exception class for handling slot insertion failure scenarios.
 * This exception is thrown when slot insertion fails.
 *

 */
public class SlotInsertionFailedException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when the slot insertion fails.
     *
     * @return String Custom error message when this exception is thrown.
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Slot insertion failed!";
    }
}

