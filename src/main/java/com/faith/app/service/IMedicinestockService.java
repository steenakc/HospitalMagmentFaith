package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.MedicineStock;
import com.faith.app.entity.MedicnePrescription;

public interface IMedicinestockService {
	
	//Add
	public void addMedicinestock(MedicineStock medstock);
	
	//List
	public List<MedicineStock> listAllMedStock();
	
	//Update
	public void updateMedicinestock(MedicineStock medstock);
	
	//Disable
	public void deleteMedicinestock(int id);
	
	//List by id
	public MedicineStock getmedicineId(int medicineId);

	//List by medicineStockId
	public MedicineStock medicineStockById(int medicineStockId);
}
