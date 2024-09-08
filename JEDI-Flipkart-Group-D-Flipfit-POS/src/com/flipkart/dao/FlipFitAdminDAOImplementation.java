package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.VerificationFailedException;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDAOImplementation implements FlipFitAdminDAOInterface {
    DatabaseConnector connector;
    Connection conn;

    @Override
    public List<Gym> viewGyms() {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_GYMS);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int gymId = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("Status");
                int ownerId = resultSet.getInt("ownerId");

                Gym gym = new Gym();
                gym.setGymId(gymId);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(ownerId);
                gym.setLocation(location);
                gym.setStatus(status);

                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return gyms;
    }

    @Override
    public List<User> viewUsers() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();

        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_USERS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String phoneNumber = resultSet.getString("phoneNumber");
                String userName = resultSet.getString("userName");
                String address = resultSet.getString("address");
                String location = resultSet.getString("location");
                String email = resultSet.getString("email");

                User user = new User();
                user.setUserId(userId);
                user.setPhoneNumber(phoneNumber);
                user.setUserName(userName);
                user.setAddress(address);
                user.setLocation(location);
                user.setEmail(email);

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return users;
    }

    @Override
    public List<GymOwner> viewGymOwners() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<GymOwner> gymOwners = new ArrayList<>();

        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_GYM_OWNERS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ownerId = resultSet.getInt("ownerId");
                String phoneNo = resultSet.getString("phoneNo");
                String ownerName = resultSet.getString("ownerName");
                String ownerEmail = resultSet.getString("ownerEmail");
                String nationalId = resultSet.getString("nationalId");
                String GST = resultSet.getString("GST");
                String PAN = resultSet.getString("PAN");
                String verificationStatus = resultSet.getString("verificationStatus");

                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(ownerId);
                gymOwner.setPhoneNo(phoneNo);
                gymOwner.setOwnerName(ownerName);
                gymOwner.setOwnerEmail(ownerEmail);
                gymOwner.setNationalId(nationalId);
                gymOwner.setGST(GST);
                gymOwner.setPAN(PAN);
                gymOwner.setVerificationStatus(verificationStatus);

                gymOwners.add(gymOwner);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return gymOwners;
    }

    @Override
    public boolean verifyGymOwner(int gymOwnerId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VERIFY_GYM_OWNER);

            preparedStatement.setInt(1, gymOwnerId);

            int rowsUpdated = preparedStatement.executeUpdate(); // execute update statement
            if (rowsUpdated > 0) {
                // System.out.println("Gym owner verified successfully!");
                return true;
            } else {
                throw new VerificationFailedException();
            }
        } catch (VerificationFailedException e) {
            // System.out.println("Gym owner " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean verifyGym(int gymId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VERIFY_GYM);

            preparedStatement.setInt(1, gymId);

            int rowsUpdated = preparedStatement.executeUpdate(); // execute update statement
            if (rowsUpdated > 0) {
                // System.out.println("Gym verified successfully!");
                return true;
            } else {
                throw new VerificationFailedException();
            }
        } catch (VerificationFailedException e) {
            // System.out.println("Gym " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Gym> getUnverifiedGyms() {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_UNVERIFIED_GYMS);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int gymId = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("Status");
                int ownerId = resultSet.getInt("ownerId");

                Gym gym = new Gym();
                gym.setGymId(gymId);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(ownerId);
                gym.setLocation(location);
                gym.setStatus(status);

                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gyms;
    }

    @Override
    public List<GymOwner> getUnverifiedGymOwners() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<GymOwner> gymOwners = new ArrayList<>();

        try {
            conn = DatabaseConnector.getConnection();
            preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_UNVERIFIED_GYM_OWNERS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ownerId = resultSet.getInt("ownerId");
                String phoneNo = resultSet.getString("phoneNo");
                String ownerName = resultSet.getString("ownerName");
                String ownerEmail = resultSet.getString("ownerEmail");
                String nationalId = resultSet.getString("nationalId");
                String GST = resultSet.getString("GST");
                String PAN = resultSet.getString("PAN");
                String verificationStatus = resultSet.getString("verificationStatus");

                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(ownerId);
                gymOwner.setPhoneNo(phoneNo);
                gymOwner.setOwnerName(ownerName);
                gymOwner.setOwnerEmail(ownerEmail);
                gymOwner.setNationalId(nationalId);
                gymOwner.setGST(GST);
                gymOwner.setPAN(PAN);
                gymOwner.setVerificationStatus(verificationStatus);

                gymOwners.add(gymOwner);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gymOwners;
    }
}