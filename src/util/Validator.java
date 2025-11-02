/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Pattern;

/**
 *
 * @author tshiy
 */
public class Validator {
    //Check if a string is empty or null
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    //Validate email format
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    //Validate password strength (at least 6 characters)
    public static boolean isStrongPassword(String password) {
        return password != null && password.length() >= 6;
    }

    //Validate phone number (digits only, 8–15 digits)
    public static boolean isValidPhone(String phone) {
        String regex = "^[0-9]{8,15}$";
        return Pattern.matches(regex, phone);
    }

    //Validate numeric age (between 1 and 120)
    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }

    //Validate date string format (yyyy-mm-dd)
    public static boolean isValidDate(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(regex, date);
    }

    //Display validation error messages (for convenience)
    public static void showError(String field, String message) {
        System.out.println("❌ Invalid " + field + ": " + message);
    }

    //Display success messages
    public static void showSuccess(String message) {
        System.out.println("✅ " + message);
    }
    
    // ---------- Quick test main ----------
    public static void main(String[] args) {
    System.out.println(Validator.isValidEmail("test@example.com")); // true
    System.out.println(Validator.isValidEmail("wrong@com"));        // false
    System.out.println(Validator.isStrongPassword("12345"));        // false
    System.out.println(Validator.isStrongPassword("password123"));  // true
    }
}
