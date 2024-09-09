package com.flipkart.exception;

// Custom exception class for handling incorrect credentials scenarios
public class WrongCredentialsException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Wrong credentials. Please enter correct credentials";
    }
}

