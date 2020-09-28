/*
 * package com.massiltech.entity;
 * 
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.OneToOne; import javax.persistence.Table;
 * 
 * 
 * @Entity
 * 
 * @Table(name = "logs") public class Log {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "log_id") private int logId;
 * 
 * @OneToOne
 * 
 * @JoinColumn(name = "patient_id") private Patient patientId;
 * 
 * public int getLogId() { return logId; }
 * 
 * public void setLogId(int logId) { this.logId = logId; }
 * 
 * public Patient getPatientId() { return patientId; }
 * 
 * public void setPatientId(Patient patientId) { this.patientId = patientId; }
 * 
 * 
 * }
 */