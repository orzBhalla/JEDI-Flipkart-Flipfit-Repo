package com.flipkart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a User in the GymFlipFit application.
 * It stores user information such as user ID, name, contact details, address, location, email, and password.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int userId; // Unique identifier for the user

    private String userName; // User's name
    private String phoneNumber; // User's phone number
    private String address; // User's address
    private String location; // User's location
    private String email; // User's email address
    private String password; // User's password

}
