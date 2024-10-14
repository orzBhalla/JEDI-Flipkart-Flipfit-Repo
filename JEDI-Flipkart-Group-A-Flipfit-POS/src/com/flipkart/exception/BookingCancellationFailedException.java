package com.flipkart.exception;

/**
 * Custom exception class for handling booking cancellation failures.
 * Inherits from the Exception class to allow for specific exception handling
 * related to booking cancellations.
 *
 */
public class BookingCancellationFailedException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class.
     * Provides a custom error message to be returned when this exception is thrown.
     *
     * @return a custom error message indicating that booking cancellation has failed
     * */
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Booking cancellation failed. Please try again";
    }
}
