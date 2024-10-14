package com.flipkart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a time slot for gym bookings in the GymFlipFit application.
 * It stores information about the slot ID, start time, and available seat count.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Slots {

    private int slotsId; // Unique identifier for the slot
    private int startTime; // Start time of the slot
    private int seatCount; // Number of available seats in the slot

}
