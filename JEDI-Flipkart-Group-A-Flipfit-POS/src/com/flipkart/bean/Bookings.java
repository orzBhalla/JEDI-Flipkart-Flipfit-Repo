package com.flipkart.bean;

public class Bookings {

    /**
     * Unique identifier for the booking.
     */
    private int bookingId;

    /**
     * Unique identifier for the user who made the booking.
     */
    private int userId;

    /**
     * Timestamp indicating when the booking was created.
     */
    private int createdAt;

    /**
     * Status of the booking (e.g., confirmed, cancelled).
     */
    private int bookingStatus;

    /**
     * Date of the booking.
     */
    private int date;

    /**
     * Time of the booking.
     */
    private int time;

    /**
     * Identifier for the slot booked.
     */
    private int slotId;

    /**
     * Identifier for the gym where the booking was made.
     */
    private int gymId;

    /**
     * Status of the booking as a string (e.g., "active", "inactive").
     */
    private String status;

    /**
     * Gets the date of the booking.
     *
     * @return the date of the booking
     */
    public int getDate() {
        return date;
    }

    /**
     * Sets the date of the booking.
     *
     * @param date the date of the booking
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Gets the slot ID for the booking.
     *
     * @return the slot ID for the booking
     */
    public int getSlotId() {
        return slotId;
    }

    /**
     * Sets the slot ID for the booking.
     *
     * @param slotId the slot ID for the booking
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    /**
     * Gets the gym ID for the booking.
     *
     * @return the gym ID for the booking
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the gym ID for the booking.
     *
     * @param gymId the gym ID for the booking
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the status of the booking as a string.
     *
     * @return the status of the booking
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the booking as a string.
     *
     * @param status the status of the booking
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the time of the booking.
     *
     * @return the time of the booking
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets the time of the booking.
     *
     * @param time the time of the booking
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Gets the booking ID.
     *
     * @return the booking ID
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets the booking ID.
     *
     * @param bookingId the booking ID
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Gets the user ID for the booking.
     *
     * @return the user ID for the booking
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID for the booking.
     *
     * @param userId the user ID for the booking
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the timestamp of when the booking was created.
     *
     * @return the timestamp of when the booking was created
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp of when the booking was created.
     *
     * @param createdAt the timestamp of when the booking was created
     */
    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the booking status.
     *
     * @return the booking status
     */
    public int getBookingStatus() {
        return bookingStatus;
    }

    /**
     * Sets the booking status.
     *
     * @param bookingStatus the booking status
     */
    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}