package com.faith.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.Diagnosis;
import com.faith.app.entity.Dosage;
import com.faith.app.entity.LabTest;
import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicnePrescription;
import com.faith.app.entity.TestPrescription;
import com.faith.app.repo.IDoctorAppointmentRepository;
import com.faith.app.repo.IDoctorDiagnosisRepository;
import com.faith.app.repo.IDoctorDosageRepository;
import com.faith.app.repo.IDoctorLabTest;
import com.faith.app.repo.IDoctorMedicinePrescription;
import com.faith.app.repo.IDoctorMedicineRepository;
import com.faith.app.repo.IDoctorTestPrescription;
@Service
public class DoctorService implements IDoctorService {
	@Autowired
	private IDoctorAppointmentRepository doctorAppoinmentRepository;
	
	@Autowired
	private IDoctorLabTest doctorLabTest;
	
	@Autowired
	private IDoctorDiagnosisRepository doctorDiagnosisRepository;
	
	@Autowired
	private IDoctorDosageRepository doctorDosageRepository;

	@Autowired 
	private IDoctorMedicineRepository doctorMedicineRepository;
	@Autowired
	private IDoctorMedicinePrescription doctorMedicinePrescription;
	@Autowired
	private IDoctorTestPrescription doctorTestPrescription;
	
	@Override
	public List<Appointment> getPatients(int userId) {
		// TODO Auto-generated method stub
		return doctorAppoinmentRepository.getTodaysPatients(userId);
	}

//diagnosis
	@Override
	public List<Diagnosis> getDiagnosis(int patientId) {
		// TODO Auto-generated method stub
		return doctorDiagnosisRepository.getDiagnosis(patientId);
	}


	@Override
	public void addDiagnosis(Diagnosis diagnosis) {
		doctorDiagnosisRepository.save(diagnosis);
		
	}
	//medicine prescription


	@Override
	public List<Dosage> getDosage() {
		// TODO Auto-generated method stub
		return (List<Dosage>) doctorDosageRepository.findAll();
	}


	@Override
	public List<Medicine> getMedicine() {
		// TODO Auto-generated method stub
		return (List<Medicine>) doctorMedicineRepository.findAll();
	}

	@Override
	public List<MedicnePrescription> getMedicinePrescription(int patientId) {
		// TODO Auto-generated method stub
		return doctorMedicinePrescription.getMedicnePrescription(patientId);
	}


	@Override
	public void addMedicnePrescription(MedicnePrescription medicnePrescription) {
		doctorMedicinePrescription.save(medicnePrescription);
		
	}


	@Override
	public List<MedicnePrescription> getMedicinePrescriptionAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorMedicinePrescription.getMedicinePrescriptionAppointment(appointmentId);
	}


	@Override
	public void deleteMedicinePrescription(int id) {
		doctorMedicinePrescription.deleteById(id);
		
	}

//lab test
	@Override
	public List<LabTest> getLabname() {
		// TODO Auto-generated method stub
		return (List<LabTest>) doctorLabTest.findAll();
	}
	
	public List<TestPrescription> getTestPrescription(int patientId) {
		// TODO Auto-generated method stub
		return doctorTestPrescription.getLabPrescription(patientId);
	}


	@Override
	public void addTestPrescription(TestPrescription testPrescription) {
		doctorTestPrescription.save(testPrescription);
		
	}


	@Override
	public List<TestPrescription> getTestPrescriptionAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorTestPrescription.getlabPrescriptionAppointment(appointmentId);
	}


	@Override
	public void deleteTestPrescription(int id) {
		doctorTestPrescription.deleteById(id);
		
	}

	@Override
	public List<TestPrescription> getTestPrescriptionReport(int id) {
		// TODO Auto-generated method stub
		return doctorTestPrescription.getTestPrescriptionReport( id);
	}

	@Transactional
	public void doctorNextPatient(int id) {
		doctorAppoinmentRepository.disablePatient(id);
		
	}
	




}
