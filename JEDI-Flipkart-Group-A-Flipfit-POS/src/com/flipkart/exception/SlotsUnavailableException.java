package com.flipkart.exception;

import static com.flipkart.constants.ColorConstants.*;

/**
 * Custom exception class for handling scenarios where slots are unavailable.
 * This exception is thrown when the desired slots are not available for booking.
 *
 */
public class SlotsUnavailableException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when the slots are unavailable.
     *
     * @return String Custom error message with color formatting indicating slot unavailability.

     */
    @Override
    public String getMessage() {
        // Returns a custom error message with color formatting when this exception is thrown
        return ANSI_CYAN + "Slots unavailable. Please try another gym or different slot in the gym" + ANSI_RESET;
    }
}

