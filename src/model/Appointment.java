/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author troy
 */
public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private Time appointmentTime;
    private String reason;
    private String status;
    
    //Proposed update fields from the patient
    private Date proposedDate;
    private Time proposedTime;
    private String proposedReason;
    
    public Appointment(){
        
    }
    
    public Appointment(int id, int patientId, int doctorId, Date appointmentDate, Time appointmentTime, String reason, String status, Date proposedDate, Time proposedTime, String proposedReason){
        this.id = id;
        this.patientId  = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.status = status;
        this.proposedDate = proposedDate;
        this.proposedTime = proposedTime;
        this.proposedReason = proposedReason;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
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
}
