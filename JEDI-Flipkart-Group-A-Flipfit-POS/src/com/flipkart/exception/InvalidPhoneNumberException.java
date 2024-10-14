package com.flipkart.exception;

/**
 * Custom exception class for handling invalid phone number scenarios.
 * This class extends the built-in Exception class to provide a specific
 * exception for invalid phone number cases.
 *
 */
public class InvalidPhoneNumberException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message when this exception is thrown.
     *
     * @return a custom error message indicating that the phone number is invalid
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid phone number. Please enter correct phone number";
    }
}

