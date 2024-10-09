package com.flipkart.bean;

/**
 * Represents a booking in the FlipFit system.
 * A booking links a user to a specific schedule.
 */
public class FlipFitBooking {
    private String bookingID;
    private String userID;
    private String scheduleID;

    /**
     * Parameterized constructor to create a new booking.
     * @param userID ID of the user making the booking
     * @param scheduleID ID of the schedule being booked
     */
    public FlipFitBooking(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    /**
     * Parameterized constructor to create a booking with existing ID.
     * @param bookingID ID of the booking
     * @param userID ID of the user making the booking
     * @param scheduleID ID of the schedule being booked
     */
    public FlipFitBooking(String bookingID, String userID, String scheduleID) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    /**
     * Retrieves the booking ID.
     * @return Booking ID
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Sets the booking ID.
     * @param bookingID Booking ID to set
     */
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Retrieves the user ID associated with the booking.
     * @return User ID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user ID associated with the booking.
     * @param userID User ID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the schedule ID associated with the booking.
     * @return Schedule ID
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * Sets the schedule ID associated with the booking.
     * @param scheduleID Schedule ID to set
     */
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }
}