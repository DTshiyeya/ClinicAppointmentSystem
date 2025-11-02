/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author tshiy
 */
public class Notification {
    private int notificationId;
    private int userId;        // can refer to patientId or doctorId
    private String userType;   // "patient", "doctor", or "admin"
    private String title;      // e.g. "Appointment Reminder"
    private String message;    // detailed message
    private boolean isRead;    // true = viewed, false = new
    private Timestamp createdAt;

    public Notification() {
    
    }

    public Notification(int notificationId, int userId, String userType,
                        String title, String message, boolean isRead, Timestamp createdAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.userType = userType;
        this.title = title;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    //Getters and Setters
    public int getNotificationId(){
        return notificationId; 
    }
    
    public void setNotificationId(int notificationId){
        this.notificationId = notificationId; 
    }

    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId; 
    }

    public String getUserType(){
        return userType; 
    }
    
    public void setUserType(String userType){
        this.userType = userType; 
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title; 
    }

    public String getMessage(){
        return message; 
    }
    
    public void setMessage(String message){
        this.message = message;
    }

    public boolean isRead(){
        return isRead;
    }
    
    public void setRead(boolean read){
        isRead = read; 
    }

    public Timestamp getCreatedAt(){
        return createdAt; 
    }
    
    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt; 
    }

    //For debugging/logging
    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", userId=" + userId +
                ", userType='" + userType + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                ", createdAt=" + createdAt +
                '}';
    }
}
