package com.faith.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicnePrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medicnePrescriptionId;
	
	private Integer count;
	
	private Integer noOfDays;
	
	private boolean pharmaStatus;
	
	private boolean isActive=true;
	
	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name="appointmentId",insertable = false,updatable = false)
	private Appointment appointment;
	
	private Integer medicineId;
	@ManyToOne
	@JoinColumn(name="medicineId",insertable = false,updatable = false)
	private Medicine medicne;
	
	private Integer dosageId;
	@ManyToOne
	@JoinColumn(name="dosageId",insertable = false,updatable = false)
	private Dosage dosage;

	public MedicnePrescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMedicnePrescriptionId() {
		return medicnePrescriptionId;
	}

	public void setMedicnePrescriptionId(Integer medicnePrescriptionId) {
		this.medicnePrescriptionId = medicnePrescriptionId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public boolean isPharmaStatus() {
		return pharmaStatus;
	}

	public void setPharmaStatus(boolean pharmaStatus) {
		this.pharmaStatus = pharmaStatus;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Medicine getMedicne() {
		return medicne;
	}

	public void setMedicne(Medicine medicne) {
		this.medicne = medicne;
	}

	public Dosage getDosage() {
		return dosage;
	}

	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public Integer getDosageId() {
		return dosageId;
	}

	public void setDosageId(Integer dosageId) {
		this.dosageId = dosageId;
	}

	
	public String toString() {
		return "MedicnePrescription [medicnePrescriptionId=" + medicnePrescriptionId + ", count=" + count
				+ ", noOfDays=" + noOfDays + ", pharmaStatus=" + pharmaStatus + ", isActive=" + isActive
				+ ", appointmentId=" + appointmentId + ", appointment=" + appointment + ", medicineId=" + medicineId
				+ ", medicne=" + medicne + ", dosageId=" + dosageId + ", dosage=" + dosage + "]";
	}
	
	
	
	

}
