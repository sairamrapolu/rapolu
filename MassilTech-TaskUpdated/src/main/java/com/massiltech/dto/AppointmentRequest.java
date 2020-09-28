package com.massiltech.dto;

public class AppointmentRequest {
	
	private int patientId;
	private int doctorId;
	private String dateOfAppointment;
	private String typeOfAppointment;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getTypeOfAppointment() {
		return typeOfAppointment;
	}
	public void setTypeOfAppointment(String typeOfAppointment) {
		this.typeOfAppointment = typeOfAppointment;
	}
	@Override
	public String toString() {
		return "AppointmentRequest [patientId=" + patientId + ", doctorId=" + doctorId + ", dateOfAppointment="
				+ dateOfAppointment + ", typeOfAppointment=" + typeOfAppointment + "]";
	}
	
	

}
