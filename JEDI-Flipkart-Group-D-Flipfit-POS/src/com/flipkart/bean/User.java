package com.flipkart.bean;

/**
 * This class represents a User in the GymFlipFit application.
 * It stores user information such as user ID, name, contact details, address, location, email, and password.
 */

public class User {
    private int userId; // Unique identifier for the user

    private String userName; // User's name
    private String phoneNumber; // User's phone number
    private String address; // User's address
    private String location; // User's location
    private String email; // User's email address
    private String password; // User's password

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}