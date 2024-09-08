package com.flipkart.constants;

public class SQLConstants {
    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO Gym (gymName, gymAddress, location, ownerId, Status) VALUES(?, ?, ?, ?, ?)";

    public static final String GYM_OWNER_ADD_SLOTS = "INSERT INTO Slots (startTime, seatCount, gymId) VALUES (?, ?, ?)";

    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE User SET password = ? WHERE email = ? AND password = ?";

    public static final String GYM_OWNER_UPDATE_PASSWORD = "UPDATE GymOwner SET password = ? WHERE ownerEmail = ? AND password = ?";

    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * FROM GymOwner WHERE ownerEmail = ? AND password = ?";

    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";

    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM Gym";

    public static final String ADMIN_VIEW_ALL_GYM_OWNERS = "SELECT * FROM GymOwner";

    public static final String ADMIN_VERIFY_GYM = "UPDATE Gym SET Status = 'verified' WHERE gymId = ?";

    public static final String ADMIN_VERIFY_GYM_OWNER = "UPDATE GymOwner SET verificationStatus = 'verified' WHERE ownerId = ?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM Gym WHERE Status = 'unverified'";

    public static final String ADMIN_VIEW_UNVERIFIED_GYM_OWNERS = "SELECT * FROM GymOwner WHERE verificationStatus = 'unverified'?";

    public static final String INSERT_GYM_OWNER = "INSERT INTO GymOwner (ownerName, ownerEmail, password, phoneNo, nationalId, GST, PAN, verificationStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String GYM_OWNER_VIEW_GYMS = "SELECT * FROM Gym WHERE ownerId = ?";

    public static final String GET_SLOTS_BY_GYM_ID = "SELECT * FROM Slots WHERE gymId = ?";

    public static final String UPDATE_GYM_OWNER = "UPDATE GymOwner SET ownerName = ?, phoneNo = ? WHERE ownerEmail = ?";

    public static final String UPDATE_USER = "UPDATE User SET userName = ?, phoneNumber = ? WHERE email = ?";

    public static final String GYM_OWNER_UPDATE_SEAT_COUNT = "UPDATE Slots SET seatCount = seatCount + ? WHERE startTime = ? AND gymId = ?)";

    public static final String GET_SEAT_COUNT = "SELECT seatCount FROM Slots WHERE gymId = ? AND startTime = ?";

    public static final String GET_GYM_OWNER_ID_BY_EMAIL = "SELECT ownerId FROM GymOwner WHERE ownerEmail = ?";

    public static final String INSERT_USER = "INSERT INTO User (userName, email, password, phoneNumber, address, location) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String VERIFY_USER_PASSWORD = "SELECT * FROM User WHERE email = ? and password = ?";

    public static final String GET_USER_ID_BY_EMAIL = "SELECT userId FROM User WHERE email = ?";

    public static final String GET_GYMS_BY_AREA = "SELECT * FROM Gym WHERE gymAddress LIKE '%?%' OR location LIKE '%?%'";

    public static final String GET_SLOTS_ID_BY_GYM_ID_AND_START_TIME = "SELECT slotsId FROM Slots WHERE gymId = ? AND startTime = ?";

    public static final String GET_GYMS_WITH_SLOTS = "SELECT * FROM Gym WHERE gymId IN (SELECT gymId FROM Slots WHERE seatCount > 0)";

    public static final String INSERT_BOOKING = "INSERT INTO Bookings (userId, bookingStatus, time, slotId, gymId) VALUES (?, ?, ?, ?, ?)";

    public static final String GET_BOOKINGS_BY_USER_ID = "SELECT * FROM Bookings WHERE userId = ?";

    public static final String UPDATE_BOOKING_STATUS = "UPDATE Bookings SET bookingStatus = ? WHERE bookingId = ?";

    public static final String GET_BOOKING_BY_BOOKING_ID = "SELECT * FROM Bookings WHERE bookingId = ?";
}
