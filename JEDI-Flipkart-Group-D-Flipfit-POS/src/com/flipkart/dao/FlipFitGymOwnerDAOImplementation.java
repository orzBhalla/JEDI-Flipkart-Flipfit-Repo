//package com.flipkart.dao;
//
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.GymOwner;
//import com.flipkart.bean.Slots;
//import com.flipkart.constants.SQLConstants;
//import com.flipkart.exception.RegistrationFailedException;
//import com.flipkart.exception.SlotInsertionFailedException;
//import com.flipkart.utils.DatabaseConnector;
//
//import java.sql.*;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FlipFitGymOwnerDAOImplementation {
//    Connection conn;
//
//    DatabaseConnector connector;
//    @Override
//    public void addGym(Gym gym){
//        conn = DatabaseConnector.getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//
//        int id = 0;
//        try {
//            statement = conn.createStatement();
//            preparedStatement =  conn.prepareStatement(SQLConstants.GYM_OWNER_INSERT_GYM, statement.RETURN_GENERATED_KEYS);
//
//
//            preparedStatement.setString(1, gym.getGymAddress());
//            preparedStatement.setString(2, gym.getLocation());
//            preparedStatement.setString(3, gym.getGymName());
//            preparedStatement.setString(4, gym.getStatus());
//            preparedStatement.setString(5, gym.getOwnerId());
//
//            int rowsInserted = preparedStatement.executeUpdate();
//
//            if (rowsInserted > 0) {
//                System.out.println("Record inserted successfully!");
//            } else {
//                throw new RegistrationFailedException();
//////                System.out.println("Failed to insert the record.");
////                return ;
//            }
//            ResultSet rs = preparedStatement.getGeneratedKeys();
//
//            if (rs.next()) {
//                id = rs.getInt(1);
//            }
//
//
//        } catch (RegistrationFailedException ex){
//            System.out.println("Gym "+ex.getMessage());
//
//        }
//        catch (SQLException e) {
//
//            System.out.println(e.getMessage());
//        }
//        insertSlots(gym.getSlots(),id);
//
//    }
//
//    @Override
//    public void newGymOwner(GymOwner gymOwner) {
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//        conn = DatabaseConnector.getConnection();
//
//
//        try {
//            statement = conn.createStatement();
////            resultSet = statement.executeQuery(insertQuery);
//            preparedStatement =  conn.prepareStatement(SQLConstants.GYM_OWNER_INSERT);
//
//            // 5. Set values for the placeholders in the prepared statement
//
//            preparedStatement.setString(1, gymOwner.getOwnerEmail());
//            preparedStatement.setString(2, gymOwner.getOwnerName());
//            preparedStatement.setString(3, gymOwner.getPassword());
//            preparedStatement.setString(4, gymOwner.getPhoneNo());
//            preparedStatement.setString(5, gymOwner.getPAN());
//            preparedStatement.setString(6, gymOwner.getGST());
//            preparedStatement.setString(7,gymOwner.getNationalId());
//            preparedStatement.setString(8, gymOwner.getStatus());
//
//            int rowsInserted = preparedStatement.executeUpdate();
//
//            if (rowsInserted > 0) {
//                System.out.println("Record inserted successfully!");
//            } else {
//                throw new RegistrationFailedException();
////                System.out.println("Failed to insert the record.");
////                return ;
//            }
//
//        }catch(RegistrationFailedException ex){
//            System.out.println("Gym Owner" + ex.getMessage());
//        }catch (SQLException e) {
//            System.out.println(e.getMessage());
////            e.printStackTrace();
////            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public boolean validateLogin(String email, String password) {
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
//                return true;
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
////            throw new RuntimeException(e);
//        }
//
//        return false;
//    }
//
//    @Override
//    public void insertSlots(List<Slots> slots, int gymId){
//        conn = DatabaseConnector.getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//
//        for( Slots slot: slots){
//            String insertQuery = "INSERT INTO slots (startTime, seatCount, gymId) VALUES (?, ?, ?)";
//
//            try {
//                statement = conn.createStatement();
////                resultSet = statement.executeQuery(insertQuery);
//                preparedStatement =  conn.prepareStatement(insertQuery);
//
//                // 5. Set values for the placeholders in the prepared statement
//
//                preparedStatement.setInt(1, slot.getStartTime());
//                preparedStatement.setInt(2, slot.getSeatCount());
//                preparedStatement.setInt(3, gymId);
//
//                int rowsInserted = preparedStatement.executeUpdate();
//
//                if (rowsInserted > 0) {
//                    System.out.println("Record inserted successfully!");
//                } else {
//                    throw new SlotInsertionFailedException();
//
////                    System.out.println("Failed to insert the record.");
////                    return ;
//                }
//
//            }catch(SlotInsertionFailedException | SQLException ex){
//                System.out.println(ex.getMessage());
//            }
////
//        }
//
//
//    }
//
//    @Override
//    public List<Gym> viewGymSlots(String gymOwnerID) {
//        conn = DatabaseConnector.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<Gym> gyms = new ArrayList<>();
//
//        try {
//            String sqlQuery = "SELECT * FROM gyms WHERE ownerId=?";
//            preparedStatement = conn.prepareStatement(sqlQuery);
//            preparedStatement.setString(1, gymOwnerID);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("gymId");
//                String gymAddress = resultSet.getString("gymAddress");
//                String location = resultSet.getString("location");
//                String gymName = resultSet.getString("gymName");
//                String status = resultSet.getString("status");
//                Gym gym = new Gym();
//                gym.setGymName(gymName);
//                gym.setGymAddress(gymAddress);
//                gym.setOwnerId(gymOwnerID);
//                gym.setLocation(location);
//                gym.setStatus(status);
//                gyms.add(gym);
//
//                List<Slots> slots = getGymSlotsWithGymId(id);
//                gym.setSlots(slots);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return gyms;
//    }
//
//    public List<Slots> getGymSlotsWithGymId(int id){
//        conn = DatabaseConnector.getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        List<Slots> slotList = new ArrayList<>();
//        try {
//            String sqlQuery = "SELECT * FROM slots WHERE gymId= " + id;
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery(sqlQuery);
//            while (resultSet.next()) {
//
//                int startTime = resultSet.getInt("startTime");
//                int seats = resultSet.getInt("seatCount");
//                Slots slots = new Slots(1,startTime,seats);
//
//                slotList.add(slots);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return slotList;
//    }
//}