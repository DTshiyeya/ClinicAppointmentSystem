/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.NotificationDAO;
import model.Notification;

import java.util.List;

/**
 *
 * @author tshiy
 */
public class NotificationService {
    private final NotificationDAO notificationDAO;

    public NotificationService() {
        this.notificationDAO = new NotificationDAO();
    }

    //Send new notification
    public boolean sendNotification(int userId, String userType, String title, String message) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setUserType(userType);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setRead(false);

        return notificationDAO.addNotification(notification);
    }

    //Fetch all notifications for a user
    public List<Notification> getUserNotifications(int userId, String userType) {
        return notificationDAO.getNotificationsByUser(userId, userType);
    }

    //Fetch unread notifications
    public List<Notification> getUnreadNotifications(int userId, String userType) {
        List<Notification> notifications = notificationDAO.getNotificationsByUser(userId, userType);
        return notifications.stream()
                .filter(n -> !n.isRead())
                .toList();
    }

    //Mark a notification as read
    public boolean markAsRead(int notificationId) {
        return notificationDAO.markAsRead(notificationId);
    }

    //Delete a notification
    public boolean deleteNotification(int notificationId) {
        return notificationDAO.deleteNotification(notificationId);
    }

    //Mark all notifications as read
    public void markAllAsRead(int userId, String userType) {
        List<Notification> list = notificationDAO.getNotificationsByUser(userId, userType);
        for (Notification n : list) {
            if (!n.isRead()) {
                notificationDAO.markAsRead(n.getNotificationId());
            }
        }
    }

    //Automatically send reminder notifications (for future upgrade)
    public void sendReminder(int userId, String userType, String appointmentDate) {
        String title = "Appointment Reminder";
        String message = "You have an appointment scheduled on " + appointmentDate + ".";
        sendNotification(userId, userType, title, message);
    }
}
