package com.massiltech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.massiltech.dto.LoginRequest;
import com.massiltech.entity.Appointment;
import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;

/**
 * @author sairam rapolu
 *
 */
public interface IDoctorService {
	public Doctor authenticateDoctor(LoginRequest request);
	public Doctor createDoctor(Doctor doctorRequest);

	public Doctor getDoctorInfoByDoctorId(int doctorId);

	public ResponseEntity<String> deleteDoctor(int doctorId);

	public List<Doctor> listAllDoctors();

	public Doctor updateDoctor(Integer doctorId, Doctor request);

	public List<Patient> listAllPatientsByDoctorID(Integer doctorId,String date);
	public List<Appointment> listAllAppointmentsByDoctorID(Integer doctorId);
}
