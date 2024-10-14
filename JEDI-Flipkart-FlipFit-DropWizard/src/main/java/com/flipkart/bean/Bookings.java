package com.flipkart.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a booking in the system. Contains details about the booking including the user, date, time, and status.
 *
 * @author Adarsh, Shriya
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
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

}

//package com.flipkart.bean;
//
//public class Bookings {
//    private int bookingId;
//    private int userId;
//    private int createdAt;
//    private int bookingStatus;
//    private int date;
//    private int time;
//    private int slotId;
//    private int gymId;
//    private String status;
//
//    public int getDate() {
//        return date;
//    }
//
//    public void setDate(int date) {
//        this.date = date;
//    }
//
//    public int getSlotId() {
//        return slotId;
//    }
//
//    public void setSlotId(int slotId) {
//        this.slotId = slotId;
//    }
//
//    public int getGymId() {
//        return gymId;
//    }
//
//    public void setGymId(int gymId) {
//        this.gymId = gymId;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
//
//    public int getBookingId() {
//        return bookingId;
//    }
//
//    public void setBookingId(int bookingId) {
//        this.bookingId = bookingId;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(int createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public int getBookingStatus() {
//        return bookingStatus;
//    }
//
//    public void setBookingStatus(int bookingStatus) {
//        this.bookingStatus = bookingStatus;
//    }
//}