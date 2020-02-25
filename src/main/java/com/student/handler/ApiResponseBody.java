package com.student.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiResponseBody
{
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private final LocalDateTime timestamp;
	private boolean success;
	private String message;
	private Object data;
	private String debugMessage;

	public ApiResponseBody() {
		timestamp = LocalDateTime.now();
	}

	public ApiResponseBody(final HttpStatus status, boolean success) { 
		this();
		this.status = status;
		this.success=success;
	}

	ApiResponseBody(final HttpStatus status, final Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	ApiResponseBody(final HttpStatus status, final String message, final Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

}
