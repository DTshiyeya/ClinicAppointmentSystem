/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import util.DatabaseConnection;
import util.ImageHelper;

import java.awt.Image;
import java.io.InputStream;
import java.sql.*;

/**
 *
 * @author tshiy
 */
public class ImageService {
    //Save image to database
    public boolean saveProfileImage(int userId, String userType, InputStream imageStream) {
        String sql = "UPDATE " + userType + "s SET profile_photo = ? WHERE " + userType + "_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBlob(1, imageStream);
            stmt.setInt(2, userId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error saving image: " + e.getMessage());
            return false;
        }
    }

    //Retrieve image from database
    public Image getProfileImage(int userId, String userType) {
        String sql = "SELECT profile_photo FROM " + userType + "s WHERE " + userType + "_id = ?";
        Image image = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("profile_photo");
                if (blob != null) {
                    byte[] bytes = blob.getBytes(1, (int) blob.length());
                    image = ImageHelper.byteArrayToImage(bytes);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error retrieving image: " + e.getMessage());
        }

        return image;
    }

    //Convert image to byte array (for saving locally)
    public byte[] getProfileImageBytes(int userId, String userType) {
        String sql = "SELECT profile_photo FROM " + userType + "s WHERE " + userType + "_id = ?";
        byte[] bytes = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("profile_photo");
                if (blob != null) {
                    bytes = blob.getBytes(1, (int) blob.length());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bytes;
    }
}
