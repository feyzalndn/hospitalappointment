package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Appointment with that number does not exist.")
public class AppointmentNotFoundException extends EntityNotFoundException{
	public AppointmentNotFoundException() {}

	public AppointmentNotFoundException(String message) {
		super(message);
	}
}
