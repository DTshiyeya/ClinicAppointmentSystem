/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author tshiy
 */
public class Validator {
    //Show success message
    public static void showSuccess(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    //Show error message
    public static void showError(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    //Check if field is empty
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    //Validate email format
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    //Validate phone number (basic)
    public static boolean isValidPhone(String phone) {
        String regex = "^[0-9]{10,15}$";
        return Pattern.matches(regex, phone);
    }

    //Validate numeric input
    public static boolean isNumeric(String value) {
        if (value == null) return false;
        return value.matches("\\d+");
    }

    //Combined validation helper
    public static boolean validateRequiredFields(String... fields) {
        for (String field : fields) {
            if (isEmpty(field)) {
                showError("Missing Input", "Please fill in all required fields.");
                return false;
            }
        }
        return true;
    }
}
