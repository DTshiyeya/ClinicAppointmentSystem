/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author tshiy
 */
public class DateHelper {
    //Convert String to SQL Date
    public static Date stringToSqlDate(String dateStr) {
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Convert String to SQL Time
    public static Time stringToSqlTime(String timeStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            long ms = sdf.parse(timeStr).getTime();
            return new Time(ms);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Convert SQL Date to String
    public static String sqlDateToString(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    //Compare two dates (returns true if date1 is after date2)
    public static boolean isAfter(Date date1, Date date2) {
        if (date1 == null || date2 == null) return false;
        return date1.after(date2);
    }

    //Check if a date is in the past
    public static boolean isPast(Date date) {
        if (date == null) return false;
        Date today = new Date(System.currentTimeMillis());
        return date.before(today);
    }

    //Check if a date is today
    public static boolean isToday(Date date) {
        if (date == null) return false;
        LocalDate localDate = date.toLocalDate();
        return localDate.equals(LocalDate.now());
    }

    //Check if a date is in the future
    public static boolean isFuture(Date date) {
        if (date == null) return false;
        Date today = new Date(System.currentTimeMillis());
        return date.after(today);
    }

    //Format Time as String
    public static String formatTime(Time time) {
        if (time == null) return "";
        return new SimpleDateFormat("HH:mm").format(time);
    }

    //Get current date
    public static Date getCurrentDate() {
        return Date.valueOf(LocalDate.now());
    }

    //Get current time
    public static Time getCurrentTime() {
        return Time.valueOf(LocalTime.now());
    }
}
