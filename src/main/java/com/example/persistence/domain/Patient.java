package com.example.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentNo;
	private Long nhsNo;
	private String patientName;
	private String patientDateOfBirth;
	private Integer patientAge;
	private Integer patientPhone;
	private String patientEmail;
	private String patientAddress;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	//@JsonManagedReference
	@JsonIgnore
	private List<Appointment> appointments = new ArrayList<>();

	public Patient(Long appointmentNo, Long nhsNo, String patientName, String patientDateOfBirth, Integer patientAge,
			Integer patientPhone, String patientEmail, String patientAddress, List<Appointment> appointments) {
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

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [appointmentNo=" + appointmentNo + ", nhsNo=" + nhsNo + ", patientName=" + patientName
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

	public Integer getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(Integer patientPhone) {
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