/*
 * package com.massiltech.entity;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "consult") public class Consultation {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "consult_id") private int consultId;
 * 
 * @Column(name = "[from]") private String textFrom;
 * 
 * @Column(name = "[to]") private String textTo;
 * 
 * @Column(name = "msg_date") private String textDate;
 * 
 * @Column(name = "text") private String text;
 * 
 * @Column(name = "apmnt_id") // @ManyToOne // @JoinColumn(name = "apmnt_id")
 * private int appointmentId;
 * 
 * public void setAppointmentId(int appointmentId) { this.appointmentId =
 * appointmentId; }
 * 
 * public int getAppointmentId() { return appointmentId; }
 * 
 * public int getConsultId() { return consultId; }
 * 
 * public void setConsultId(int consultId) { this.consultId = consultId; }
 * 
 * public String getTextFrom() { return textFrom; }
 * 
 * public void setTextFrom(String textFrom) { this.textFrom = textFrom; }
 * 
 * public String getTextTo() { return textTo; }
 * 
 * public void setTextTo(String textTo) { this.textTo = textTo; }
 * 
 * public String getTextDate() { return textDate; }
 * 
 * public void setTextDate(String textDate) { this.textDate = textDate; }
 * 
 * public String getText() { return text; }
 * 
 * public void setText(String text) { this.text = text; }
 * 
 * @Override public String toString() { return "Consultation [consultId=" +
 * consultId + ", textFrom=" + textFrom + ", textTo=" + textTo + ", textDate=" +
 * textDate + ", text=" + text + ", appointment=" + appointmentId + "]"; }
 * 
 * }
 */