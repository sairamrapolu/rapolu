package com.massiltech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.massiltech.entity.Appointment;
import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;
import com.massiltech.service.IDoctorService;

/**
 * @author sairam
 *
 */
@RestController
public class DoctorResource {

	@Autowired
	private IDoctorService doctorService;

	/**
	 * @param request : takes input as json object contains doctor registration
	 *                fields
	 * @return newly created doctor object
	 */
	@PostMapping(value = "/doctor")
	public Doctor registerDoctor(@RequestBody Doctor request) {
		return doctorService.createDoctor(request);
	}

	@PutMapping(value = "/doctor/{id}")
	public Doctor updateDoctor(@PathVariable("id") Integer patientId, @RequestBody Doctor request) {
		return doctorService.updateDoctor(patientId, request);
	}

	@GetMapping(value = "/doctor/{id}")
	public Doctor getDoctor(@PathVariable("id") int doctorId) {
		return doctorService.getDoctorInfoByDoctorId(doctorId);
	}

	@GetMapping(value = "/doctors")
	public List<Doctor> listAllDoctors() {
		return doctorService.listAllDoctors();
	}

	@DeleteMapping(value = "/doctor/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") int doctorId) {
		return doctorService.deleteDoctor(doctorId);
	}

	// it gives patients as a list by taking a specific doctor id
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();

	@GetMapping("/doctor/{doctorId}/patients")
	public List<Patient> listPatientsByDoctorId(@RequestParam(name = "date", required = false) String byDate,
			@PathVariable("doctorId") Integer doctorId) {

		if (byDate == null) {
			byDate = dtf.format(now);
		}
		return doctorService.listAllPatientsByDoctorID(doctorId, byDate);
	}

	// Appointments

	@GetMapping("/doctor/{doctorId}/appointments")
	public List<Appointment> listAllAppointmentsByDoctorId(@PathVariable("doctorId") Integer id) {

		return doctorService.listAllAppointmentsByDoctorID(id);

	}

}
