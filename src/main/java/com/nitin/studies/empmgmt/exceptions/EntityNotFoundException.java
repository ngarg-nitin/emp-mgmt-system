package com.nitin.studies.empmgmt.exceptions;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6942906949150443147L;

	public EntityNotFoundException(final String message) {
		super(message);
	}
}
