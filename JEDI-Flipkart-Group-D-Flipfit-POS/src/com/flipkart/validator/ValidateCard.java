package com.flipkart.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateCard {
    private static final String CARD_NUMBER_REGEX = "^[0-9]{16}$";

    /**
     * Validates a 16-digit card number based on format and checksum.
     * @param cardNumber The 16-digit card number to validate.
     * @return true if the card number is valid, false otherwise.
     */
    public static boolean validateCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return false;
        }

        // Check format
        if (!cardNumber.matches(CARD_NUMBER_REGEX)) {
            return false;
        }

        // Check checksum using Luhn algorithm
       return true;
    }

    private static final DateTimeFormatter EXPIRY_DATE_FORMAT = DateTimeFormatter.ofPattern("MM/yy");

    /**
     * Validates an expiry date based on format and if it is not in the past.
     * @param expiryDate The expiry date to validate in MM/YY format.
     * @return true if the expiry date is valid and in the future, false otherwise.
     */
    public static boolean validateExpiryDate(String expiryDate) {
        if (expiryDate == null || expiryDate.isEmpty()) {
            return false;
        }

        // Check format
        LocalDate expiryLocalDate;
        try {
           expiryLocalDate = LocalDate.parse("01/" + expiryDate, DateTimeFormatter.ofPattern("dd/MM/yy"));
       } catch (DateTimeParseException e) {
           return false;
        }

        // Check if the expiry date is in the future
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDateWithYear = expiryLocalDate.withYear(currentDate.getYear());

        // If the expiry year is in the past, use the next year
        if (expiryLocalDate.getYear() < currentDate.getYear() % 100) {
            expiryDateWithYear = expiryDateWithYear.plusYears(1);
        }

        return !expiryDateWithYear.isBefore(currentDate);
    }

    // Regex pattern to validate 3 or 4-digit CVV
    private static final String CVV_REGEX = "^[0-9]{3,4}$";

    /**
     * Validates a CVV based on length and format.
     * @param cvv The CVV to validate.
     * @return true if the CVV is valid, false otherwise.
     */
    public static boolean validateCVV(String cvv) {
        if (cvv == null || cvv.isEmpty()) {
            return false;
        }

        // Check format
        return cvv.matches(CVV_REGEX);
    }


}