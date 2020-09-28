package com.massiltech.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.massiltech.entity.PatientLog;

@Component
public class PatientLogRequest {

	private Integer patientId;
	private List<PatientLog> log;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public List<PatientLog> getLog() {
		return log;
	}
	public void setLog(List<PatientLog> log) {
		this.log = log;
	}
	
	
}
