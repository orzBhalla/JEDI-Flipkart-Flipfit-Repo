package com.flipkart.exception;

/**
 * Custom exception class for handling scenarios where an update operation fails.
 * This exception is thrown when an update operation cannot be completed successfully.
 *

 */
public class UpdationFailedException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when the update operation fails.
     *
     * @return String Custom error message indicating the failure of the update operation.

     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Updation failed. Please try again";
    }
}

