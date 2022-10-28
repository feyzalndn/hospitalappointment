package com.example.rest.conrtroller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Appointment;
import com.example.rest.dto.AppointmentDTO;
import com.example.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;
	
	@PostMapping("/addAppointment")
	public AppointmentDTO addAppointment(@RequestBody Appointment appointment) {
		return service.addAppointment(appointment);
	}
	
	@GetMapping("/allAppointments")
	public List<AppointmentDTO> getAllAppointments() {
		return service.getAllAppointments();
	}

	@PutMapping("/updateAppointment/{appointmentNo}")
	public AppointmentDTO updateAppointment(@PathVariable Long appointmentNo, @RequestBody Appointment appointment) {
		return service.updateAppointment(appointmentNo, appointment);
	}
	
	@DeleteMapping("/deleteAppointment/{appointmentNo}")
	public boolean deleteAppointment(@PathVariable Long appointmentNo) {
		return service.deleteAppointment(appointmentNo);
	}
	
	@GetMapping("/appointmentById")
	public AppointmentDTO readAppointmentById(@PathParam("appointmentNo") Long appointmentNo) {
		return service.readById(appointmentNo);
	}
	
	@GetMapping("/appointmentByName")
	public List<AppointmentDTO> readAppointmentByName(@PathParam("doctorName") String doctorName) {
		return service.readByName(doctorName);
	}

	

}
