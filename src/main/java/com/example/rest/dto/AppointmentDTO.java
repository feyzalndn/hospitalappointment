package com.example.rest.dto;

import com.example.persistence.domain.Patient;

public class AppointmentDTO {
	private Long id;
	private String name;
	private String department;
	private int appointmentDate;
	private int time;
	private Patient patient;
	public Long getNHSNo() {
		return id;
	}
	public void setNHSNo(Long nHSNo) {
		id = nHSNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(int appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public AppointmentDTO(Long nHSNo, Long appointmentNo, String name, String department, int appointmentDate, int time,
			Patient patient) {
		super();
		id = id;
		this.name = name;
		this.department = department;
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.patient = patient;
	}
	public AppointmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AppointmentDTO [NHSNo=" + id + ", appointmentNo=" + ", name=" + name
				+ ", department=" + department + ", appointmentDate=" + appointmentDate + ", time=" + time
				+ ", patient=" + patient + "]";
	}
	

}
