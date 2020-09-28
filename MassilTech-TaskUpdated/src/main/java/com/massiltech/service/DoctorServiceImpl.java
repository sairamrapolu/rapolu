package com.massiltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.massiltech.dto.LoginRequest;
import com.massiltech.entity.Appointment;
import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;
import com.massiltech.exception.ResourceNotFoundException;
import com.massiltech.repository.AppointmentRepository;
import com.massiltech.repository.DoctorRepository;

/**
 * @author sairam rapolu
 *
 */
@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	

	@Autowired
	private AppointmentRepository appRepo;

	@Override
	public List<Appointment> listAllAppointmentsByDoctorID(Integer doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).isPresent() ? doctorRepository.findById(doctorId).get()
				: null;
		if (doctor == null) {
			throw new ResourceNotFoundException("Doctor not found");
		}
		return appRepo.findByDoctor(doctor);
	}

	@Override
	public Doctor authenticateDoctor(LoginRequest request) {
		Doctor loggedInDoctor = doctorRepository.findByEmailAndPassword(request.getUsername(), request.getPassword());
		if (loggedInDoctor == null) {
			throw new ResourceNotFoundException("Doctor record not found in db");
		}
		return loggedInDoctor;
	}

	@Override
	public ResponseEntity<String> deleteDoctor(int doctorId) {

		appRepo.deleteById(doctorId);
		doctorRepository.deleteById(doctorId);

		//usersRepository.deleteById(doctorId);

		return ResponseEntity.ok("doctor object has been deleted successfully");
	}

	@Override
	public Doctor getDoctorInfoByDoctorId(int doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).isPresent() ? doctorRepository.findById(doctorId).get()
				: null;
		if (doctor == null) {
			throw new ResourceNotFoundException("Doctor Not Found in DB");
		}

		return doctor;
	}

	@Override
	public List<Doctor> listAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor updateDoctor(Integer patientId, Doctor request) {

		
		Doctor exDoctor = doctorRepository.findById(patientId).isPresent() ? doctorRepository.findById(patientId).get()
				: null;
		if (exDoctor == null) {
			throw new ResourceNotFoundException("Doctor Not Exist in DB For Update");

		}
		/*
		 * exUser.setUsername(request.getUsername());
		 * exUser.setPassword(request.getPassword());
		 * exUser.setUserType(request.getUserType()); int doctorId =
		 * usersRepository.save(exUser).getUserId();
		 */

		//exDoctor.setDid(doctorId);
		exDoctor.setDoctorDesig(request.getDoctorDesig());
		exDoctor.setDoctorExp(request.getDoctorExp());
		exDoctor.setDoctorName(request.getDoctorName());
		exDoctor.setDoctorHsptl(request.getDoctorHsptl());
		exDoctor.setEmail(request.getEmail());
		exDoctor.setPassword(request.getPassword());

		return doctorRepository.save(exDoctor);
	}

	@Override
	public List<Patient> listAllPatientsByDoctorID(Integer doctorId, String date) {

		return
		// appRepo.findByDoctorAndApnmntDate(exDoctor, date);
		doctorRepository.listAllPatientsByDcotroID(doctorId, date);
	}

	@Override
	public Doctor createDoctor(Doctor doctorRequest) {

		/*
		 * Users user = new Users(); user.setUsername(doctorRequest.getUsername());
		 * user.setPassword(doctorRequest.getPassword());
		 * user.setUserType(doctorRequest.getUserType()); Users createdUser =
		 * usersRepository.save(user); Doctor doctor = new Doctor();
		 * doctor.setDid(createdUser.getUserId());
		 * doctor.setDoctorName(doctorRequest.getUsername());
		 * doctor.setDoctorExp(doctorRequest.getDoctorExp());
		 * doctor.setDoctorDesig(doctorRequest.getDoctorDesig());
		 * doctor.setDoctorHsptl(doctorRequest.getDoctorHsptl());
		 */
		return doctorRepository.save(doctorRequest);
	}
}
