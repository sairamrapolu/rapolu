package com.massiltech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query(value = "SELECT DISTINCT d FROM Appointment a,Doctor d  WHERE d.did=a.doctor AND a.patient=?1")
	public List<Doctor> listAllDoctorByPatientID(Integer patientId);

	public Patient findByEmailAndPassword(String email, String password);

	
}
