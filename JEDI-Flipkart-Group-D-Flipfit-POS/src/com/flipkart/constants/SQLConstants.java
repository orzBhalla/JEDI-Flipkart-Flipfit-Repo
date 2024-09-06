package com.flipkart.constants;

public class SQLConstants {

    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO Gym (GymName, GymAddress, Location, IsGymVerified, GymOwnerId) VALUES(?,?,?,?,?)";

    public static final String GYM_OWNER_VIEW_GYM = "SELECT GymName, GymAddress, Location, IsGymVerified FROM Gym WHERE GymOwnerId = ?";

    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE User SET Password = ? WHERE EmailId = ? AND Password = ?";

    public static final String GYM_OWNER_UPDATE_PASSWORD = "UPDATE GymOwner SET GymOwnerPassword = ? WHERE GymOwnerEmail = ? AND Password = ?";

    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * FROM User WHERE EmailId = ? AND UserPassword = ?";

    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * FROM GymOwner WHERE GymOwnerEmail = ? AND GymOwnerPassword = ?";

    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";

    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM Gym";

    public static final String ADMIN_VIEW_ALL_GYMOWNERS = "SELECT * FROM GymOwner";

    public static final String ADMIN_VERIFY_GYMS = "UPDATE Gym SET IsGymVerified = ? WHERE GymId = ?";

    public static final String ADMIN_VERIFY_GYMOWNERS = "UPDATE GymOwner SET IsVerified = ? WHERE id = ?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM Gym WHERE IsGymVerified =?";

    public static final String ADMIN_VIEW_UNVERIFIED_GYMOWNER = "SELECT * FROM GymOwner WHERE IsVerified =?";

    public static final String GYM_OWNER_INSERT = "INSERT INTO GymOwner(GymOwnerEmail, GymOwnerName, GymOwnerPassword, PhoneNumber, PANId, NationalId, GST, IsVerified) VALUES(?,?,?,?,?,?,?,?)";
}
