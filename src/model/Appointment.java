/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author troy
 */
public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private Time appointmentTime;
    private String reason;
    private String status; // e.g. Scheduled, Completed, Cancelled, Pending
    private Timestamp createdAt;
    
    //Proposed update fields (for rescheduling requests)
    private Date proposedDate;
    private Time proposedTime;
    private String proposedReason;
    
    public Appointment(){
        
    }
    
    public Appointment(int appointmentId, int patientId, int doctorId, Date appointmentDate,
                       Time appointmentTime, String reason, String status, Timestamp createdAt,
                       Date proposedDate, Time proposedTime, String proposedReason){
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.status = status;
        this.createdAt = createdAt;
        this.proposedDate = proposedDate;
        this.proposedTime = proposedTime;
        this.proposedReason = proposedReason;
    }
    
    //Getters and Setters
    public int getAppointmentId(){
        return appointmentId; 
    }
    
    public void setAppointmentId(int appointmentId){
        this.appointmentId = appointmentId; 
    }

    public int getPatientId(){
        return patientId; 
    }
    
    public void setPatientId(int patientId){
        this.patientId = patientId; 
    }

    public int getDoctorId(){
        return doctorId; 
    }
    
    public void setDoctorId(int doctorId){
        this.doctorId = doctorId; 
    }

    public Date getAppointmentDate(){
        return appointmentDate; 
    }
    
    public void setAppointmentDate(Date appointmentDate){
        this.appointmentDate = appointmentDate; 
    }

    public Time getAppointmentTime(){
        return appointmentTime; 
    }
    
    public void setAppointmentTime(Time appointmentTime){
        this.appointmentTime = appointmentTime; 
    }

    public String getReason(){
        return reason; 
    }
    
    public void setReason(String reason){
        this.reason = reason; 
    }

    public String getStatus(){
        return status; 
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public Timestamp getCreatedAt(){
        return createdAt; 
    }
    
    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt;
    }

    public Date getProposedDate(){
        return proposedDate; 
    }
    
    public void setProposedDate(Date proposedDate){
        this.proposedDate = proposedDate; 
    }

    public Time getProposedTime(){
        return proposedTime; 
    }
    
    public void setProposedTime(Time proposedTime){
        this.proposedTime = proposedTime; 
    }

    public String getProposedReason(){
        return proposedReason; 
    }
    
    public void setProposedReason(String proposedReason){
        this.proposedReason = proposedReason;
    }

    //Display information for debugging/logging
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", date=" + appointmentDate +
                ", time=" + appointmentTime +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
