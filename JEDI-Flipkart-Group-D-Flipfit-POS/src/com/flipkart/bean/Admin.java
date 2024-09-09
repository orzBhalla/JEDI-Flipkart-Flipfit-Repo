package com.flipkart.bean;

/**
 * Represents an administrator in the system with associated credentials.
 * Contains information about the admin's ID and password.
 *
 * @author Adarsh, Navaratna
 */
public class Admin {

    /**
     * Unique identifier for the admin.
     */
    private int adminId;

    /**
     * Password for the admin account.
     */
    private String password;

    /**
     * Gets the Admin's ID.
     *
     * @return The adminId, which is the unique identifier for the admin.
     * @author Adarsh, Navaratna
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Sets the Admin's ID.
     *
     * @param adminId The adminId to set, which is the unique identifier for the admin.
     * @author Adarsh, Navaratna
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Gets the Admin's password.
     *
     * @return The password for the admin account.
     * @author Adarsh, Navaratna
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the Admin's password.
     *
     * @param password The password to set for the admin account.
     * @author Adarsh, Navaratna
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
