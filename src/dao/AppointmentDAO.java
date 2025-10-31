/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.Database;
import model.Appointment;
import java.sql.*;
import java.util.*;

/**
 *
 * @author tshiy
 */
public class AppointmentDAO {
    //ADD appointment
    public boolean addAppointment(Appointment a){
        String sql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, notes, status)"
        + "VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection conn = Database.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, a.getPatientId());
            pst.setInt(2, a.getDoctorId());
            pst.setDate(3, a.getAppointmentDate());
            pst.setTime(4, a.getAppointmentTime());
            pst.setString(5, a.getReason());
            pst.setString(6, a.getStatus() == null ? "Pending" : a.getStatus());
            pst.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //GET all appointments
    public List<Appointment> getAllAppointments(){
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try(Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Appointment a = new Appointment(
                    rs.getInt("id"),
                    rs.getInt("patient_id"),
                    rs.getInt("doctor_id"),
                    rs.getDate("appointment_date"),
                    rs.getTime("appointment_time"),
                    rs.getString("notes"),
                    rs.getString("status"),
                    rs.getDate("proposedDate"),
                    rs.getTime("proposedTime"),
                    rs.getString("proposedReason")
                );
                list.add(a);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    //UPDATE appointment(patient or doctor)
    public boolean updateAppointment(Appointment appointment, String role) {
        String sql = "UPDATE appointments SET appointment_date = ?, appointment_time = ?, notes = ?, status = ? WHERE id = ?";

        // Patient updates → Pending Doctor Approval
        // Doctor updates → Approved by Doctor
        String newStatus = role.equalsIgnoreCase("patient") ? "Pending Doctor Approval" : "Approved by Doctor";

        try (Connection conn = Database.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setDate(1, appointment.getAppointmentDate());
            pst.setTime(2, appointment.getAppointmentTime());
            pst.setString(3, appointment.getReason());
            pst.setString(4, newStatus);
            pst.setInt(5, appointment.getId());

            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    
    //DELETE appointment
    public boolean deleteAppointment(int id){
        String sql = "DELETE FROM appointments WHERE id=?";
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

    // REQUEST appointment update (patient proposes changes)
    public boolean requestUpdate(Appointment a) {
        String sql = "UPDATE appointments SET proposed_date = ?, proposed_time = ?, proposed_reason = ?, status = 'Pending Doctor Approval' WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            if (a.getProposedDate() != null) pst.setDate(1, a.getProposedDate());
            else pst.setNull(1, java.sql.Types.DATE);

            if (a.getProposedTime() != null) pst.setTime(2, a.getProposedTime());
            else pst.setNull(2, java.sql.Types.TIME);

            pst.setString(3, a.getProposedReason());
            pst.setInt(4, a.getId());

            int updated = pst.executeUpdate();
            return updated > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // 6️⃣ GET pending updates for doctor
    public List<Appointment> getPendingUpdatesForDoctor(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctor_id = ? AND status = 'Pending Doctor Approval'";

        try (Connection conn = Database.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, doctorId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Appointment ap = new Appointment();
                ap.setId(rs.getInt("id"));
                ap.setPatientId(rs.getInt("patient_id"));
                ap.setDoctorId(rs.getInt("doctor_id"));
                ap.setAppointmentDate(rs.getDate("appointment_date"));
                ap.setAppointmentTime(rs.getTime("appointment_time"));
                ap.setReason(rs.getString("reason"));
                ap.setStatus(rs.getString("status"));
                ap.setProposedDate(rs.getDate("proposed_date"));
                ap.setProposedTime(rs.getTime("proposed_time"));
                ap.setProposedReason(rs.getString("proposed_reason"));
                list.add(ap);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // 7️⃣ PROCESS update approval/rejection (doctor)
    public boolean processUpdateApproval(int appointmentId, boolean approve) {
        String sqlApprove = "UPDATE appointments SET appointment_date = proposed_date, appointment_time = proposed_time, notes = COALESCE(proposed_reason, notes), proposed_date = NULL, proposed_time = NULL, proposed_reason = NULL, status = 'Approved' WHERE id = ?";
        String sqlReject  = "UPDATE appointments SET proposed_date = NULL, proposed_time = NULL, proposed_reason = NULL, status = 'Rejected' WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pst = conn.prepareStatement(approve ? sqlApprove : sqlReject)) {

            pst.setInt(1, appointmentId);
            int updated = pst.executeUpdate();
            return updated > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
