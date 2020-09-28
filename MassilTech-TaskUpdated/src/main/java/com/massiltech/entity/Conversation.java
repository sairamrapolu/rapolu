package com.massiltech.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversation")
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consult_id")
	private int consultId;

	@Column(name = "text_from")
	private String textFrom;

	@Column(name = "text_cdate")
	private Date textdate;

	@Column(name = "ptnt_id")
	private String pid;

	@Column(name = "dctr_id")
	private String did;

	@Column(name = "text")
	private String text;

	public int getConsultId() {
		return consultId;
	}

	public void setConsultId(int consultId) {
		this.consultId = consultId;
	}

	public String getTextFrom() {
		return textFrom;
	}

	public void setTextFrom(String textFrom) {
		this.textFrom = textFrom;
	}

	public Date getTextdate() {
		return textdate;
	}

	public void setTextdate(Date textdate) {
		this.textdate = textdate;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
