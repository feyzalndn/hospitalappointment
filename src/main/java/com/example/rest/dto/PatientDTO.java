package com.example.rest.dto;

import java.util.ArrayList;


import java.util.List;

import com.example.persistence.domain.Appointment;
//import com.example.persistence.domain.Patient;
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class PatientDTO {
	private Long appointmentNo;
	private Long nhsNo;
	private String patientName;
	private String patientDateOfBirth;
	private Integer patientAge;
	private Long patientPhone;
	private String patientEmail;
	private String patientAddress;
	private List<Appointment> appointments = new ArrayList<>();
	public PatientDTO(Long appointmentNo, Long nhsNo, String patientName, String patientDateOfBirth, Integer patientAge,
			Long patientPhone, String patientEmail, String patientAddress, List<Appointment> appointments) {
		super();
		this.appointmentNo = appointmentNo;
		this.nhsNo = nhsNo;
		this.patientName = patientName;
		this.patientDateOfBirth = patientDateOfBirth;
		this.patientAge = patientAge;
		this.patientPhone = patientPhone;
		this.patientEmail = patientEmail;
		this.patientAddress = patientAddress;
		this.appointments = appointments;
	}
	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PatientDTO [appointmentNo=" + appointmentNo + ", nhsNo=" + nhsNo + ", patientName=" + patientName
				+ ", patientDateOfBirth=" + patientDateOfBirth + ", patientAge=" + patientAge + ", patientPhone="
				+ patientPhone + ", patientEmail=" + patientEmail + ", patientAddress=" + patientAddress
				+ ", appointments=" + appointments + "]";
	}
	public Long getAppointmentNo() {
		return appointmentNo;
	}
	public void setAppointmentNo(Long appointmentNo) {
		this.appointmentNo = appointmentNo;
	}
	public Long getNhsNo() {
		return nhsNo;
	}
	public void setNhsNo(Long nhsNo) {
		this.nhsNo = nhsNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientDateOfBirth() {
		return patientDateOfBirth;
	}
	public void setPatientDateOfBirth(String patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}
	public Integer getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}
	public Long getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(Long patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
}