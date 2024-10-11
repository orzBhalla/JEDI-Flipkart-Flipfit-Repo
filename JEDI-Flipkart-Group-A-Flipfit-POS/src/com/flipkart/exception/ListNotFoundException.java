package com.flipkart.exception;

/**
 * Custom exception class for handling scenarios where a list is not found.
 * This class extends the built-in Exception class to provide a specific
 * exception for cases where a list cannot be found.
 *
 */
public class ListNotFoundException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message when this exception is thrown.
     *
     * @return a custom error message indicating that the list was not found
     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "List not found";
    }
}


