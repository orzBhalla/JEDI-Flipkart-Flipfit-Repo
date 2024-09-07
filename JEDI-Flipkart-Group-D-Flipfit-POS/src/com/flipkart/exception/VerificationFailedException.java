package com.flipkart.exception;

public class VerificationFailedException extends Exception {
    @Override
    public String getMessage() {
        return "verification failed";
    }
}
