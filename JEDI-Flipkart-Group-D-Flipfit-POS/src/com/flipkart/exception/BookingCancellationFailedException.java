package com.flipkart.exception;

public class BookingCancellationFailedException extends Exception{
    @Override
    public String getMessage(){
        return "Booking cancellation failed. Please try again";
    }
}
