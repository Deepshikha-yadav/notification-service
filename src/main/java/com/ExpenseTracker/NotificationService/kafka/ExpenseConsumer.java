package com.ExpenseTracker.NotificationService.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ExpenseTracker.NotificationService.service.NotificationService;

@Component
public class ExpenseConsumer {

	private final NotificationService notificationService;

    public ExpenseConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "expenses", groupId = "notification-group")
    public void consumeExpenseEvent(String message) {
        notificationService.processEvent(message);
    }
    
}
