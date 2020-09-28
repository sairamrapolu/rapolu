package com.massiltech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massiltech.entity.Appointment;

import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


	
	public List<Appointment> findByPatient(Patient patient);
	public List<Appointment> findByDoctor(Doctor doctor);
	public Appointment findByPatientAndDoctorAndStatus(Patient patientId,Doctor doctorId,String status);
	public List<Appointment> findByStatusAndDoctorAndPatient(String status,Doctor doctor,Patient patient);
	public List<Appointment> findByPatientAndDoctor(Patient patientId,Doctor doctorId);
	public Appointment findByDoctorAndPatient(Doctor doctorId,Patient patientId);
	public Patient findByDoctorAndApnmntDate(Doctor doctorId, String date);
	

}
