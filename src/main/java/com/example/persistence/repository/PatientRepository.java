package com.example.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query("select p from Patient p where p.name=?1")
	Optional<Patient> patientByName(String name);

}
