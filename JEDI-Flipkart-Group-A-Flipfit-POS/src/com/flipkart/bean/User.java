package com.flipkart.bean;

/**
 * Represents a user with personal information including user ID, name, contact details, and address.
 * Contains information about the user's unique identifier, name, phone number, address, location, email, and password.
 *
 */
public class User {

    /**
     * Unique identifier for the user.
     */
    private int userId;

    /**
     * Name of the user.
     */
    private String userName;

    /**
     * Phone number of the user.
     */
    private String phoneNumber;

    /**
     * Address of the user.
     */
    private String address;

    /**
     * Location of the user.
     */
    private String location;

    /**
     * Email address of the user.
     */
    private String email;

    /**
     * Password for the user's account.
     */
    private String password;

    /**
     * Gets the unique identifier for the user.
     *
     * @return the userId, which is the unique identifier for the user.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param userId the userId to set, which is the unique identifier for the user.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the name of the user.
     *
     * @return the userName of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the name of the user.
     *
     * @param userName the userName to set for the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the email address of the user.
     *
     * @return the email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the email address to set for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return the phoneNumber of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber the phoneNumber to set for the user.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the address of the user.
     *
     * @return the address of the user.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address the address to set for the user.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the location of the user.
     *
     * @return the location of the user.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the user.
     *
     * @param location the location to set for the user.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the password for the user's account.
     *
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user's account.
     *
     * @param password the password to set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

