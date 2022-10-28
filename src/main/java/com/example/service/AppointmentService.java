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
	public AppointmentDTO updateAppointment(Long appointmentNo, Appointment appointment) {
		Optional<Appointment> tempAppointment = Optional.of(this.repo.findById(appointmentNo).orElseThrow(AppointmentNotFoundException::new));
		Appointment existing =tempAppointment.get();
		
		existing.setDoctorName(appointment.getDoctorName());
		existing.setDoctorDepartment(appointment.getDoctorDepartment());
		existing.setAppointmentDate(appointment.getAppointmentDate());
		existing.setAppointmentTime(appointment.getAppointmentTime());
		
		Appointment updated= this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteAppointment(Long appointmentNo) {
		this.repo.findById(appointmentNo).orElseThrow(AppointmentNotFoundException::new);
		this.repo.deleteById(appointmentNo);
		boolean exists = this.repo.existsById(appointmentNo);
		return !exists;
	}
	public AppointmentDTO readById(Long appointmentNo) {
		Appointment found = this.repo.findById(appointmentNo).orElseThrow(AppointmentNotFoundException::new);
		return this.mapToDTO(found);
	}
	public List<AppointmentDTO> readByName(String doctorName) {
		List<Appointment> found = this.repo.appointmentByName(doctorName).orElseThrow(AppointmentNotFoundException::new);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	

}
