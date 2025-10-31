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
        String sql = "INSERT INTO patients(name, surname, age, phone, email, gender, bloodGroup, profile_photo)"
        + "VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, patient.getName());
            pst.setString(2, patient.getSurname());
            pst.setInt(3, patient.getAge());
            pst.setString(4, patient.getPhone());
            pst.setString(5, patient.getEmail());
            pst.setString(6, patient.getGender());
            pst.setString(7, patient.getBloodGroup());
            pst.setString(8, patient.getProfilePhoto());
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
        String sql = "UPDATE patients SET name=?, surname=?, age=?, phone=?, email=?, gender=?, bloodGroup=?, profile_photo=? WHERE id=?";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, patient.getName());
            pst.setString(2, patient.getSurname());
            pst.setInt(3, patient.getAge());
            pst.setString(4, patient.getPhone());
            pst.setString(5, patient.getEmail());
            pst.setString(6, patient.getGender());
            pst.setString(7, patient.getBloodGroup());
            pst.setString(8, patient.getProfilePhoto());
            pst.setInt(9, patient.getId());
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
