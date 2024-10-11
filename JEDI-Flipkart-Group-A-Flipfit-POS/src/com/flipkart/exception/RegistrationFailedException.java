package com.flipkart.exception;

/**
 * Custom exception class for handling registration failure scenarios.
 * This class extends the built-in Exception class to provide a specific
 * exception for cases where registration fails.
 *
 */
public class RegistrationFailedException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message when this exception is thrown.
     *
     * @return a custom error message indicating that registration has failed
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Registration failed. Please try again";
    }
}

