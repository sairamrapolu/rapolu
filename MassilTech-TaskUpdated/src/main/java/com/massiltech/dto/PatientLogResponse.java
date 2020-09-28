package com.massiltech.dto;
import java.util.List;

import com.massiltech.entity.PatientLog;

public class PatientLogResponse {
	// mandatory
	private int patientID;
	private List<PatientLog> stress;
	private List<PatientLog> alchohol;
	private List<PatientLog> sleep;
	private List<PatientLog> physicalActivity;
	private List<PatientLog> weather;
	private List<PatientLog> exercise;
	// optionla
	private List<PatientLog> menses;
	private List<PatientLog> nutrition;
	private List<PatientLog> mentalHealth;
	private List<PatientLog> yoga;
	private List<PatientLog> water;
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public List<PatientLog> getStress() {
		return stress;
	}
	public void setStress(List<PatientLog> stress) {
		this.stress = stress;
	}
	public List<PatientLog> getAlchohol() {
		return alchohol;
	}
	public void setAlchohol(List<PatientLog> alchohol) {
		this.alchohol = alchohol;
	}
	public List<PatientLog> getSleep() {
		return sleep;
	}
	public void setSleep(List<PatientLog> sleep) {
		this.sleep = sleep;
	}
	public List<PatientLog> getPhysicalActivity() {
		return physicalActivity;
	}
	public void setPhysicalActivity(List<PatientLog> physicalActivity) {
		this.physicalActivity = physicalActivity;
	}
	public List<PatientLog> getWeather() {
		return weather;
	}
	public void setWeather(List<PatientLog> weather) {
		this.weather = weather;
	}
	public List<PatientLog> getExercise() {
		return exercise;
	}
	public void setExercise(List<PatientLog> exercise) {
		this.exercise = exercise;
	}
	public List<PatientLog> getMenses() {
		return menses;
	}
	public void setMenses(List<PatientLog> menses) {
		this.menses = menses;
	}
	public List<PatientLog> getNutrition() {
		return nutrition;
	}
	public void setNutrition(List<PatientLog> nutrition) {
		this.nutrition = nutrition;
	}
	public List<PatientLog> getMentalHealth() {
		return mentalHealth;
	}
	public void setMentalHealth(List<PatientLog> mentalHealth) {
		this.mentalHealth = mentalHealth;
	}
	public List<PatientLog> getYoga() {
		return yoga;
	}
	public void setYoga(List<PatientLog> yoga) {
		this.yoga = yoga;
	}
	public List<PatientLog> getWater() {
		return water;
	}
	public void setWater(List<PatientLog> water) {
		this.water = water;
	}
	

}