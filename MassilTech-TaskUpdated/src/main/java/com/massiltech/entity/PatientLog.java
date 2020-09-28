package com.massiltech.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class PatientLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private int logId;

	@Column(name = "ptnt_id")
	private String patientId;

	@Column(name = "log_level")
	private String level;

	@Column(name = "log_cdate")
	private Date logCreatedAt;

	@Column(name = "log_type")
	private String logType;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public Date getLogCreatedAt() {
		return logCreatedAt;
	}

	public void setLogCreatedAt(Date logCreatedAt) {
		this.logCreatedAt = logCreatedAt;
	}

	@Override
	public String toString() {
		return "PatientLog [logId=" + logId + ", patientId=" + patientId + ", level=" + level + ", logCreatedAt="
				+ logCreatedAt + ", logType=" + logType + "]";
	}

}
