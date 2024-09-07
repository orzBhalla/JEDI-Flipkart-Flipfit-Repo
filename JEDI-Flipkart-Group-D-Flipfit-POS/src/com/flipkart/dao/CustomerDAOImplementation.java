package com.flipkart.dao;
import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.bean.User;
import com.flipkart.utils.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class CustomerDAOImplementation implements CustomerDAOInterface {
        DatabaseConnector connector ;
        Connection conn;
        @Override
        public List<Gym> getAllGymsByArea() {
            conn = DatabaseConnector.getConnection();
            List<Gym> gyms = new ArrayList<>();
            String sqlQuery = "SELECT * FROM Gym";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("gymId");
                    String gymAddress = resultSet.getString("gymAddress");
                    String location = resultSet.getString("location");
                    String gymName = resultSet.getString("gymName");
                    String status = resultSet.getString("status");
                    String gymOwnerID = resultSet.getString("ownerid");

                    if (Objects.equals(status, "unverified")) continue;

                    Gym gym = new Gym();
                    gym.setGymName(gymName);
                    gym.setGymAddress(gymAddress);
                    gym.setOwnerId(Integer.parseInt(gymOwnerID));
                    gym.setLocation(location);
                    gym.setStatus(status);
                    gym.setGymId(id);
                    gyms.add(gym);

                    List<Slots> slots = getGymSlotsWithGymId(id);
                    gym.setSlots(slots);
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return gyms;
        }

        @Override
        public boolean bookSlot(int gymId, int time, String email) {
            //check the variable names in sql query

            String insertQuery = "INSERT INTO Booking (userId, status, date, time, slotId, GymId) VALUES (?, ?, ?, ?, ?, ?)";
            int alreadyBooked = getSeatNumberWithGymIDandSlotId(gymId, time);
            int remaining = getSeatNumberWithGymIDandSlotIdFromSlots(gymId, time);

            if (remaining <= 0) {
                System.out.println("No slots available");
                return false;
            }

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

                preparedStatement.setString(1, email);
                preparedStatement.setString(2, "CONFIRMED");
                preparedStatement.setInt(3, 11); // Assuming date is fixed as 11 for simplicity; replace if needed
                preparedStatement.setInt(4, time);
                preparedStatement.setInt(5, time);
                preparedStatement.setInt(6, gymId);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Record inserted successfully!");
                    alterSeatsWithGymIDSlotID(gymId, time, remaining - 1);
                    return true;
                } else {
                    System.out.println("Failed to insert the record.");
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return false;
        }

        private int getSeatNumberWithGymIDandSlotIdFromSlots(int gymId, int time) {

            //check the variable names in sql query
            String sqlQuery = "SELECT seatCount FROM slots WHERE gymId = ? AND startTime = ?";
            int seatCount = 0;

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setInt(1, gymId);
                preparedStatement.setInt(2, time);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        seatCount = resultSet.getInt("seatCount");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return seatCount;
        }

        private void alterSeatsWithGymIDSlotID(int gymId, int time, int x) {

            //check the variable names in sql query
            String sqlQuery = "UPDATE slots SET seatCount = ? WHERE gymId = ? AND startTime = ?";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setInt(1, x);
                preparedStatement.setInt(2, gymId);
                preparedStatement.setInt(3, time);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Seats updated successfully!");
                } else {
                    System.out.println("Failed to update seats.");
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }
        }

        private int getSeatNumberWithGymIDandSlotId(int gymId, int time) {

            //check the variable names in sql query
            String sqlQuery = "SELECT COUNT(*) FROM Booking WHERE gymId = ? AND time = ?";
            int number = 0;

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setInt(1, gymId);
                preparedStatement.setInt(2, time);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        number = resultSet.getInt(1);
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return number;
        }

        @Override
        public List<Bookings> getAllBookingByUserID(String userId) {
            List<Bookings> bookings = new ArrayList<>();
            String sqlQuery = "SELECT * FROM Booking WHERE userId = ?";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setString(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Bookings booking = new Bookings();
                        booking.setBookingId(resultSet.getInt("bookingId"));
                        booking.setDate(resultSet.getInt("date"));
                        booking.setTime(resultSet.getInt("time"));
                        booking.setSlotId(resultSet.getInt("slotId"));
                        booking.setStatus(resultSet.getString("status"));
                        booking.setGymId(resultSet.getInt("gymId"));
                        bookings.add(booking);
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return bookings;
        }

        @Override
        public boolean cancelBooking(int bookingId) {
            String sqlQuery = "DELETE FROM Booking WHERE bookingId = ?";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setInt(1, bookingId);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Booking cancelled successfully!");
                    return true;
                } else {
                    System.out.println("Failed to cancel booking.");
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return false;
        }

        @Override
        public boolean validateUser(String username, String pass) {
            String sqlQuery = "SELECT password FROM User WHERE email = ?";
            String storedPassword = "-";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        storedPassword = resultSet.getString("password");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return storedPassword.equals(pass);
        }

        @Override
        public void createUser(User user) {
            String insertQuery = "INSERT INTO User (userName, email, password, phoneNumber, Address, location) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getPhoneNumber());
                preparedStatement.setString(5, user.getAddress());
                preparedStatement.setString(6, user.getLocation());

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("User created successfully!");
                } else {
                    System.out.println("Failed to create user.");
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }
        }

        public List<Slots> getGymSlotsWithGymId(int id) {
            List<Slots> slotList = new ArrayList<>();
            String sqlQuery = "SELECT * FROM slots WHERE gymId = ?";

            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Slots slot = new Slots(resultSet.getInt("gymId"), resultSet.getInt("startTime"),resultSet.getInt("endTime"), resultSet.getInt("seatCount") );

                        slotList.add(slot);
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }

            return slotList;
        }

    public abstract boolean getUserByEmail(String email);
}


