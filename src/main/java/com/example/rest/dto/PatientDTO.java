package com.example.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.persistence.domain.Appointment;
import com.example.persistence.domain.Patient;


public class PatientDTO {
	private Long id;
	private String name;
	private String dateOfBirth;
	private int age;
	private Long phone;
	private String email;
	private String address;
	private List<Appointment> appointments = new ArrayList<>();
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public PatientDTO(Long id, String name, String dateOfBirth, int age, Long phone, String email, String address,
			List<Appointment> appointments) {
		super();
		id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.appointments = appointments;
	}
	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PatientDTO [NHSNo=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", age=" + age
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", appointments=" + appointments
				+ "]";
	}
	
	
}
