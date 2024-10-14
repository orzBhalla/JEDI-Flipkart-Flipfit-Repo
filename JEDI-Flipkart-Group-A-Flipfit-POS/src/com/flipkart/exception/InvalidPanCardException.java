package com.flipkart.exception;

/**
 * Custom exception class for handling invalid Pan Card scenarios.
 * This class extends the built-in Exception class to provide a specific
 * exception for invalid Pan Card cases.
 *
 */
public class InvalidPanCardException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message when this exception is thrown.
     *
     * @return a custom error message indicating that the Pan Card details are invalid
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid Pan Card. Please enter correct details";
    }
}
