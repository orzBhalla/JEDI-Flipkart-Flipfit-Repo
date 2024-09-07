package com.flipkart.exception;

public class UpdationFailedException extends Exception {
    public String getMessage() {
        return "updation failed. Please try again";
    }
}
