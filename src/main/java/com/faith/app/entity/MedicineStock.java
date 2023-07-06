package com.faith.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicineStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medicineStockId ;
	
	private LocalDate stockAddedDate=LocalDate.now();;
	
	private  Integer purchasedCount;
	
	private LocalDate expiryDate;
	
	private Integer noOfBoxes;
	
	private Integer unitPerBox;
	
	private Integer medicineId;
	@ManyToOne
	@JoinColumn(name="medicineId",insertable = false,updatable = false)
	private Medicine medicine;
	
	private boolean isActive=true;
	

	public MedicineStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMedicineStockId() {
		return medicineStockId;
	}

	public void setMedicineStockId(Integer medicineStockId) {
		this.medicineStockId = medicineStockId;
	}

	public LocalDate getStockAddedDate() {
		return stockAddedDate;
	}

	public void setStockAddedDate(LocalDate stockAddedDate) {
		this.stockAddedDate = stockAddedDate;
	}

	public Integer getPurchasedCount() {
		return purchasedCount;
	}

	public void setPurchasedCount(Integer purchasedCount) {
		this.purchasedCount = purchasedCount;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getNoOfBoxes() {
		return noOfBoxes;
	}

	public void setNoOfBoxes(Integer noOfBoxes) {
		this.noOfBoxes = noOfBoxes;
	}

	public Integer getUnitPerBox() {
		return unitPerBox;
	}

	public void setUnitPerBox(Integer unitPerBox) {
		this.unitPerBox = unitPerBox;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public String toString() {
		return "MedicineStock [medicineStockId=" + medicineStockId + ", stockAddedDate=" + stockAddedDate
				+ ", purchasedCount=" + purchasedCount + ", expiryDate=" + expiryDate + ", noOfBoxes=" + noOfBoxes
				+ ", unitPerBox=" + unitPerBox + ", medicineId=" + medicineId + ", medicine=" + medicine + ", isActive="
				+ isActive + "]";
	}
	

}
