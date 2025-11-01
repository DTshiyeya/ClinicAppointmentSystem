/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.Database;
import model.Patient;
import java.sql.*;
import java.util.*;

/**
 *
 * @author troy
 */
public class PatientDAO {
    //ADD new patient
    public boolean addPatient(Patient patient){
        String sql = "INSERT INTO patients(username, password, name, surname, age, phone, email, gender, bloodGroup, profile_photo)"
        + "VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, patient.getUsername());
            pst.setString(2, patient.getPassword());
            pst.setString(3, patient.getName());
            pst.setString(4, patient.getSurname());
            pst.setInt(5, patient.getAge());
            pst.setString(6, patient.getPhone());
            pst.setString(7, patient.getEmail());
            pst.setString(8, patient.getGender());
            pst.setString(9, patient.getBloodGroup());
            pst.setString(10, patient.getProfilePhoto());
            pst.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //GET all patients
    public List<Patient> getAllPatients(){
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try(Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Patient p = new Patient(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getInt("age"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("bloodGroup"),
                    rs.getString("profile_photo")
                );
                list.add(p);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    //UPDATE patient
    public boolean updatePatient(Patient patient){
        String sql = "UPDATE patients SET username=?, name=?, surname=?, age=?, phone=?, email=?, gender=?, bloodGroup=?, profile_photo=? WHERE id=?";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,patient.getUsername());
            pst.setString(2, patient.getName());
            pst.setString(3, patient.getSurname());
            pst.setInt(4, patient.getAge());
            pst.setString(5, patient.getPhone());
            pst.setString(6, patient.getEmail());
            pst.setString(7, patient.getGender());
            pst.setString(8, patient.getBloodGroup());
            pst.setString(9, patient.getProfilePhoto());
            pst.setInt(10, patient.getId());
            pst.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //DELETE patient
    public boolean deletePatient(int id){
        String sql = "DELETE FROM patients WHERE id=?";
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
