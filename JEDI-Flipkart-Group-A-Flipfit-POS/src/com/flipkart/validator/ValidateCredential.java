package com.flipkart.validator;

import java.util.regex.Pattern;

/**
 * Validator class for validating user credentials such as email and password.
 *
 */
public class ValidateCredential {

    // Regex pattern to validate email format
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Constants defining minimum and maximum password length
    public static final int MIN_PASSWORD_LENGTH = 10;
    public static final int MAX_PASSWORD_LENGTH = 20;

    /**
     * Validates an email based on the format using the defined regex pattern.
     *
     * @param email The email to validate.
     * @return boolean true if the email is valid, false otherwise.

     */
    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates a password based on length and content, requiring at least one digit,
     * one lower case letter, one upper case letter, and one special character.
     *
     * @param password The password to validate.
     * @return boolean true if the password is valid, false otherwise.

     */
    public static boolean validatePassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Check for at least one digit, one lower case letter, one upper case letter, and one special character
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        // Iterate through each character in the password and update the flags
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasDigit && hasLower && hasUpper && hasSpecial;
    }
}



