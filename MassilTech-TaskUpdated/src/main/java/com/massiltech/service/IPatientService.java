package com.massiltech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.massiltech.dto.AppointmentRequest;
import com.massiltech.dto.LoginRequest;
import com.massiltech.dto.PatientLogRequest;
import com.massiltech.dto.PatientLogResponse;
import com.massiltech.entity.Appointment;
import com.massiltech.entity.Conversation;
import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;
import com.massiltech.entity.PatientLog;
import com.massiltech.entity.Target;

public interface IPatientService {
	
	
	public Patient authenticatePatient(LoginRequest request);
	
	
	
	
	public Patient createPatient(Patient newPatient);

	public Patient getPatientInfoByPatientId(int patientId);

	public ResponseEntity<String> deletePatient(int patientId);

	public List<Patient> listAllPatients();

	public Patient updatePatient(Integer patientId, Patient request);

	public List<Doctor> listAllDoctorByPatientID(Integer patientId);

	// Appointments
	public Appointment endUpTheAppointment(Integer patientId,Integer doctorId);

	public Appointment recordNewAppointmentWithDoctor(AppointmentRequest appointmentRequest);
	public Appointment updateAppointmentWithDoctor(Integer pid,AppointmentRequest appointmentRequest);
	
	public List<Appointment> listAppoinmentsByPatientId(Integer patientId);

	public Appointment getAppoinmentByAppointmentId(Integer appointmentId);

	public List<Appointment> getAppoinmentByDoctorIdAndPatientId(Integer doctorId, Integer patientId, String status);

	
	// Consultations by appointment
	/*
	 * public Consultation getConsultationMsgsByPatientIdAndConsultId(String
	 * appointId, String consultId);
	 * 
	 * public List<Consultation> listConsultationMsgsByPatient(String appointId,
	 * String doctorId,String status);
	 * 
	 * 
	 * 
	 * public Consultation recordPatientConsultionMessage(Integer patientId, Integer
	 * doctorId, Consultation consultRequest);
	 */

	// logs by db

//	public LogResponse getLogsByPatientId(Integer patientId);
	public PatientLogResponse getPatientLogsByPatientId(String patientId);
	public List<PatientLog> createLogsByPatientId(int patientId, PatientLogRequest log);

	// goal by db

	public Target createGoalsbyPatientId(Integer patientId, Target goal);

	public Target getGoalsByPatientId(Integer patientId);
	
	public List<Conversation> getConsultations(String pid,String did,String date);

}
