/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author troy
 */
public class Patient {
    private int patientId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String idNumber;
    private Timestamp createdAt;
    
    // Medical info (optional, linked to patient_medical_info table)
    private String bloodType;
    private String allergies;
    private String currentMedications;
    private String diagnosis;
    
    //Empty constructor
    public Patient(){
        
    }
    
    //Constructor with all fields
    public Patient(int patientId, String username, String password, String firstName, String lastName,
                   String gender, int age, String email, String phone, Date dateOfBirth,
                   String idNumber, Timestamp createdAt, String bloodType,
                   String allergies, String currentMedications, String diagnosis){
        this.patientId = patientId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.createdAt = createdAt;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.currentMedications = currentMedications;
        this.diagnosis = diagnosis;
    }
    
     //Getters and Setters
    public int getPatientId(){ 
        return patientId;
    }
    
    public void setPatientId(int patientId){
        this.patientId = patientId;
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

    public String getGender(){
        return gender; 
    }
    
    public void setGender(String gender){
        this.gender = gender; 
    }

    public int getAge(){
        return age; 
    }
    
    public void setAge(int age){
        this.age = age; 
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

    public Date getDateOfBirth(){
        return dateOfBirth; 
    }
    
    public void setDateOfBirth(Date dateOfBirth){ 
        this.dateOfBirth = dateOfBirth; 
    }

    public String getIdNumber(){ 
        return idNumber; 
    }
    
    public void setIdNumber(String idNumber){
        this.idNumber = idNumber; 
    }

    public Timestamp getCreatedAt(){ 
        return createdAt; 
    }
    
    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt; 
    }

    public String getBloodType(){
        return bloodType; 
    }
    
    public void setBloodType(String bloodType){ 
        this.bloodType = bloodType; 
    }

    public String getAllergies(){ 
        return allergies; 
    }
    
    public void setAllergies(String allergies){
        this.allergies = allergies; 
    }

    public String getCurrentMedications(){ 
        return currentMedications; 
    }
    
    public void setCurrentMedications(String currentMedications){ 
        this.currentMedications = currentMedications; 
    }

    public String getDiagnosis(){
        return diagnosis; 
    }
    
    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis; 
    }

    //For debugging or logs
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", username='" + username + '\'' +
                ", name='" + firstName + " " + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}