package com.flipkart.exception;

/**
 * Custom exception class for handling scenarios where incorrect credentials are provided.
 * This exception is thrown when a user enters invalid login credentials.
 *

 */
public class WrongCredentialsException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when wrong credentials are provided.
     *
     * @return String Custom error message indicating incorrect credentials.

     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Wrong credentials. Please enter correct credentials";
    }
}


