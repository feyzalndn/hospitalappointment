package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.AppointmentNotFoundException;
import com.example.persistence.domain.Appointment;
import com.example.persistence.repository.AppointmentRepository;
import com.example.rest.dto.AppointmentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class AppointmentService {
	@Autowired
	private AppointmentRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	private AppointmentDTO mapToDTO(Appointment appointment) {
		return this.mapper.map(appointment, AppointmentDTO.class);
	}
	
	public AppointmentDTO addAppointment(Appointment appointment) {
		Appointment saved = this.repo.save(appointment);
		return this.mapToDTO(saved);
	}
	public List<AppointmentDTO> getAllAppointments() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		
	}
	public AppointmentDTO updateAppointment(Long id, Appointment appointment) {
		Optional<Appointment> tempAppointment = Optional.of(this.repo.findById(id).orElseThrow(AppointmentNotFoundException::new));
		Appointment existing =tempAppointment.get();
		
		existing.setId(appointment.getId());
		existing.setName(appointment.getName());
		existing.setDepartment(appointment.getDepartment());
		existing.setAppointmentDate(appointment.getAppointmentDate());
		existing.setTime(appointment.getTime());
		
		Appointment updated= this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteAppointment(Long id) {
		this.repo.findById(id).orElseThrow(AppointmentNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	public AppointmentDTO readById(Long id) {
		Appointment found = this.repo.findById(id).orElseThrow(AppointmentNotFoundException::new);
		return this.mapToDTO(found);
	}
	public List<AppointmentDTO> readByName(String name) {
		List<Appointment> found = this.repo.appointmentByName(name).orElseThrow(AppointmentNotFoundException::new);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
}
