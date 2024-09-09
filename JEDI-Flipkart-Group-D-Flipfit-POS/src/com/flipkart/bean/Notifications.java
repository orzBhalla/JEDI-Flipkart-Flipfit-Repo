package com.flipkart.bean;

/**
 * Represents a notification with details such as category, message, and a unique identifier.
 * Contains information about the notification's category, message content, and ID.
 *
 * @author Shreya k, Adarsh
 */
public class Notifications {

    /**
     * Category of the notification (e.g., "Alert", "Reminder").
     */
    private String category;

    /**
     * Message content of the notification.
     */
    private String message;

    /**
     * Unique identifier for the notification.
     */
    private int notificationId;

    /**
     * Gets the unique identifier for the notification.
     *
     * @return the notificationId, which is the unique identifier for the notification.
     * @author Shreya k, Adarsh
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the unique identifier for the notification.
     *
     * @param notificationId the notificationId to set, which is the unique identifier for the notification.
     * @author Shreya k, Adarsh
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets the category of the notification.
     *
     * @return the category of the notification (e.g., "Alert", "Reminder").
     * @author Shreya k, Adarsh
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the notification.
     *
     * @param category the category to set for the notification (e.g., "Alert", "Reminder").
     * @author Shreya k, Adarsh
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the message content of the notification.
     *
     * @return the message content of the notification.
     * @author Shreya k, Adarsh
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the notification.
     *
     * @param message the message to set for the notification.
     * @author Shreya k, Adarsh
     */
    public void setMessage(String message) {
        this.message = message;
    }
}




//package com.flipkart.bean;
//
//public class Notifications {
//    private String category;
//    private String message;
//    private int notificationId;
//
//    public int getNotificationId() {
//        return notificationId;
//    }
//
//    public void setNotificationId(int notificationId) {
//        this.notificationId = notificationId;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//}