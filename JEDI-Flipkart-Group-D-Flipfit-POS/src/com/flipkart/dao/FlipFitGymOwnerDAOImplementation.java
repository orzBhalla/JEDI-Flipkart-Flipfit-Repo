package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.exception.SlotInsertionFailedException;
import com.flipkart.exception.UpdationFailedException;
import com.flipkart.utils.DatabaseConnector;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDAOImplementation implements FlipFitGymOwnerDAOInterface {
    Connection conn;
    DatabaseConnector connector;

    @Override
    public boolean addGym(Gym gym) {
        conn = DatabaseConnector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int gymId = -1;

        try {
            statement = conn.createStatement();

            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_INSERT_GYM, statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gym.getGymName());
            preparedStatement.setString(2, gym.getGymAddress());
            preparedStatement.setString(3, gym.getLocation());
            preparedStatement.setInt(4, gym.getOwnerId());
            preparedStatement.setString(5, gym.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted == 0) {
                throw new RegistrationFailedException();
            }

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                gymId = resultSet.getInt(1);
            }
        } catch (RegistrationFailedException e) {
            // System.out.println("Gym " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
        return addSlots(gymId, gym.getSlots());
    }

    @Override
    public boolean addSlots(int gymId, List<Slots> slots) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;

        for (Slots slot : slots) {
            try {
                preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_ADD_SLOTS);
                preparedStatement.setInt(1, slot.getStartTime());
                preparedStatement.setInt(2, slot.getSeatCount());
                preparedStatement.setInt(3, gymId);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    // System.out.println("Record inserted successfully!");
                } else {
                    throw new SlotInsertionFailedException();
                }
            } catch (SlotInsertionFailedException e) {
                // System.out.println(e.getMessage());
                return false;
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean createGymOwner(GymOwner gymOwner) {
        PreparedStatement preparedStatement = null;
        conn = DatabaseConnector.getConnection();

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.INSERT_GYM_OWNER);
            preparedStatement.setString(1, gymOwner.getOwnerName());
            preparedStatement.setString(2, gymOwner.getOwnerEmail());
            preparedStatement.setString(3, gymOwner.getPassword());
            preparedStatement.setString(4, gymOwner.getPhoneNo());
            preparedStatement.setString(5, gymOwner.getNationalId());
            preparedStatement.setString(6, gymOwner.getGST());
            preparedStatement.setString(7, gymOwner.getPAN());
            preparedStatement.setString(8, gymOwner.getVerificationStatus());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                // System.out.println("Record inserted successfully!");
                return true;
            } else {
                throw new RegistrationFailedException();
            }
        } catch (RegistrationFailedException e) {
            // System.out.println("Gym owner " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateGymOwner(GymOwner gymOwner) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.UPDATE_GYM_OWNER);
            preparedStatement.setString(1, gymOwner.getOwnerName());
            preparedStatement.setString(2, gymOwner.getPhoneNo());
            preparedStatement.setString(3, gymOwner.getOwnerEmail());

            preparedStatement.executeUpdate();

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                // System.out.println("Record updated successfully!");
                return true;
            } else {
                throw new UpdationFailedException();
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        } catch (UpdationFailedException e) {
            // System.out.println("Gym owner " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean validateGymOwner(String email, String password) {
        conn = DatabaseConnector.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_VERIFY_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public List<Gym> viewMyGyms(int ownerId) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_VIEW_GYMS);
            preparedStatement.setInt(1, ownerId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int gymId = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("Status");
                Gym gym = new Gym();
                gym.setGymId(gymId);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(ownerId);
                gym.setLocation(location);
                gym.setStatus(status);
                List<Slots> slots = getSlotsByGymId(gymId);
                gym.setSlots(slots);

                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return gyms;
    }

    public List<Slots> getSlotsByGymId(int gymId) {
        conn = DatabaseConnector.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<Slots> slotList = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.GET_SLOTS_BY_GYM_ID);
            preparedStatement.setInt(1, gymId);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int slotsId = resultSet.getInt("slotsId");
                int startTime = resultSet.getInt("startTime");
                int seatCount = resultSet.getInt("seatCount");
                Slots slots = new Slots(slotsId, startTime, seatCount);

                slotList.add(slots);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return slotList;
    }

    @Override
    public boolean updateSeatCount(int gymId, int startTime, int seatCount) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_UPDATE_SEAT_COUNT);
            preparedStatement.setInt(1, seatCount);
            preparedStatement.setInt(2, startTime);
            preparedStatement.setInt(3, gymId);

            preparedStatement.executeUpdate();

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                // System.out.println("Record updated successfully!");
                return true;
            } else {
                throw new UpdationFailedException();
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        } catch (UpdationFailedException e) {
            // System.out.println("Seat count " + e.getMessage());
            return false;
        }
    }

    public int getSeatCount(int gymId, int startTime) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int seatCount = -1;

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.GET_SEAT_COUNT);
            preparedStatement.setInt(1, gymId);
            preparedStatement.setInt(2, startTime);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seatCount = resultSet.getInt("seatCount");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return seatCount;
    }

    public int getGymOwnerIdByEmail(String email) {
        conn = DatabaseConnector.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int ownerId = -1;

        try {
            preparedStatement = conn.prepareStatement(SQLConstants.GET_GYM_OWNER_ID_BY_EMAIL);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ownerId = resultSet.getInt("ownerId");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return -1;
        }
        return ownerId;
    }
}