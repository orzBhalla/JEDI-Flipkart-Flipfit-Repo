package com.flipkart.validator;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

public class ValidateIdentity {

    public static final String PHONE_NUMBER_REGEX = "^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,5}?\\)?[-.\\s]?[0-9]{1,9}$";
    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();

    }

    public static boolean validateAddress(String address) {
        return address != null && !address.isEmpty();
    }

    public static boolean validateLocation(String location) {
        return validateAddress(location);
    }


    public static boolean validateId(Integer idStr) {
        if (idStr == null) {
            return false;
        }
        if (idStr <= 0) {
            return false;
        }

        return true;
    }

    public static boolean validateSlots(Integer idStr) {
        if (idStr == null) {
            return false;
        }
        if (idStr <= 0) {
            return false;
        }

        return true;
    }

    public static boolean validateTime(Integer idStr) {
        if (idStr == null) {
            return false;
        }
        if (idStr < 0) {
            return false;
        }

        return true;
    }

    public static final String AADHAAR_REGEX = "^[0-9]{12}$";
    public static final Pattern AADHAAR_PATTERN = Pattern.compile(AADHAAR_REGEX);


    public static boolean validateAadhaar(String aadhaarNumber) {
        if (aadhaarNumber == null || aadhaarNumber.isEmpty()) {
            return false;
        }

        // Check format
        if (!AADHAAR_PATTERN.matcher(aadhaarNumber).matches()) {
            return false;
        }

        // Check checksum
        return isValidChecksum(aadhaarNumber);
    }


    public static boolean isValidChecksum(String aadhaarNumber) {
        int sum = 0;
        boolean alternate = false;

        // Process each digit from the end
        for (int i = aadhaarNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(aadhaarNumber.charAt(i));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }

        // A valid Aadhaar number should be divisible by 10
        return (sum % 10 == 0);
    }

    public class PANCardValidator {

        // Regex pattern for validating PAN card format
        public static final String PAN_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]$";
        public static final Pattern PAN_PATTERN = Pattern.compile(PAN_REGEX);


        public static boolean validatePAN(String pan) {
            if (pan == null || pan.isEmpty()) {
                return false;
            }

            // Check format
            if (!PAN_PATTERN.matcher(pan).matches()) {
                return false;
            }


            return validatePANStructure(pan);
        }


        public static boolean validatePANStructure(String pan) {

            char fourthLetter = pan.charAt(3);
            if (fourthLetter == 'P' || fourthLetter == 'C' || fourthLetter == 'H' || fourthLetter == 'F' || fourthLetter == 'A' || fourthLetter == 'T') {
                return true;
            }
            return false;
        }

    }


    public class GSTValidator {

        public static final String GST_REGEX = "^[A-Z]{2}[A-Z0-9]{10}[0-9A-Z]$";
        public static final Pattern GST_PATTERN = Pattern.compile(GST_REGEX);

        public static final String[] VALID_STATE_CODES = {
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"
        };

        public static boolean validateGST(String gstNumber) {
            if (gstNumber == null || gstNumber.isEmpty()) {
                return false;
            }

            // Check format
            if (!GST_PATTERN.matcher(gstNumber).matches()) {
                return false;
            }

            // Extract state code from GST number
            String stateCode = gstNumber.substring(0, 2);
            if (!isValidStateCode(stateCode)) {
                return false;
            }

            // Further validation could include checking PAN structure and check digit if necessary
            return true;
        }

        private static boolean isValidStateCode(String stateCode) {
            for (String validCode : VALID_STATE_CODES) {
                if (validCode.equals(stateCode)) {
                    return true;
                }
            }
            return false;
        }
    }



    }
