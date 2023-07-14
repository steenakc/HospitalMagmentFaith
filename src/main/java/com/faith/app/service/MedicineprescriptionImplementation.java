package com.faith.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.MedicnePrescription;
import com.faith.app.repo.IMedicineprescription;

@Service
public class MedicineprescriptionImplementation implements IMedicineprescriptionService {

	@Autowired
	private IMedicineprescription medprescriberepo;
	
	
	public void addMedicineprescription(MedicnePrescription medprescribe) {
		medprescriberepo.save(medprescribe);

	}

	
	public List<MedicnePrescription> listAllMedicineprescription() {
		
		return (List<MedicnePrescription>) medprescriberepo.findAll();
	}

	
	public void updateMedicineprescription(MedicnePrescription medprescribe) {
		medprescriberepo.save(medprescribe);

	}

	@Transactional
	public void disableMedicineprescription(int id) {
		medprescriberepo.disablemedicineprescription(id);

	}


	
	public List<MedicnePrescription> getmedprescribe(int appointmentId) {
		return (List<MedicnePrescription>)medprescriberepo.getmedicinePrescribe(appointmentId);
	}


	@Transactional
	public void updatePharma(int appointmentId) {
		medprescriberepo.disablepharmaStatus(appointmentId);
		
	}


	
	public List<MedicnePrescription> listByPharma() {
		return (List<MedicnePrescription>)medprescriberepo.displayByPharma();
	}
	
	
	
}
