package com.flipkart.constants;

public class SQLConstants {
    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO Gym (gymName, gymAddress, location, ownerId, Status) VALUES(?, ?, ?, ?, ?)";

    public static final String GYM_OWNER_ADD_SLOTS = "INSERT INTO Slots (startTime, seatCount, gymId) VALUES (?, ?, ?)";

    public static final String GYM_OWNER_VIEW_GYM = "SELECT GymName, GymAddress, Location, IsGymVerified FROM Gym WHERE GymOwnerId = ?";

    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE User SET Password = ? WHERE EmailId = ? AND Password = ?";

    public static final String GYM_OWNER_UPDATE_PASSWORD = "UPDATE GymOwner SET GymOwnerPassword = ? WHERE GymOwnerEmail = ? AND Password = ?";

    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * FROM User WHERE EmailId = ? AND UserPassword = ?";

    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * FROM GymOwner WHERE ownerEmail = ? AND password = ?";

    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";

    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM Gym";

    public static final String ADMIN_VIEW_ALL_GYMOWNERS = "SELECT * FROM GymOwner";

    public static final String ADMIN_VERIFY_GYMS = "UPDATE Gym SET IsGymVerified = ? WHERE GymId = ?";

    public static final String ADMIN_VERIFY_GYMOWNERS = "UPDATE GymOwner SET IsVerified = ? WHERE id = ?"; //gym owner id check in schema

    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM Gym WHERE IsGymVerified = ?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMOWNER = "SELECT * FROM GymOwner WHERE IsVerified =?";

    public static final String INSERT_GYM_OWNER = "INSERT INTO GymOwner (ownerName, ownerEmail, password, phoneNo, nationalId, GST, PAN, verificationStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String GYM_OWNER_VIEW_GYMS = "SELECT * FROM Gym WHERE ownerId = ?";

    public static final String GET_SLOTS_BY_GYM_ID = "SELECT * FROM Slots WHERE gymId = ?";

    public static final String UPDATE_GYM_OWNER = "UPDATE GymOwner SET ownerName = ?, phoneNo = ? WHERE ownerEmail = ?";

    public static final String GYM_OWNER_UPDATE_SEAT_COUNT = "UPDATE Slots SET seatCount = seatCount + ? WHERE startTime = ? AND gymId = ?)";

    public static final String GET_GYM_OWNER_ID_BY_EMAIL = "SELECT ownerId FROM GymOwner WHERE ownerEmail = ?";

    public static final String INSERT_USER = "INSERT INTO User (userName, email, password, phoneNumber, address, location) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String VERIFY_USER_PASSWORD = "SELECT * FROM User WHERE email = ? and password = ?";

    public static final String GET_USER_ID_BY_EMAIL = "SELECT userId FROM User WHERE email = ?";
}
