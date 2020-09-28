
package com.massiltech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.massiltech.dto.AppointmentRequest;
import com.massiltech.dto.PatientLogRequest;
import com.massiltech.dto.PatientLogResponse;
import com.massiltech.entity.Appointment;
import com.massiltech.entity.Conversation;
import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;
import com.massiltech.entity.PatientLog;
import com.massiltech.entity.Target;
import com.massiltech.service.IPatientService;

/**
 * @author sairam rapolu
 *
 */
@RestController
public class PatientResource {

	
	@Autowired
	private IPatientService patientService;

	@PostMapping(value = "/patient")
	public Patient registerPatient(@RequestBody Patient request) {
		return patientService.createPatient(request);
	}

	@PutMapping(value = "/patient/{id}")
	public Patient updatePatient(@PathVariable("id") Integer patientId, @RequestBody Patient request) {
		return patientService.updatePatient(patientId, request);
	}

	@GetMapping(value = "/patient/{id}")
	public Patient updatePatient(@PathVariable("id") int patientId) {
		return patientService.getPatientInfoByPatientId(patientId);
	}
//custom filtering
	// https://stackoverflow.com/questions/23101260/ignore-fields-from-java-object-dynamically-while-sending-as-json-from-spring-mvc

	@GetMapping(value = "/patients")
	public List<Patient> updatePatient() {
		return patientService.listAllPatients();
	}

	@DeleteMapping(value = "/patient/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") int patientId) {
		return patientService.deletePatient(patientId);
	}

//patient reached doctors
	@GetMapping("/patient/{patientId}/doctors")
	public List<Doctor> listDoctorsByPatientId(@PathVariable("patientId") Integer patientId) {
		return patientService.listAllDoctorByPatientID(patientId);
	}

//*****************************************************************************
	// Appointments
//**************************************************************

	// new patient appointment request
	@PostMapping("/patient/appointment")
	public Appointment createAppointmentWithDoctor(@RequestBody AppointmentRequest appointmentRequest) {
		return patientService.recordNewAppointmentWithDoctor(appointmentRequest);
	}
	@PutMapping("/patient/{pid}/appointment")
	public Appointment updateAppointmentWithDoctor(@PathVariable("pid") Integer pid,@RequestBody AppointmentRequest appointmentRequest) {
		return patientService.updateAppointmentWithDoctor(pid,appointmentRequest);
	}
	

	@GetMapping("/patient/{patientId}/appointments")
	public List<Appointment> listAllAppointmentsByPatientId(@PathVariable("patientId") Integer id) {

		return patientService.listAppoinmentsByPatientId(id);

	}

	@GetMapping("/patient/{patientId}/appointment/doctor/{doctorId}")
	public List<Appointment> getAppointmentsByDoctorId(@PathVariable("doctorId") Integer doctorId,
			@PathVariable("patientId") Integer patientId,
			@RequestParam(name = "status", required = false) String status) {

		return patientService.getAppoinmentByDoctorIdAndPatientId(doctorId, patientId, status);
	}

	@GetMapping("/patient/appointment/{apmntId}")
	public Appointment getAppointmentsByAppointmentId(@PathVariable("apmntId") Integer apmntId) {

		return patientService.getAppoinmentByAppointmentId(apmntId);
	}

	// *****************************************************************
	// consultation messages
	// ***************************************************************

	@PutMapping("/patient/{pid}/appointment/{did}")
	public Appointment closeTheAppointment(@PathVariable("pid") Integer pid, @PathVariable("did") Integer did) {
		return patientService.endUpTheAppointment(pid, did);
	}
	// inserting consult record

	/*
	 * @PostMapping("/patient/{patientId}/consultation/{doctorId}/conversations")
	 * public Consultation createConsultationMessage(@PathVariable("patientId")
	 * Integer patientId,
	 * 
	 * @PathVariable("doctorId") Integer doctorId, @RequestBody Consultation
	 * consultRequest) { return
	 * patientService.recordPatientConsultionMessage(patientId, doctorId,
	 * consultRequest); }
	 */

	/*
	 * @GetMapping("/patient/{patientId}/consultation/{consultId}") public
	 * Consultation
	 * getConsultationMsgsByAppointIdAndConsultId(@PathVariable("patientId") String
	 * patientId,
	 * 
	 * @PathVariable("consultId") String consultId) {
	 * 
	 * return patientService.getConsultationMsgsByPatientIdAndConsultId(patientId,
	 * consultId);
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/patient/{patientId}/consultation/{doctorId}/conversations")
	 * public List<Consultation>
	 * listAllConsultationMsgsByAppointId(@PathVariable("patientId") String
	 * patientId,
	 * 
	 * @PathVariable("doctorId") String doctorId, @RequestParam(name = "status",
	 * required = false) String status) {
	 * 
	 * return patientService.listConsultationMsgsByPatient(patientId, doctorId,
	 * status);
	 * 
	 * }
	 */

//logs by db
	/*
	 * @GetMapping("/patient/{id}/logs") public LogResponse
	 * gettingLogs(@PathVariable("id") Integer patientId) { return
	 * patientService.getLogsByPatientId(patientId); }
	 */

	@PostMapping("/patient/{id}/logs")
	public List<PatientLog> createLog(@PathVariable("id") Integer patientId, @RequestBody PatientLogRequest log) {
		return patientService.createLogsByPatientId(patientId, log);
	}

	// goals by db
	@GetMapping("/patient/{id}/goals")
	public Target getGoalsById(@PathVariable("id") Integer patientId) {
		return patientService.getGoalsByPatientId(patientId);
	}

	@PostMapping("/patient/{id}/goals")
	public Target createGoalsById(@PathVariable("id") Integer patientId, @RequestBody Target goal) {
		return patientService.createGoalsbyPatientId(patientId, goal);
	}

	// getConsult
	@GetMapping("/patient/{pid}/sample/{did}")

	public List<Conversation> getConsult(@PathVariable("pid") String pid, @PathVariable("did") String did,
			String date) {
		return patientService.getConsultations(pid, did, date);
	}
	
	//=============================================
	@GetMapping(value = "/patient/{pid}/logs")
	public PatientLogResponse getLogsbyType(@PathVariable("pid") String id) {

		return patientService.getPatientLogsByPatientId(id);
	}

}
