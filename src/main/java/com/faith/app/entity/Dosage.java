package com.faith.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dosage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dosageId;
	
	private String dosageStatus;
	
	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}


	private Integer dose;

	public Dosage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDosageId() {
		return dosageId;
	}

	public void setDosageId(Integer dosageId) {
		this.dosageId = dosageId;
	}

	public String getDosageStatus() {
		return dosageStatus;
	}

	public void setDosageStatus(String dosageStatus) {
		this.dosageStatus = dosageStatus;
	}

	
	public String toString() {
		return "Dosage [dosageId=" + dosageId + ", dosageStatus=" + dosageStatus + "]";
	}
	
	

}
