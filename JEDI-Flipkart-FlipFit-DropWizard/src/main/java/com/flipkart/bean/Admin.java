package com.flipkart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

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

}
