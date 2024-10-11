package com.flipkart.bean;


public class Admin {

    /**
     * Unique identifier for the admin.
     */
    private int adminId;

    /**
     * Password for the admin account.
     */
    private String password;


    public int getAdminId() {
        return adminId;
    }


    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
