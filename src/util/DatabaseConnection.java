/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tshiy
 */
public class DatabaseConnection {
    // Adjust to match your XAMPP settings
    private static final String URL = "jdbc:mysql://localhost:3306/REDSTONE";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // add password if you set one

    private static Connection connection = null;

    // Method to get or create the connection
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database connected successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
        }
        return connection;
    }

    // Optional: close the connection cleanly
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // ---------- Quick test main ----------
    public static void main(String[] args) {
        System.out.println("Testing DB connection...");
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection object: " + conn);
            closeConnection();
        } else {
            System.out.println("Connection is null — check XAMPP/MySQL and DB existence.");
        }
    }
}
