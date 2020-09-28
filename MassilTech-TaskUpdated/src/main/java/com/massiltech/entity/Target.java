package com.massiltech.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "target")
public class Target {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trgt_id")
	private int targetId;
	@Column(name = "ptnt_id")
	private int patientId;
	@Column(name = "trgt_alchohol")
	private int alchohol;
	@Column(name = "trgt_exercise")
	private int exercise;
	@Column(name = "trgt_yoga")
	private int yoga;
	@Column(name = "trgt_stress")
	private int stress;
	@Column(name = "trgt_sleep")
	private int sleep;
	@Column(name = "trgt_nutrition")
	private int nutrition;
	@Column(name = "trgt_phy_activity")
	private int phyActivity;
	@Column(name = "trgt_mntl_health")
	private int mentalActivity;
	@Column(name = "trgt_water")
	private int water;
	@Column(name = "trgt_cdate")
	private Date createdAt;

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getAlchohol() {
		return alchohol;
	}

	public void setAlchohol(int alchohol) {
		this.alchohol = alchohol;
	}

	public int getExercise() {
		return exercise;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
	}

	public int getYoga() {
		return yoga;
	}

	public void setYoga(int yoga) {
		this.yoga = yoga;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public int getNutrition() {
		return nutrition;
	}

	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}

	public int getPhyActivity() {
		return phyActivity;
	}

	public void setPhyActivity(int phyActivity) {
		this.phyActivity = phyActivity;
	}

	public int getMentalActivity() {
		return mentalActivity;
	}

	public void setMentalActivity(int mentalActivity) {
		this.mentalActivity = mentalActivity;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Target [targetId=" + targetId + ", patientId=" + patientId + ", alchohol=" + alchohol + ", exercise="
				+ exercise + ", yoga=" + yoga + ", stress=" + stress + ", sleep=" + sleep + ", nutrition=" + nutrition
				+ ", phyActivity=" + phyActivity + ", mentalActivity=" + mentalActivity + ", water=" + water
				+ ", createdAt=" + createdAt + "]";
	}

}
