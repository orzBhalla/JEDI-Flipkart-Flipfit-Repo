package com.flipkart.exception;

// Custom exception class for handling scenarios where a user is not found
public class UserNotFoundException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "User not found. Please register or login using a different account";
    }
}
