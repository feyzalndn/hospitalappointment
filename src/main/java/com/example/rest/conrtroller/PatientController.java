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
	
	@PutMapping("/updatePatient/{nhsNo}")
	public PatientDTO updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return service.updatePatient(id, patient);
	}

	@DeleteMapping("/DeletePatient/{nhsNo}")
	public boolean deletePatient(@PathVariable Long id) {
		return service.deletePatient(id);
	}
	
	@GetMapping("/patientById")
	public PatientDTO readPatientById(@PathParam("nhsNo") Long id) {
		return service.readById(id);
	}
	
	@GetMapping("/patientByName")
	public PatientDTO readByName(@PathParam("name") String name) {
		return service.readByName(name);
	}
	



}
