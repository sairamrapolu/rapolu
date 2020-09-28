package com.massiltech.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.massiltech.dto.AppointmentRequest;
import com.massiltech.dto.LoginRequest;
import com.massiltech.dto.PatientLogRequest;
import com.massiltech.dto.PatientLogResponse;
import com.massiltech.entity.Appointment;
import com.massiltech.entity.Conversation;
import com.massiltech.entity.Doctor;
import com.massiltech.entity.Patient;
import com.massiltech.entity.PatientLog;
import com.massiltech.entity.Target;
import com.massiltech.exception.ResourceNotFoundException;
import com.massiltech.repository.AppointmentRepository;
import com.massiltech.repository.ConversationRepository;
import com.massiltech.repository.DoctorRepository;
import com.massiltech.repository.PatientLogRepository;
import com.massiltech.repository.PatientRepository;
import com.massiltech.repository.TargetRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientLogRepository logRepo;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ConversationRepository conRepository;
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientLogRepository logRepository;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();

	@Autowired
	private TargetRepository goalRepository;

	@Override
	public Patient authenticatePatient(LoginRequest request) {
		Patient loggedInPatient = patientRepository.findByEmailAndPassword(request.getUsername(),
				request.getPassword());
		if (loggedInPatient == null) {
			throw new ResourceNotFoundException("patient record not found in db");
		}
		return loggedInPatient;
	}

	@Override
	public Appointment endUpTheAppointment(Integer patientId, Integer doctorId) {
		Patient patient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		Doctor doctor = doctorRepository.findById(doctorId).isPresent() ? doctorRepository.findById(doctorId).get()
				: null;
		Appointment existApp = appointmentRepository.findByPatientAndDoctorAndStatus(patient, doctor, "open");
		if (existApp == null) {

			throw new ResourceNotFoundException("Appoinment record is not available for closing it");
		}

		existApp.setStatus("closed");
		return appointmentRepository.save(existApp);
	}

	/*
	 * @Override public Consultation recordPatientConsultionMessage(Integer
	 * patientId, Integer doctorId, Consultation consultRequest) { Doctor doctor =
	 * doctorRepository.findById(doctorId).isPresent() ?
	 * doctorRepository.findById(doctorId).get() : null; Patient patient =
	 * patientRepository.findById(patientId).isPresent() ?
	 * patientRepository.findById(patientId).get() : null; if (doctor == null ||
	 * null == patient) { throw new
	 * ResourceNotFoundException("Doctor not available"); } Appointment apmnt =
	 * appointmentRepository.findByPatientAndDoctorAndStatus(patient, doctor,
	 * "open"); if (apmnt == null) { throw new ResourceNotFoundException(
	 * "Appointment with doctor already closed kindly take new appointment with doctor to make conversation"
	 * ); }
	 * 
	 * Consultation consult = new Consultation();
	 * consult.setAppointmentId(apmnt.getApntmntId());
	 * consult.setTextFrom(consultRequest.getTextFrom());
	 * consult.setTextTo(consultRequest.getTextTo());
	 * consult.setText(consultRequest.getText());
	 * consult.setTextDate(dtf.format(now));
	 * 
	 * return consultRepository.save(consult); }
	 */

	@Override
	public Appointment recordNewAppointmentWithDoctor(AppointmentRequest appointmentRequest) {

		Patient patient = patientRepository.findById(appointmentRequest.getPatientId()).isPresent()
				? patientRepository.findById(appointmentRequest.getPatientId()).get()
				: null;
		Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId()).isPresent()
				? doctorRepository.findById(appointmentRequest.getDoctorId()).get()
				: null;
		Appointment existApp = appointmentRepository.findByPatientAndDoctorAndStatus(patient, doctor, "open");
		if (existApp != null) {
			throw new ResourceNotFoundException(
					"already appointment  with same doctor is in progress unable to create new request ");
		}
		Appointment newApp = new Appointment();
		newApp.setPatient(patient);
		newApp.setDoctor(doctor);
		newApp.setStatus("open");
		newApp.setApnmntDate(appointmentRequest.getDateOfAppointment());
		newApp.setTypeOfAppointment(appointmentRequest.getTypeOfAppointment());

		return appointmentRepository.save(newApp);
	}

	@Override
	public Target createGoalsbyPatientId(Integer patientId, Target goal) {
		Patient existingPatient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		if (existingPatient == null) {
			throw new ResourceNotFoundException("Patient Record Not Found in DB ");
		}
		// Log logList = logRepository.findByPatientId(existingPatient);
		// if (logList == null) {
		// throw new ResourceNotFoundException("Log Id Not Found");
		// }
		Target exist = goalRepository.findByPatientId(existingPatient.getPatientId());
		if (exist == null) {
			// throw new PatientNotFoundException("Goal Object Not Found");
			goal.setPatientId(existingPatient.getPatientId());
			exist = goalRepository.save(goal);
		}

		return exist;
	}

	@Override
	public Target getGoalsByPatientId(Integer patientId) {
		Patient existingPatient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		if (existingPatient == null) {
			throw new ResourceNotFoundException("Patient Record Not Found in DB ");
		}
		Target goal = goalRepository.findByPatientId(existingPatient.getPatientId());
		if (goal == null) {
			throw new ResourceNotFoundException("Goal Object Not Found");
		}
		return goal;
	}

	@Override

	public List<PatientLog> createLogsByPatientId(int patientId, PatientLogRequest logRequest) {
		Patient existingPatient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		java.sql.Date myDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println("#######################-------------------############" + myDate);
		if (existingPatient == null) {
			throw new ResourceNotFoundException("Patient Record Not Found in DB ");
		}

		List<PatientLog> listLog = logRequest.getLog();

		//Date date = null;
		for (PatientLog log : listLog) {
			PatientLog existLog = logRepository.findByPatientIdAndLogCreatedAtAndLogType(String.valueOf(patientId),
					myDate, log.getLogType());
			log.setPatientId(String.valueOf(patientId));
			log.setLogCreatedAt(myDate);
			//date = log.getLogCreatedAt();
			if (existLog != null) {
				new ResourceNotFoundException("Log already exist :" + existLog);
			} else {

				logRepo.save(log);
			}
		}

		return logRepo.findByPatientIdAndLogCreatedAt(String.valueOf(patientId), myDate);
	}

	@Override
	public ResponseEntity<String> deletePatient(int patientId) {
		appointmentRepository.deleteById(patientId);
		patientRepository.deleteById(patientId);
		// usersRepository.deleteById(patientId);

		return ResponseEntity.ok("patient deleted successfully...");
	}

	@Override
	public Patient getPatientInfoByPatientId(int patientId) {
		Patient patient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;

		if (patient == null) {
			throw new ResourceNotFoundException("Patient Record Not Found In Patient Table in DB");
		}
		return patient;
	}

	@Override
	public List<Patient> listAllPatients() {

		return patientRepository.findAll();
	}

	@SuppressWarnings("unused")
	@Override
	public Patient updatePatient(Integer patientId, Patient newPatientRequest) {

		// Users existingUser = usersRepository.findById(patientId).isPresent() ?
		// usersRepository.findById(patientId).get()
		// : null;
		Patient existingPatient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		if (existingPatient == null) {
			throw new ResourceNotFoundException("Patient Record Not Found kin DB For Update");
		}

		// existingUser.setUsername(newPatientRequest.getUsername());
		// existingUser.setPassword(newPatientRequest.getPassword());
		// existingUser.setUserType(newPatientRequest.getUserType());
		// usersRepository.save(existingUser).getUserId();
		// existingPatient.setPatientId(existingUser.getUserId());
		existingPatient.setAge(newPatientRequest.getAge());
		existingPatient.setAreaOfPains(newPatientRequest.getAreaOfPains());
		existingPatient.setName(newPatientRequest.getName());
		existingPatient.setMobile(newPatientRequest.getMobile());
		existingPatient.setWeight(newPatientRequest.getWeight());
		existingPatient.setGender(newPatientRequest.getGender());
		existingPatient.setEmail(newPatientRequest.getEmail());
		existingPatient.setPassword(newPatientRequest.getPassword());
		return patientRepository.save(existingPatient);

	}

	@Override
	public List<Doctor> listAllDoctorByPatientID(Integer patientId) {

		return patientRepository.listAllDoctorByPatientID(patientId);

	}

	@Override
	public Patient createPatient(Patient newPatientRequest) {

		/*
		 * Users user = new Users(); user.setUsername(newPatientRequest.getUsername());
		 * user.setPassword(newPatientRequest.getPassword());
		 * user.setUserType(newPatientRequest.getUserType());
		 * 
		 * Users newUser = usersRepository.save(user); Patient pp = new Patient();
		 * pp.setPatientId(newUser.getUserId()); pp.setAge(newPatientRequest.getAge());
		 * pp.setAreaOfPains(newPatientRequest.getAreaOfPains());
		 * pp.setName(newPatientRequest.getName());
		 * pp.setMobile(newPatientRequest.getMobile());
		 * pp.setWeight(newPatientRequest.getWeight());
		 * pp.setGender(newPatientRequest.getGender());
		 */
		return patientRepository.save(newPatientRequest);
	}

	@Override
	public Appointment getAppoinmentByAppointmentId(Integer appointmentId) {
		Appointment appointments = appointmentRepository.findById(appointmentId).isPresent()
				? appointmentRepository.findById(appointmentId).get()
				: null;
		if (appointments == null) {
			throw new ResourceNotFoundException("Appointment id doesn't exist in db");
		}
		return appointments;
	}

	@Override
	public List<Appointment> getAppoinmentByDoctorIdAndPatientId(Integer doctorId, Integer patientId, String status) {

		Patient existingPatient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		Doctor existingDoctor = doctorRepository.findById(doctorId).isPresent()
				? doctorRepository.findById(doctorId).get()
				: null;
		if (existingPatient == null || null == existingDoctor) {
			throw new ResourceNotFoundException("Patient or doctor not found");
		}
		if (status == null) {
			return appointmentRepository.findByPatientAndDoctor(existingPatient, existingDoctor);

		}
		return appointmentRepository.findByStatusAndDoctorAndPatient(status, existingDoctor, existingPatient);
	}

	/*
	 * @Override public Consultation
	 * getConsultationMsgsByPatientIdAndConsultId(String patientId, String
	 * consultId) { return
	 * consultationRepo.findByConsultationsByPatientIdAndConsultId(patientId,
	 * consultId); }
	 */

	@Override
	public List<Appointment> listAppoinmentsByPatientId(Integer patientId) {
		Patient existingPatient = patientRepository.findById(patientId).isPresent()
				? patientRepository.findById(patientId).get()
				: null;
		if (existingPatient == null) {
			throw new ResourceNotFoundException("Patient not found");
		}
		return appointmentRepository.findByPatient(existingPatient);
		// patientRepository.listAppoinmentsByPatientId(patientId);
	}

	/*
	 * @Override public List<Consultation> listConsultationMsgsByPatient(String
	 * patientId, String doctorId, String status) { if (status == null) { return
	 * consultationRepo.findByConsultationsByPatientId(patientId, doctorId); }
	 * return consultationRepo.findByConsultationsByPatientId(patientId, doctorId,
	 * status); }
	 */

	@Override
	public List<Conversation> getConsultations(String pid, String did, String date) {

		return conRepository.findByPidAndDid(pid, did);
	}

	@Override
	public Appointment updateAppointmentWithDoctor(Integer pid, AppointmentRequest appointmentRequest) {
		Patient patient = patientRepository.findById(pid).isPresent() ? patientRepository.findById(pid).get() : null;
		Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId()).isPresent()
				? doctorRepository.findById(appointmentRequest.getDoctorId()).get()
				: null;
		Appointment existApp = appointmentRepository.findByDoctorAndPatient(doctor, patient);
		if (existApp == null) {
			throw new ResourceNotFoundException(" unable to update new request ");
		}
		existApp.setPatient(patient);
		existApp.setDoctor(doctor);
		existApp.setStatus(appointmentRequest.getStatus());
		existApp.setApnmntDate(appointmentRequest.getDateOfAppointment());
		existApp.setTypeOfAppointment(appointmentRequest.getTypeOfAppointment());

		return appointmentRepository.save(existApp);
	}

	@Override
	public PatientLogResponse getPatientLogsByPatientId(String patientId) {
		Patient patient = patientRepository.findById(Integer.parseInt(patientId)).isPresent()
				? patientRepository.findById(Integer.parseInt(patientId)).get()
				: null;
		if (patient == null) {
			throw new ResourceNotFoundException(" patient not found ");
		}
		PatientLogResponse response = new PatientLogResponse();
		response.setPatientID(Integer.parseInt(patientId));
		if (patient.getGender().equals("male")) {

			// Mandatory Fields
			List<PatientLog> stressList = logRepo.findByPatientIdAndLogType(patientId, "dm_stress");
			List<PatientLog> alchoholList = logRepo.findByPatientIdAndLogType(patientId, "dm_alchohol");
			List<PatientLog> sleepList = logRepo.findByPatientIdAndLogType(patientId, "dm_sleep");
			List<PatientLog> phyActivityList = logRepo.findByPatientIdAndLogType(patientId, "dm_phy_activity");
			List<PatientLog> exerciseList = logRepo.findByPatientIdAndLogType(patientId, "dm_exercise");
			List<PatientLog> weatherList = logRepo.findByPatientIdAndLogType(patientId, "dm_weather");

			response.setStress(stressList);
			response.setAlchohol(alchoholList);
			response.setSleep(sleepList);
			response.setPhysicalActivity(phyActivityList);
			response.setExercise(exerciseList);
			response.setWeather(weatherList);

			// Optional Fields
			List<PatientLog> yogaList = logRepo.findByPatientIdAndLogType(patientId, "dm_yoga");
			if (yogaList.isEmpty() == false && yogaList.size() >= 1)
				response.setYoga(yogaList);

			List<PatientLog> waterList = logRepo.findByPatientIdAndLogType(patientId, "dm_water");
			if (waterList.isEmpty() == false && waterList.size() >= 1)
				response.setWater(waterList);
			List<PatientLog> nutritionList = logRepo.findByPatientIdAndLogType(patientId, "dm_nutrition");
			if (nutritionList.isEmpty() == false && nutritionList.size() >= 1)
				response.setNutrition(nutritionList);
			List<PatientLog> mentalHealthList = logRepo.findByPatientIdAndLogType(patientId, "dm_mntl_health");
			if (mentalHealthList.isEmpty() == false && mentalHealthList.size() >= 1)
				response.setMentalHealth(mentalHealthList);

			return response;
		}
		if (patient.getGender().equals("female")) {
			// Mandatory Fields
			List<PatientLog> stressList = logRepo.findByPatientIdAndLogType(patientId, "dm_stress");
			List<PatientLog> alchoholList = logRepo.findByPatientIdAndLogType(patientId, "dm_alchohol");
			List<PatientLog> sleepList = logRepo.findByPatientIdAndLogType(patientId, "dm_sleep");
			List<PatientLog> phyActivityList = logRepo.findByPatientIdAndLogType(patientId, "dm_phy_activity");
			List<PatientLog> exerciseList = logRepo.findByPatientIdAndLogType(patientId, "dm_exercise");
			List<PatientLog> weatherList = logRepo.findByPatientIdAndLogType(patientId, "dm_weather");
			List<PatientLog> mensesList = logRepo.findByPatientIdAndLogType(patientId, "dm_menses");

			response.setStress(stressList);
			response.setAlchohol(alchoholList);
			response.setSleep(sleepList);
			response.setPhysicalActivity(phyActivityList);
			response.setExercise(exerciseList);
			response.setWeather(weatherList);
			response.setMenses(mensesList);

			// Optional Fields
			List<PatientLog> yogaList = logRepo.findByPatientIdAndLogType(patientId, "dm_yoga");
			if (yogaList.isEmpty() == false && yogaList.size() >= 1)
				response.setYoga(yogaList);

			List<PatientLog> waterList = logRepo.findByPatientIdAndLogType(patientId, "dm_water");
			if (waterList.isEmpty() == false && waterList.size() >= 1)
				response.setWater(waterList);
			List<PatientLog> nutritionList = logRepo.findByPatientIdAndLogType(patientId, "dm_nutrition");
			if (nutritionList.isEmpty() == false && nutritionList.size() >= 1)
				response.setNutrition(nutritionList);
			List<PatientLog> mentalHealthList = logRepo.findByPatientIdAndLogType(patientId, "dm_mntl_health");
			if (mentalHealthList.isEmpty() == false && mentalHealthList.size() >= 1)
				response.setMentalHealth(mentalHealthList);
		}
		return response;
	}

}
