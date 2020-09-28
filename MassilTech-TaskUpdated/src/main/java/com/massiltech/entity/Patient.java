package com.massiltech.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ptnt_id")
	private int patientId;

	@Column(name = "ptnt_name")
	private String name;

	@Column(name = "ptnt_weight")
	private int weight;

	@Column(name = "ptnt_age")
	private int age;

	@Column(name = "ptnt_pain")
	private String areaOfPains;

	@Column(name = "ptnt_cntct_nbr")
	private String mobile;

	@Column(name = "ptnt_gender")
	private String gender;

	@Column(name = "ptnt_username")
	private String email;
	
	@Column(name = "ptnt_password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
	private List<Appointment> appointments;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAreaOfPains() {
		return areaOfPains;
	}

	public void setAreaOfPains(String areaOfPains) {
		this.areaOfPains = areaOfPains;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@JsonIgnore
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", weight=" + weight + ", age=" + age
				+ ", areaOfPains=" + areaOfPains + ", notes=" + mobile + "]";
	}

}
