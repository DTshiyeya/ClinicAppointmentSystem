/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author troy
 */
public class Patient {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String email;
    private String gender;
    private String bloodGroup;
    private String profilePhoto;
    
    //Empty constructor
    public Patient(){
        
    }
    
    //Constructor with all fields
    public Patient(int id, String name, String surname, int age, String phone, String email, String gender, String bloodGroup, String profilePhoto){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.profilePhoto = profilePhoto;
    }
    
    //Getters and setters
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getBloodGroup(){
        return bloodGroup;
    }
    
    public void setBloodGroup(String bloodGroup){
        this.bloodGroup = bloodGroup;
    }
    
    public String getProfilePhoto(){
        return profilePhoto;
    }
    
    public void setProfilePhoto(String profilePhoto){
        this.profilePhoto = profilePhoto;
    }
    
    @Override
    public String toString(){
        return name + " " + surname;
    }
}
