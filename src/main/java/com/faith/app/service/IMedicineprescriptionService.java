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
		
		//Update Pharma status
		public void updatePharma(int appointmentId);
		
		//Disable
		public void disableMedicineprescription(int id);
		
		//List by id
		public List<MedicnePrescription> getmedprescribe(int appointmentId);

		//List by pharma
		public List<MedicnePrescription> listByPharma();
}
