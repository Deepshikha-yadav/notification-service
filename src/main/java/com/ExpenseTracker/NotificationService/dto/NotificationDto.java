package com.ExpenseTracker.NotificationService.dto;

import java.time.LocalDateTime;

public class NotificationDto {

    private Long id;
    private String userId;
    private String message;
    private LocalDateTime createdAt;
	
    public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
	
    public String getUserId() {
		return userId;
	}
	
    public void setUserId(String userId) {
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
	
	public NotificationDto(Long id, String userId, String message, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.message = message;
		this.createdAt = createdAt;
	}
	
	public NotificationDto() {
		super();
		// TODO Auto-generated constructor stub
	} 

}
