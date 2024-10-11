package com.flipkart.exception;

/**
 * Custom exception class for handling invalid Aadhaar card scenarios.
 * This class extends the built-in Exception class to provide a specific
 * exception for invalid Aadhaar card cases.
 *
 */
public class InvalidAadhaarCardException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message when this exception is thrown.
     *
     * @return a custom error message indicating that the Aadhaar card is invalid
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Invalid Aadhaar Card. Please enter correct Aadhaar Card";
    }
}
