package com.flipkart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (isValid()) {
                return connection;
            } else {
                try {
                    Properties prop = new Properties();
                    InputStream inputStream = DatabaseConnector.class.getClassLoader().getResourceAsStream("./config.properties");
                    prop.load(inputStream);
                    String driver = prop.getProperty("driver");
                    String url = prop.getProperty("url");
                    String user = prop.getProperty("user");
                    String password = prop.getProperty("password");
                    Class.forName(driver);
                    connection = DriverManager.getConnection(url, user, password);
                } catch (ClassNotFoundException | SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean isValid() throws SQLException {
        // return false;
        return connection != null && !connection.isClosed();
    }
}