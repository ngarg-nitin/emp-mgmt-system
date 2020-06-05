package com.nitin.studies.empmgmt.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		ResponseEntity<ExceptionResponse> responseEntity = ((BodyBuilder) ResponseEntity.notFound()).body(response);
		return responseEntity;
	}
}
