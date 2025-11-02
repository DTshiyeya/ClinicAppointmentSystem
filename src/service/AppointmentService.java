/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AppointmentDAO;
import dao.NotificationDAO;
import model.Appointment;
import model.Notification;
import util.Validator;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author tshiy
 */
public class AppointmentService {
    private AppointmentDAO appointmentDAO;
    private NotificationDAO notificationDAO;

    public AppointmentService() {
        this.appointmentDAO = new AppointmentDAO();
        this.notificationDAO = new NotificationDAO();
    }

    //Book new appointment
    public boolean bookAppointment(Appointment appointment) {
        // Validate date and time
        if (appointment.getAppointmentDate() == null || appointment.getAppointmentTime() == null) {
            Validator.showError("Appointment", "Date and time are required");
            return false;
        }

        // Prevent booking in the past
        Date today = new Date(System.currentTimeMillis());
        if (appointment.getAppointmentDate().before(today)) {
            Validator.showError("Appointment", "Cannot book an appointment in the past");
            return false;
        }

        // Save to DB
        boolean success = appointmentDAO.addAppointment(appointment);

        if (success) {
            // Send notifications
            Notification notification = new Notification();
            notification.setUserId(appointment.getPatientId());
            notification.setUserType("patient");
            notification.setTitle("Appointment Booked");
            notification.setMessage("Your appointment with Doctor ID " + appointment.getDoctorId() +
                                    " is booked for " + appointment.getAppointmentDate() + " at " + appointment.getAppointmentTime());
            notification.setRead(false);
            notificationDAO.addNotification(notification);

            System.out.println("✅ Appointment booked and notification sent.");
        }

        return success;
    }

    //Update or reschedule appointment
    public boolean updateAppointment(Appointment appointment) {
        boolean success = appointmentDAO.updateAppointment(appointment);

        if (success) {
            Notification notification = new Notification();
            notification.setUserId(appointment.getPatientId());
            notification.setUserType("patient");
            notification.setTitle("Appointment Updated");
            notification.setMessage("Your appointment has been updated to " +
                    appointment.getAppointmentDate() + " at " + appointment.getAppointmentTime());
            notification.setRead(false);
            notificationDAO.addNotification(notification);

            System.out.println("🔁 Appointment updated and patient notified.");
        }

        return success;
    }

    //Cancel appointment
    public boolean cancelAppointment(int appointmentId, int patientId) {
        boolean success = appointmentDAO.cancelAppointment(appointmentId);

        if (success) {
            Notification notification = new Notification();
            notification.setUserId(patientId);
            notification.setUserType("patient");
            notification.setTitle("Appointment Cancelled");
            notification.setMessage("Your appointment ID " + appointmentId + " has been cancelled.");
            notification.setRead(false);
            notificationDAO.addNotification(notification);

            System.out.println("❌ Appointment cancelled and notification sent.");
        }

        return success;
    }

    //Get appointments by patient
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        return appointmentDAO.getAppointmentsByPatient(patientId);
    }

    //Get appointments by doctor
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentDAO.getAppointmentsByDoctor(doctorId);
    }

    //Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}
