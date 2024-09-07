package com.flipkart.exception;

public class SlotBookingFailedException extends Exception {
    public String getMessage(){
        return "Unable to book slot. Please try again";
    }
}
