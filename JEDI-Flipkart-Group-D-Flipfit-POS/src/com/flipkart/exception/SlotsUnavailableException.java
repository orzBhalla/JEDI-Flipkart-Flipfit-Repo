package com.flipkart.exception;

import static com.flipkart.constants.ColorConstants.*;

public class SlotsUnavailableException extends Exception{
    @Override
    public String getMessage() {
        return ANSI_CYAN + "Slots unavailable. Please try another gym or different slot in the gym" + ANSI_RESET;
    }
}
