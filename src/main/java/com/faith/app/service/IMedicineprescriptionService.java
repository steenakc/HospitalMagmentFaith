package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.MedicnePrescription;


public interface IMedicineprescriptionService {

		//Add
		public void addMedicineprescription(MedicnePrescription medprescribe);
		
		//List
		public List<MedicnePrescription> listAllMedicineprescription();
		
		//Update
		public void updateMedicineprescription(MedicnePrescription medprescribe);
		
		//Disable
		public void disableMedicineprescription(int id);
}
