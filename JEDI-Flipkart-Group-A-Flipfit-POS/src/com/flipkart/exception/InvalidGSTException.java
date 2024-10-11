package com.flipkart.exception;

/**
 * Custom exception class for handling invalid GST scenarios.
 * This class extends the built-in Exception class to provide a specific
 * exception for invalid GST cases.
 *

 */
public class InvalidGSTException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message when this exception is thrown.
     *
     * @return a custom error message indicating that the GST is invalid
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid GST. Please enter correct GST";
    }
}

