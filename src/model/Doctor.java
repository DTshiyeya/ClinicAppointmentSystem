/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author troy
 */
public class Doctor {
    private int doctorId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
    private String phone;
    private String gender;
    private String roomNumber;
    private String availability; // e.g., "Mon–Fri, 08:00–16:00"
    private Timestamp createdAt;
    
    public Doctor(){
        
    }
    
    public Doctor(int doctorId, String username, String password, String firstName, String lastName,
                  String specialization, String email, String phone, String gender,
                  String roomNumber, String availability, Timestamp createdAt){
        this.doctorId = doctorId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.roomNumber = roomNumber;
        this.availability = availability;
        this.createdAt = createdAt;
    }
    
    //Getters and Setters
    public int getDoctorId(){
        return doctorId; 
    }
    
    public void setDoctorId(int doctorId){
        this.doctorId = doctorId; 
    }

    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username; 
    }

    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password; 
    }

    public String getFirstName(){ 
        return firstName; 
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName; 
    }

    public String getLastName(){
        return lastName; 
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getSpecialization(){
        return specialization;
    }
    
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email; 
    }

    public String getPhone(){
        return phone; 
    }
    
    public void setPhone(String phone){
        this.phone = phone; 
    }

    public String getGender(){
        return gender; 
    }
    
    public void setGender(String gender){
        this.gender = gender; 
    }

    public String getRoomNumber(){
        return roomNumber;
    }
    
    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber; 
    }

    public String getAvailability(){
        return availability; 
    }
    
    public void setAvailability(String availability){
        this.availability = availability; 
    }

    public Timestamp getCreatedAt(){
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt; 
    }

    //Display info for debugging/logging
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", username='" + username + '\'' +
                ", name='" + firstName + " " + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
