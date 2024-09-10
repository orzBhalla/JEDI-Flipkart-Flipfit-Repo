package com.flipkart.bean;

package com.flipkart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents notifications in the GymFlipFit application.
 * It stores information about the notification's category, message, and notification ID.
 * Author: bhavya.khandelwal
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notifications {

    private String category; // Category of the notification
    private String message; // Message content of the notification
    private int notificationId; // Unique identifier for the notification

}
