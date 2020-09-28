/*
 * package com.massiltech.repository;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * import com.massiltech.entity.Consultation;
 * 
 * public interface ConsultationRepository extends JpaRepository<Consultation,
 * Integer> {
 * 
 * @Query(value =
 * "SELECT c.* FROM mass.consult c ,mass.appointments a where c.apmnt_id=a.apmt_id AND a.patient_id=?1 and c.consult_id=?2"
 * , nativeQuery = true) public Consultation
 * findByConsultationsByPatientIdAndConsultId(String patientId, String
 * consultId);
 * 
 * @Query(value =
 * "SELECT c.* FROM mass.consult c ,mass.appointments a where c.apmnt_id=a.apmt_id AND a.patient_id=?1 and a.dctr_id =?2 and a.status=?3  order by consult_id asc "
 * , nativeQuery = true) public List<Consultation>
 * findByConsultationsByPatientId(String patientId, String doctorId, String
 * status);
 * 
 * @Query(value =
 * "SELECT c.* FROM mass.consult c ,mass.appointments a where c.apmnt_id=a.apmt_id AND a.patient_id=?1 and a.dctr_id =?2  order by consult_id asc "
 * , nativeQuery = true) public List<Consultation>
 * findByConsultationsByPatientId(String patientId, String doctorId);
 * 
 * @Query(value =
 * "SELECT c.* FROM mass.consult c ,mass.appointments a where c.apmnt_id=a.apmt_id AND a.dctr_id=?1 and c.consult_id=?2"
 * , nativeQuery = true) public Consultation
 * findByConsultationsByDoctorIdAndConsultId(String doctorId, String consultId);
 * 
 * @Query(value =
 * "SELECT c.* FROM mass.consult c ,mass.appointments a where c.apmnt_id=a.apmt_id AND a.dctr_id=?1 "
 * , nativeQuery = true) public List<Consultation>
 * findByConsultationsByDoctorId(String doctorId);
 * 
 * }
 */