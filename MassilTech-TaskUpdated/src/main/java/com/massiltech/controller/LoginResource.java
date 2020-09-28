package com.massiltech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.massiltech.dto.LoginRequest;
import com.massiltech.exception.ResourceNotFoundException;
import com.massiltech.service.IDoctorService;
import com.massiltech.service.IPatientService;

/**
 * @author sairam rapolu
 *
 */
@RestController
@RequestMapping("/usr")
public class LoginResource {

	@Autowired
	private IPatientService patientService;
	@Autowired
	private IDoctorService doctorService;

	@PostMapping(value = "/login")
	public Object validateLogin(@RequestBody LoginRequest request) {

		if (request.getUserType().equals("patient")) {
			return patientService.authenticatePatient(request);
		}
		if (request.getUserType().equals("doctor")) {
			return doctorService.authenticateDoctor(request);
		}

		return new ResourceNotFoundException("The profile you are looking for not available in my data");
	}

	
}
