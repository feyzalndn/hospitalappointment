package com.example.rest.dto;

import com.example.persistence.domain.Patient;

public class AppointmentDTO {
	private Long nhsNo;
	private String appointmentNo;
	private String doctorName;
	private String doctorDepartment;
	private String appointmentDate;
	private String appointmentTime;
	private Patient patient;
	public Long getNhsNo() {
		return nhsNo;
	}
	public void setNhsNo(Long nhsNo) {
		this.nhsNo = nhsNo;
	}
	public String getAppointmentNo() {
		return appointmentNo;
	}
	public void setAppointmentNo(String appointmentNo) {
		this.appointmentNo = appointmentNo;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDepartment() {
		return doctorDepartment;
	}
	public void setDoctorDepartment(String doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public AppointmentDTO(Long nhsNo, String appointmentNo, String doctorName, String doctorDepartment,
			String appointmentDate, String appointmentTime, Patient patient) {
		super();
		this.nhsNo = nhsNo;
		this.appointmentNo = appointmentNo;
		this.doctorName = doctorName;
		this.doctorDepartment = doctorDepartment;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.patient = patient;
	}
	public AppointmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AppointmentDTO [nhsNo=" + nhsNo + ", appointmentNo=" + appointmentNo + ", doctorName=" + doctorName
				+ ", doctorDepartment=" + doctorDepartment + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", patient=" + patient + "]";
	}

}
