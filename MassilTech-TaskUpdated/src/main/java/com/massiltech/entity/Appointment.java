
package com.massiltech.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apmnt_id")
	private int apntmntId;

// @Column(name = "patient_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ptnt_id")
	private Patient patient;
	

// @Column(name = "dctr_id")
	@ManyToOne
	@JoinColumn(name = "dctr_id")
	private Doctor doctor;
	
	@Column(name = "apmnt_type")
	private String typeOfAppointment;
	
	@Column(name = "apmnt_cdate")
	private String apnmntDate;
	

	@Column(name = "apmnt_status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointmentId") private
	 * List<Consultation> consultation;
	 * 
	 * public List<Consultation> getConsultation() { return consultation; }
	 * 
	 * public void setConsultation(List<Consultation> consultation) {
	 * this.consultation = consultation; }
	 */

	public int getApntmntId() {
		return apntmntId;
	}

	public void setApntmntId(int apntmntId) {
		this.apntmntId = apntmntId;
	}

	public String getApnmntDate() {
		return apnmntDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setApnmntDate(String apnmntDate) {
		this.apnmntDate = apnmntDate;
	}

	public String getTypeOfAppointment() {
		return typeOfAppointment;
	}

	public void setTypeOfAppointment(String typeOfAppointment) {
		this.typeOfAppointment = typeOfAppointment;
	}

	public Appointment() {
	}

	public Appointment(Doctor doctor, String apnmntDate, String apnmntDesc, Patient patient) {
		super();
		// this.doctor = doctor;
		this.apnmntDate = apnmntDate;
		this.typeOfAppointment = apnmntDesc;
		// this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointments [apntmntId=" + apntmntId + ",  doctor=" + doctor + ", apnmntDate=" + apnmntDate
				+ ", apnmntDesc=" + typeOfAppointment + "]";
	}

}
