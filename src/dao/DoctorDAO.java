/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.Database;
import model.Doctor;
import java.sql.*;
import java.util.*;

/**
 *
 * @author tshiy
 */
public class DoctorDAO {
    //ADD new doctor
    public boolean addDoctor(Doctor doctor){
        String sql = "INSERT INTO doctors(name, surname, speciality, phone, email, profile_photo)"
        + "VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSurname());
            pst.setString(3, doctor.getSpeciality());
            pst.setString(4, doctor.getPhone());
            pst.setString(5, doctor.getEmail());
            pst.setString(6, doctor.getProfilePhoto());
            pst.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //GET all doctors
    public List<Doctor> getAllDoctors(){
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try(Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Doctor d = new Doctor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("speciality"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("profile_photo")
                );
                list.add(d);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    //UPDATE doctor
    public boolean updateDoctor(Doctor doctor){
        String sql = "UPDATE doctors SET name = ?, surname = ?, speciality = ?, phone=?, email=?, profile_photo=? WHERE id=?";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSurname());
            pst.setString(3, doctor.getSpeciality());
            pst.setString(4, doctor.getPhone());
            pst.setString(5, doctor.getEmail());
            pst.setString(6, doctor.getProfilePhoto());
            pst.setInt(7, doctor.getId());
            pst.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //DELETE doctor
    public boolean deleteDoctor(int id){
        String sql = "DELETE FROM doctors WHERE id=?";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
