package com.iyzico.challenge.model.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {

	private String exceptionMessage;
	private String description;
	HttpStatus status;
	LocalDateTime timestamp;
	
	public ApiError(String exceptionMessage, String description, HttpStatus status, LocalDateTime timestamp) {
		this.exceptionMessage = exceptionMessage;
		this.description = description;
		this.status = status;
		this.timestamp = timestamp;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "[exceptionMessage=" + exceptionMessage + ", description=" + description + ", status=" + status
				+ ", timestamp=" + timestamp + "]";
	}
	
}
