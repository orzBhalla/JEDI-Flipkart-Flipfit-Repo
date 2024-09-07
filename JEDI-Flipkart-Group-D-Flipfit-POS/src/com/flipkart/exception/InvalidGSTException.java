package com.flipkart.exception;

public class InvalidGSTException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid GST. Please enter correct GST";
    }
}
