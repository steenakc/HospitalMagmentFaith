package com.faith.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Diagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diagnosisId;
	
	private String diagnosis;
	
	private Integer patientId;
	@ManyToOne
	@JoinColumn(name="patientId",insertable = false,updatable = false)
	private Patient patient;

	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name="appointmentId",insertable = false,updatable = false)
	private Appointment appointment;
	
	public Integer getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}


	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


	public Diagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getDiagnosisId() {
		return diagnosisId;
	}


	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public Integer getPatientId() {
		return patientId;
	}


	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "Diagnosis [diagnosisId=" + diagnosisId + ", diagnosis=" + diagnosis + ", patientId=" + patientId
				+ ", patient=" + patient + "]";
	}

	

	

}
