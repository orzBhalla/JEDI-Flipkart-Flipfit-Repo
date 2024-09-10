package com.flipkart.exception;

/**
 * Custom exception class for handling scenarios where a user is not found.
 * This exception is thrown when a user cannot be located in the system.
 *
 * @author Adarsh and Chahat

 */
public class UserNotFoundException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when a user is not found.
     *
     * @return String Custom error message indicating that the user was not found.
     * @author Adarsh and Chahat

     */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "User not found. Please register or login using a different account";
    }
}

