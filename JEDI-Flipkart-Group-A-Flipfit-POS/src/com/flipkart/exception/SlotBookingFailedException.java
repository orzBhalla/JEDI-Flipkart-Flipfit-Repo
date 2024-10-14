package com.flipkart.exception;

import static com.flipkart.constants.ColorConstants.*;

/**
 * Custom exception class for handling slot booking failure scenarios.
 * This exception is thrown when a slot booking fails.
 *

 */
public class SlotBookingFailedException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when the slot booking fails.
     *
     * @return String Custom error message with color formatting.

     */
    @Override
    public String getMessage() {
        // Returns a custom error message with color formatting when this exception is thrown
        return ANSI_CYAN + "Unable to book slot. Please try again" + ANSI_RESET;
    }
}

