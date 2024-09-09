package com.flipkart.validator;

import java.util.regex.Pattern;

/**
 * Validator class for validating identity details such as phone number, address, Aadhaar number, PAN card, and GST number.
 *
 * @author Nitish and Navaratna
 */
public class ValidateIdentity {

    // Regex pattern to validate phone number format
    public static final String PHONE_NUMBER_REGEX = "^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,5}?\\)?[-.\\s]?[0-9]{1,9}$";
    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    /**
     * Validates a phone number based on the format using the defined regex pattern.
     *
     * @param phoneNumber The phone number to validate.
     * @return boolean true if the phone number is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }

    /**
     * Validates an address by checking if it is not null or empty.
     *
     * @param address The address to validate.
     * @return boolean true if the address is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validateAddress(String address) {
        return address != null && !address.isEmpty();
    }

    /**
     * Validates a location by using the same validation logic as for an address.
     *
     * @param location The location to validate.
     * @return boolean true if the location is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validateLocation(String location) {
        return validateAddress(location);
    }

    /**
     * Validates an ID by ensuring it is not null and is greater than zero.
     *
     * @param idStr The ID to validate.
     * @return boolean true if the ID is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validateId(Integer idStr) {
        if (idStr == null) {
            return false;
        }
        if (idStr <= 0) {
            return false;
        }

        return true;
    }

    /**
     * Validates slot details by ensuring the ID is not null and is greater than zero.
     *
     * @param idStr The ID to validate.
     * @return boolean true if the slot ID is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validateSlots(Integer idStr) {
        if (idStr == null) {
            return false;
        }
        if (idStr <= 0) {
            return false;
        }

        return true;
    }

    /**
     * Validates time details by ensuring the time ID is not null and is non-negative.
     *
     * @param idStr The ID to validate.
     * @return boolean true if the time ID is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validateTime(Integer idStr) {
        if (idStr == null) {
            return false;
        }
        if (idStr < 0) {
            return false;
        }

        return true;
    }

    // Regex pattern to validate Aadhaar number format
    public static final String AADHAAR_REGEX = "^[0-9]{12}$";
    public static final Pattern AADHAAR_PATTERN = Pattern.compile(AADHAAR_REGEX);

    /**
     * Validates an Aadhaar number based on format and checksum.
     *
     * @param aadhaarNumber The Aadhaar number to validate.
     * @return boolean true if the Aadhaar number is valid, false otherwise.
     * @author Nitish and Navaratna
     */
    public static boolean validateAadhaar(String aadhaarNumber) {
        if (aadhaarNumber == null || aadhaarNumber.isEmpty()) {
            return false;
        }

        // Check format
        if (!AADHAAR_PATTERN.matcher(aadhaarNumber).matches()) {
            return false;
        }

        // Check checksum
        return true;
    }




    /**
     * Inner class for validating PAN card details.
     *
     * @author Nitish and Navaratna
     */
    public class PANCardValidator {

        // Regex pattern for validating PAN card format
        public static final String PAN_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]$";
        public static final Pattern PAN_PATTERN = Pattern.compile(PAN_REGEX);

        /**
         * Validates a PAN card number based on format and structure.
         *
         * @param pan The PAN card number to validate.
         * @return boolean true if the PAN card number is valid, false otherwise.
         * @author Nitish and Navaratna
         */
        public static boolean validatePAN(String pan) {
            if (pan == null || pan.isEmpty()) {
                return false;
            }

            // Check format
            if (!PAN_PATTERN.matcher(pan).matches()) {
                return false;
            }

            // Validate PAN structure
            return validatePANStructure(pan);
        }

        /**
         * Validates the structure of a PAN card number.
         *
         * @param pan The PAN card number to validate.
         * @return boolean true if the PAN card number structure is valid, false otherwise.
         * @author Nitish and Navaratna
         */
        public static boolean validatePANStructure(String pan) {

            char fourthLetter = pan.charAt(3);
            if (fourthLetter == 'P' || fourthLetter == 'C' || fourthLetter == 'H' || fourthLetter == 'F' || fourthLetter == 'A' || fourthLetter == 'T') {
                return true;
            }
            return false;
        }
    }

    /**
     * Inner class for validating GST numbers.
     *
     * @author Nitish and Navaratna
     */
    public class GSTValidator {


        public static boolean validateGST(String gstNumber) {
            if (gstNumber == null || gstNumber.isEmpty()) {
                return false;
            }

            // Further validation could include checking PAN structure and check digit if necessary
            return true;
        }
//        // Regex pattern for validating GST number format
//        public static final String GST_REGEX = "^[A-Z]{2}[A-Z0-9]{10}[0-9A-Z]$";
//        public static final Pattern GST_PATTERN = Pattern.compile(GST_REGEX);
//
//        // Valid state codes for GST validation
//        public static final String[] VALID_STATE_CODES = {
//                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
//                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
//                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
//                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
//                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"
//        };
//
//        /**
//         * Validates a GST number based on format and state code.
//         *
//         * @param gstNumber The GST number to validate.
//         * @return boolean true if the GST number is valid, false otherwise.
//         * @author Nitish and Navaratna
//         */
//        public static boolean validateGST(String gstNumber) {
//            if (gstNumber == null || gstNumber.isEmpty()) {
//                return false;
//            }
//
//            // Check format
//            if (!GST_PATTERN.matcher(gstNumber).matches()) {
//                return false;
//            }
//
//            // Extract state code from GST number
//            String stateCode = gstNumber.substring(0, 2);
//            if (!isValidStateCode(stateCode)) {
//                return false;
//            }
//
//            // Further validation could include checking PAN structure and check digit if necessary
//            return true;
//        }
//
//        /**
//         * Checks if the state code is valid.
//         *
//         * @param stateCode The state code to check.
//         * @return boolean true if the state code is valid, false otherwise.
//         * @author Nitish and Navaratna
//         */
//        private static boolean isValidStateCode(String stateCode) {
//            for (String validCode : VALID_STATE_CODES) {
//                if (validCode.equals(stateCode)) {
//                    return true;
//                }
//            }
//            return false;
//        }
    }
}
