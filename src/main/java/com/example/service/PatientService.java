package com.example.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.PatientNotFoundException;
import com.example.persistence.domain.Patient;
import com.example.persistence.repository.PatientRepository;
import com.example.rest.dto.PatientDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
	@Autowired
	private PatientRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	private PatientDTO mapToDTO(Patient patient) {
		return this.mapper.map(patient, PatientDTO.class);
	}
	
	public PatientDTO addPatient(Patient patient) {
		Patient saved = this.repo.save(patient);
		return this.mapToDTO(saved);
	}
	public List<PatientDTO> getAllPatients() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
		public PatientDTO updatePatient(Long id, Patient patient) {
		Optional<Patient> tempPatient = Optional.of(this.repo.findById(id).orElseThrow(PatientNotFoundException::new));
		
		Patient existing =tempPatient.get();
		existing.setId(patient.getId());
		existing.setName(patient.getName());
		existing.setDateOfBirth(patient.getDateOfBirth());
		existing.setAge(patient.getAge());
		existing.setPhone(patient.getPhone());
		existing.setEmail(patient.getEmail());
		existing.setAddress(patient.getAddress());
		existing.setAppointments(patient.getAppointments());
		
		Patient updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
		public boolean deletePatient(Long id) {
			this.repo.findById(id).orElseThrow(PatientNotFoundException::new);
			this.repo.deleteById(id);
			boolean exists = this.repo.existsById(id);
			return !exists;
		}
		public PatientDTO readById(Long id) {
			Patient found = this.repo.findById(id).orElseThrow(PatientNotFoundException::new);
			return this.mapToDTO(found);
		}
		
		public PatientDTO readByName(String name) {
			Patient found = this.repo.patientByName(name).orElseThrow(PatientNotFoundException::new);
			return this.mapToDTO(found);
			
		}
	
}
