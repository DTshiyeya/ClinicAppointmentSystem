/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;

/**
 *
 * @author troy
 */
public class Database {
    //Bridge info to connect to MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/clinic_system";
    private static final String USER = "root"; //your MySQL username
    private static final String PASSWORD = ""; //your MySQL password
    
    //Connect to database
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
    
    
