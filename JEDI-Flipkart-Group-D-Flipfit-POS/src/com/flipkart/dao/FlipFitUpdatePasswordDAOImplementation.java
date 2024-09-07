package com.flipkart.dao;

import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.WrongCredentialsException;
import com.flipkart.utils.DatabaseConnector;

import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;

public class FlipFitUpdatePasswordDAOImplementation implements FlipFitUpdatePasswordDAOInterface {
    DatabaseConnector connector;
    Connection conn;


    public boolean updateGymOwnerPassword(String email, String password, String updatedPassword) {
        conn = DatabaseConnector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_UPDATE_PASSWORD, statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, updatedPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Password updated successfully!");
                return true;
            } else {
                throw new WrongCredentialsException();
            }
        } catch (WrongCredentialsException e) {
            System.out.println("(Gym owner) " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean updateGymUserPassword(String email, String password, String updatedPassword) {
        conn = DatabaseConnector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_USER_UPDATE_PASSWORD, statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, updatedPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Password updated successfully!");
                return true;
            } else {
                throw new WrongCredentialsException();
            }
        } catch (WrongCredentialsException e) {
            System.out.println("(Gym user) " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    public boolean verifyGymOwnerPassword(String email, String password) {
//        conn = DatabaseConnector.getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            statement = conn.createStatement();
//            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_VERIFY_PASSWORD, statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, email);
//            preparedStatement.setString(2, password);
//
//
//            int result = preparedStatement.executeUpdate();
//
//            if (result > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//
//    public boolean verifyGymUserPassword(String email, String password) {
//        conn = DatabaseConnector.getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            statement = conn.createStatement();
//            preparedStatement = conn.prepareStatement(SQLConstants.GYM_USER_VERIFY_PASSWORD, statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, email);
//            preparedStatement.setString(2, password);
//
//
//            ResultSet result = preparedStatement.executeQuery();
//
//            if (result.next()) {
//                if (result.getString("status").equals("Unverified")) {
//                    System.out.println("Unverified User, please contact admin to verify");
//                    return false;
//                }
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
}
