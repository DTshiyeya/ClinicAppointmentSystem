/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AppointmentDAO;
import dao.DoctorDAO;
import dao.PatientDAO;
import model.Appointment;
import model.Doctor;
import model.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tshiy
 */
public class ReportService {
    private final PatientDAO patientDAO;
    private final DoctorDAO doctorDAO;
    private final AppointmentDAO appointmentDAO;

    public ReportService() {
        this.patientDAO = new PatientDAO();
        this.doctorDAO = new DoctorDAO();
        this.appointmentDAO = new AppointmentDAO();
    }

    //Total counts
    public int getTotalPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        return patients.size();
    }

    public int getTotalDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        return doctors.size();
    }

    public int getTotalAppointments() {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        return appointments.size();
    }

    //Count appointments by status
    public Map<String, Integer> getAppointmentStatusSummary() {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        Map<String, Integer> summary = new HashMap<>();

        for (Appointment a : appointments) {
            String status = a.getStatus();
            summary.put(status, summary.getOrDefault(status, 0) + 1);
        }

        return summary; // e.g. {Scheduled=10, Completed=5, Cancelled=2}
    }

    //Top doctors by number of appointments
    public Map<Integer, Integer> getDoctorActivityReport() {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        Map<Integer, Integer> doctorActivity = new HashMap<>();

        for (Appointment a : appointments) {
            int doctorId = a.getDoctorId();
            doctorActivity.put(doctorId, doctorActivity.getOrDefault(doctorId, 0) + 1);
        }

        return doctorActivity; // e.g. {1=8, 2=4, 3=10}
    }

    //Completed vs. Cancelled ratio
    public double getCompletionRate() {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        int total = appointments.size();
        int completed = 0;

        for (Appointment a : appointments) {
            if ("Completed".equalsIgnoreCase(a.getStatus())) {
                completed++;
            }
        }

        if (total == 0) return 0;
        return (completed * 100.0) / total;
    }

    //Get summary overview (for dashboard header)
    public Map<String, Object> getSystemSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("patients", getTotalPatients());
        summary.put("doctors", getTotalDoctors());
        summary.put("appointments", getTotalAppointments());
        summary.put("completionRate", getCompletionRate());
        summary.put("statusSummary", getAppointmentStatusSummary());
        return summary;
    }
}
