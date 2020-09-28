package com.massiltech.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.massiltech.entity.PatientLog;

public interface PatientLogRepository extends JpaRepository<PatientLog, Integer> {
	
	@Query("SELECT p from PatientLog p where p.patientId=?1 AND p.logType=?2 order by logCreatedAt DESC")
	public List<PatientLog> findByPatientIdAndLogType(String patientId,String type);
	
	public List<PatientLog> findByPatientIdAndLogCreatedAt(String patientId,Date date);
	public PatientLog findByPatientIdAndLogCreatedAtAndLogType(String patientId,Date date,String logType);

}
