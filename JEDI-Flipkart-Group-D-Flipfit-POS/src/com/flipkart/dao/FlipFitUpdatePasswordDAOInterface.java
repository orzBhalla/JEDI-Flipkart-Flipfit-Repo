package com.flipkart.dao;

public interface FlipFitUpdatePasswordDAOInterface {
    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword);

    public boolean updateGymUserPassword(String email, String password, String updatedPassword);
}

