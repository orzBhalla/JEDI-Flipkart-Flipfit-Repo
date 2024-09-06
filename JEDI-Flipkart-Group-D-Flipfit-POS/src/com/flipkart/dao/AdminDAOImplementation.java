package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

import java.util.List;
import java.sql.*;


public class AdminDAOImplementation implements AdminDAOInterface {
    DatabaseConnector connector;
    Connection connection;

    @Override
    public void viewGyms() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DatabaseConnector.getConnection();
            String sqlQuery = SQLConstants.ADMIN_VIEW_ALL_GYMS;
            //preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_USERS);
            preparedStatement = conn.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String ownerId = resultSet.getString("ownerId");
                String name = resultSet.getString("gymName");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String status = resultSet.getString("status");

                // Print the data or perform any other operations you need
                System.out.println("Gym ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Owner Id : " + ownerId);
                System.out.println("Gym Address : " + gymAddress);
                System.out.println("Gym Location : " + location);
                System.out.println("Status of Gym(verified or not) : " + status);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewUsers() {

    }

    @Override
    public void viewGymOwners() {

    }

    @Override
    public void verifyGymOwners(int id) {

    }

    @Override
    public void verifyGyms(int id) {

    }

    @Override
    public List<Gym> getUnverifiedGyms() {
        return List.of();
    }

    @Override
    public List<GymOwner> getUnverifiedGymOwner() {
        return List.of();
    }
}
