package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface FlipFitUpdatePasswordDAOInterface {

    public void updateGymOwnerPassword(String email, String password, String updatedPassword);

    public void updateGymUserPassword(String email, String password, String updatedPassword);

    public boolean verifyGymOwnerPassword(String email, String password);

    public boolean verifyGymUserPassword(String email, String password);
}
