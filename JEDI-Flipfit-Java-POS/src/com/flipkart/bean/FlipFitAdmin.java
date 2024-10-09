package com.flipkart.bean;

/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 */
public class FlipFitAdmin extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    public FlipFitAdmin() {
        super("admin", "admin", "admin@flipfit.com", "admin", FlipFitRole.ADMIN);
    }
}