package com.example.rest.conrtoller;

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

	@PutMapping("/updateAppointment/{id}")
	public AppointmentDTO updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		return service.updateAppointment(id, appointment);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	public boolean deleteAppointment(@PathVariable Long id) {
		return service.deleteAppointment(id);
	}
	
	@GetMapping("/appointmentById")
	public AppointmentDTO readAppointmentById(@PathParam("id") Long id) {
		return service.readById(id);
	}
	
	@GetMapping("/appointmentByName")
	public List<AppointmentDTO> readAppointmentByName(@PathParam("name") String name) {
		return service.readByName(name);
	}
}

