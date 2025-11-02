/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Note;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tshiy
 */
public class NoteDAO {
    //Add new note
    public boolean addNote(Note note) {
        String sql = "INSERT INTO notes (doctor_id, patient_id, appointment_id, title, content, created_at) VALUES (?, ?, ?, ?, ?, NOW())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, note.getDoctorId());
            stmt.setInt(2, note.getPatientId());
            stmt.setInt(3, note.getAppointmentId());
            stmt.setString(4, note.getTitle());
            stmt.setString(5, note.getContent());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Get all notes for a specific patient
    public List<Note> getNotesByPatient(int patientId) {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes WHERE patient_id = ? ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(extractNoteFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    //Get all notes for a specific appointment
    public List<Note> getNotesByAppointment(int appointmentId) {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes WHERE appointment_id = ? ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointmentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(extractNoteFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    //Get all notes written by a specific doctor
    public List<Note> getNotesByDoctor(int doctorId) {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes WHERE doctor_id = ? ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(extractNoteFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    //Update an existing note
    public boolean updateNote(Note note) {
        String sql = "UPDATE notes SET title = ?, content = ? WHERE note_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getContent());
            stmt.setInt(3, note.getNoteId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Delete a note
    public boolean deleteNote(int noteId) {
        String sql = "DELETE FROM notes WHERE note_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, noteId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Helper: Convert SQL result to Note object
    private Note extractNoteFromResultSet(ResultSet rs) throws SQLException {
        Note note = new Note();
        note.setNoteId(rs.getInt("note_id"));
        note.setDoctorId(rs.getInt("doctor_id"));
        note.setPatientId(rs.getInt("patient_id"));
        note.setAppointmentId(rs.getInt("appointment_id"));
        note.setTitle(rs.getString("title"));
        note.setContent(rs.getString("content"));
        note.setCreatedAt(rs.getTimestamp("created_at"));
        return note;
    }
}
