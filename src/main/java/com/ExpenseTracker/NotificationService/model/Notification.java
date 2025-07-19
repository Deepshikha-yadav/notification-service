package com.ExpenseTracker.NotificationService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private Long userId;
    private String message;
    private LocalDateTime createdAt;
	
    public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
	
    public Long getUserId() {
		return userId;
	}
	
    public void setUserId(Long userId) {
		this.userId = userId;
	}
	
    public String getMessage() {
		return message;
	}
	
    public void setMessage(String message) {
		this.message = message;
	}
	
    public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
    public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public Notification(Long userId, String message, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.message = message;
		this.createdAt = createdAt;
	}
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
