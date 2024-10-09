package com.flipkart.bean;


public class FlipFitUser {

    private String userID;
    private String userName;
    private String email;
    private String password;
    private FlipFitRole role;

    public FlipFitUser() {
    }

    public FlipFitUser(String id, String userName, String email, String password, FlipFitRole role) {
        this.userID = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public FlipFitRole getRole() {
        return role;
    }

    public void setRole(FlipFitRole role) {
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public void setEmailId(String email) {
        this.email = email;
    }

    public String getEmailId() {
        return this.email;
    }
}