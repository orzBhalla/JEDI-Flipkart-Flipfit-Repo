package com.flipkart.exception;

// Custom exception class for handling booking cancellation failures
public class BookingCancellationFailedException extends Exception {

    // Overrides the getMessage() method from the Exception class
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Booking cancellation failed. Please try again";
    }
}
