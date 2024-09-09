package com.flipkart.exception;

public class VerificationFailedException extends Exception {

    public String getMessage() {
        return "verification failed";
    }
}
