package com.massiltech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dctr_id")
	private int did;
	@Column(name = "dctr_name")
	private String doctorName;
	
	@Column(name = "dctr_age")
	private int age;
	
	@Column(name = "dctr_spec")
	private String doctorDesig;
	
	@Column(name = "dctr_exp")
	private int doctorExp;
	@Column(name = "dctr_gender")
	private String gender;
	
	
	@Column(name = "dctr_username")
	private String email;
	@Column(name = "dctr_password")
	private String password;
	
	@Column(name = "dctr_hsptl_info")
	private String doctorHsptl;

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

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorDesig() {
		return doctorDesig;
	}

	public void setDoctorDesig(String doctorDesig) {
		this.doctorDesig = doctorDesig;
	}

	public int getDoctorExp() {
		return doctorExp;
	}

	public void setDoctorExp(int doctorExp) {
		this.doctorExp = doctorExp;
	}

	public String getDoctorHsptl() {
		return doctorHsptl;
	}

	public void setDoctorHsptl(String doctorHsptl) {
		this.doctorHsptl = doctorHsptl;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", doctorName=" + doctorName + ", age=" + age + ", doctorDesig=" + doctorDesig
				+ ", doctorExp=" + doctorExp + ", gender=" + gender + ", email=" + email + ", password=" + password
				+ ", doctorHsptl=" + doctorHsptl + "]";
	}

	

}
