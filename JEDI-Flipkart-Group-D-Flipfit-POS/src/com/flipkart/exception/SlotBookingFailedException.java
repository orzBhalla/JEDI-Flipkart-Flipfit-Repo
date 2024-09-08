package com.flipkart.exception;

import static com.flipkart.constants.ColorConstants.*;

public class SlotBookingFailedException extends Exception {
    public String getMessage() {
        return ANSI_CYAN + "Unable to book slot. Please try again" + ANSI_RESET;
    }
}
