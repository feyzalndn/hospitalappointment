package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Patient with that number does not exist.")
public class PatientNotFoundException extends EntityNotFoundException {
	
	public PatientNotFoundException() {}

	public PatientNotFoundException(String message) {
		super(message);
	}
}
