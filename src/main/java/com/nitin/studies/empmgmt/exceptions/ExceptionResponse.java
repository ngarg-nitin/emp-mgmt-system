package com.nitin.studies.empmgmt.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public final class ExceptionResponse {

	private LocalDateTime timeStamp;
	private String message;
	private String details;
	private List<ExceptionResponse> subExceptions = new ArrayList<>();

	public ExceptionResponse(final String message) {
		timeStamp = LocalDateTime.now();
		this.message = message;
	}

	public ExceptionResponse(final String message, final String details) {
		timeStamp = LocalDateTime.now();
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	@JsonInclude(value = Include.NON_EMPTY)
	public List<ExceptionResponse> getSubExceptions() {
		return subExceptions;
	}

}
