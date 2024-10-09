package com.flipkart.bean;

/**
 * Represents a FlipFit User
 */

public class FlipFitUser {

    private String userID;
    private String userName;
    private String email;
    private String password;
    private FlipFitRole role;

    /**
     * Default constructor for FlipFitUser.
     */
    public FlipFitUser() {
    }

    /**
     * Parameterized constructor for FlipFitUser.
     * @param id the user ID
     * @param userName the user name
     * @param email the user's email address
     * @param password the user's password
     * @param role the user's role (FlipFitRole object)
     */
    public FlipFitUser(String id, String userName, String email, String password, FlipFitRole role) {
        this.userID = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Getter for the user's role.
     * @return the FlipFitRole object representing the user's role
     */
    public FlipFitRole getRole() {
        return role;
    }

    /**
     * Setter for the user's role.
     * @param role the FlipFitRole object to set
     */
    public void setRole(FlipFitRole role) {
        this.role = role;
    }

    /**
     * Getter for the user ID.
     * @return the user ID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Setter for the user ID.
     * @param userID the user ID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Getter for the user name.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for the user name.
     * @param userName the user name to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for the user's email address.
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the user's email address.
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the user's password.
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the user's password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Override of the toString() method to provide a string representation of the object.
     * @return a string representation of the FlipFitUser object
     */
    @Override
    public String toString() {
        return "FlipFitUser{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    /**
     * Setter for the user's email address.
     * @param email the email address to set
     */
    public void setEmailId(String email) {
        this.email = email;
    }

    /**
     * Getter for the user's email address.
     * @return the user's email address
     */
    public String getEmailId() {
        return this.email;
    }
}