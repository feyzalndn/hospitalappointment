package com.example.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long appointmentNo;
	@NotNull
	@Size(min = 0, max = 55)
	private String doctorName;
	@NotNull
	private String doctorDepartment;
	private String appointmentDate;
	private String appointmentTime;
	
	@ManyToOne
	private Patient patient;

	public Appointment(Long appointmentNo, @NotNull @Size(min = 0, max = 55) String doctorName,
			@NotNull String doctorDepartment, String appointmentDate, String appointmentTime, Patient patient) {
		super();
		this.appointmentNo = appointmentNo;
		this.doctorName = doctorName;
		this.doctorDepartment = doctorDepartment;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.patient = patient;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [appointmentNo=" + appointmentNo + ", doctorName=" + doctorName + ", doctorDepartment="
				+ doctorDepartment + ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime
				+ ", patient=" + patient + "]";
	}

	public Long getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(Long appointmentNo) {
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

}
