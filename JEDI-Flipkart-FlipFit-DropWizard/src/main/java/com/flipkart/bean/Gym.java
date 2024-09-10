package com.flipkart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a gym facility with various attributes.
 * @author Atulya, Avinash
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gym {

    private int gymId;
    private String gymName;
    private String gymAddress;
    private String location;
    private List<Slots> slots;
    private int ownerId;
    private String Status;
}
