package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineStock;


public interface IMedicineService {
	
		//Add
		public void addMedicine(Medicine medicine);
		
		//List
		public List<Medicine> listAllMedicine();
		
		//Update
		public void updateMedicine(Medicine medicine);
		
		//Delete
		public void deleteMedicine(int id);
		
		//List by medicineId
		public Medicine medicineById(int medicineId);
	

}
