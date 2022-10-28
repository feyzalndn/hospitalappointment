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

import com.example.persistence.domain.Patient;
import com.example.rest.dto.PatientDTO;
import com.example.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PatientController {
	@Autowired
	private PatientService service;
	
	@PostMapping("/addPatient")
	public PatientDTO addPatient(@RequestBody Patient patient) {
		return service.addPatient(patient);
	}
	
	@GetMapping("/allPatients")
	public List<PatientDTO> getPatients(){
		return service.getAllPatients();	
	}
	
	@PutMapping("/updatePatient/{appointmentNo}")
	public PatientDTO updatePatient(@PathVariable Long appointmentNo, @RequestBody Patient patient) {
		return service.updatePatient(appointmentNo, patient);
	}

	@DeleteMapping("/DeletePatient/{appointmentNo}")
	public boolean deletePatient(@PathVariable Long appointmentNo) {
		return service.deletePatient(appointmentNo);
	}
	
	@GetMapping("/patientById")
	public PatientDTO readPatientById(@PathParam("appointmentNo") Long appointmentNo) {
		return service.readById(appointmentNo);
	}
	
	@GetMapping("/patientByName")
	public PatientDTO readByName(@PathParam("patientName") String patientName) {
		return service.readByName(patientName);
	}
	



}
