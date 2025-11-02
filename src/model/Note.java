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
public class Note {
    private int noteId;
    private int doctorId;
    private int patientId;
    private int appointmentId;
    private String title;       // e.g. "Follow-up on chest pain"
    private String content;     // full note text
    private Timestamp createdAt;

    public Note() {
    
    }

    public Note(int noteId, int doctorId, int patientId, int appointmentId,
                String title, String content, Timestamp createdAt) {
        this.noteId = noteId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    //Getters and Setters
    public int getNoteId(){
        return noteId; 
    }
    
    public void setNoteId(int noteId){
        this.noteId = noteId; 
    }

    public int getDoctorId(){
        return doctorId; 
    }
    
    public void setDoctorId(int doctorId){
        this.doctorId = doctorId; 
    }

    public int getPatientId(){
        return patientId; 
    }
    
    public void setPatientId(int patientId){
        this.patientId = patientId; 
    }

    public int getAppointmentId(){
        return appointmentId; 
    }
    
    public void setAppointmentId(int appointmentId){
        this.appointmentId = appointmentId; 
    }

    public String getTitle(){
        return title; 
    }
    
    public void setTitle(String title){
        this.title = title; 
    }

    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content; 
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
        return "Note{" +
                "noteId=" + noteId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", appointmentId=" + appointmentId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
