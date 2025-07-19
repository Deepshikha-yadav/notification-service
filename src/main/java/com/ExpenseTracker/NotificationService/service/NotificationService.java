package com.ExpenseTracker.NotificationService.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ExpenseTracker.NotificationService.dto.ExpenseEvent;
import com.ExpenseTracker.NotificationService.model.Notification;
import com.ExpenseTracker.NotificationService.repository.NotificationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final ObjectMapper objectMapper;

    public NotificationService(NotificationRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public void processEvent(String message) {
        try {
            ExpenseEvent event = objectMapper.readValue(message, ExpenseEvent.class);
            String notificationText = generateNotification(event);
            Notification notification = new Notification(event.getUserId(), notificationText, LocalDateTime.now());
            repository.save(notification);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private String generateNotification(ExpenseEvent event) {
        switch (event.getEventType()) {
            case "CREATED":
                return "A new expense was added: " + event.getDescription() + " Amount : " + event.getAmount();
            case "UPDATED":
                return "Your expense was updated: " + event.getDescription()+ " Amount : " + event.getAmount();
            case "DELETED":
                return "An expense was deleted: " + event.getDescription()+ " Amount : " + event.getAmount();
            default:
                return "Unknown event occurred.";
        }
    }
}
