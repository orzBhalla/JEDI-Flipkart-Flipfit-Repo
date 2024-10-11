package com.flipkart.dao;

public interface FlipFitUpdatePasswordDAOInterface {

    /**
     * Updates the password for a gym owner based on their email address.
     * @param email The email address of the gym owner whose password is to be updated. This should be a valid and registered email address associated with a gym owner account.
     * @param password The current password of the gym owner. This is required to verify the owner's identity before updating the password.
     * @param updatedPassword The new password to be set for the gym owner. This should meet the required security criteria for passwords.
     * @return  True if the password was successfully updated; returns false if the update failed due to reasons such as incorrect current password, email not found, or issues with the new password.
     */
    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword);

    /**
     * Updates the password for a gym user based on their email address.
     * @param email The email address of the gym user whose password is to be updated. This should be a valid and registered email address associated with the user account.
     * @param password The current password of the gym user. This is required to verify the user's identity before updating the password.
     * @param updatedPassword The new password to be set for the gym user. This should meet the required security criteria for passwords.
     * @return True if the password was successfully updated; returns false if the update failed due to reasons such as incorrect current password, email not found, or issues with the new password.
     */

    public boolean updateGymUserPassword(String email, String password, String updatedPassword);
}

