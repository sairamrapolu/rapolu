package com.massiltech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
//	@Query(value = "SELECT DISTINCT p FROM Appointments a,Patient p  WHERE p.patientId=a.patient AND a.doctor.did=?1")
	@Query(value = "SELECT DISTINCT p FROM Appointment a,Patient p  WHERE p.patientId=a.patient.patientId AND a.doctor.did=?1 AND a.apnmntDate>=?2 and a.status='open'")
	public List<Patient> listAllPatientsByDcotroID(Integer doctorId, String date);

	public Doctor findByEmailAndPassword(String email, String password);
}
