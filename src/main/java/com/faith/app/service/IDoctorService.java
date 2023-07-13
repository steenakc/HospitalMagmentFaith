package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.Diagnosis;
import com.faith.app.entity.Dosage;
import com.faith.app.entity.LabTest;
import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicnePrescription;
import com.faith.app.entity.TestPrescription;

public interface IDoctorService {

	List<Appointment> getPatients(int userId);

	List<Diagnosis> getDiagnosis(int patientId);

	void addDiagnosis(Diagnosis diagnosis);

	List<Dosage> getDosage();

	List<Medicine> getMedicine();

	List<MedicnePrescription> getMedicinePrescription(int patientId);

	void addMedicnePrescription(MedicnePrescription medicnePrescription);

	List<MedicnePrescription> getMedicinePrescriptionAppointment(int appointmentId);

	void deleteMedicinePrescription(int id);
	

	List<LabTest> getLabname();

	List<TestPrescription> getTestPrescriptionAppointment(int appointmentId);

	void deleteTestPrescription(int id);

	void addTestPrescription(TestPrescription testPrescription);

	List<TestPrescription> getTestPrescription(int patientId);

	List<TestPrescription> getTestPrescriptionReport(int id);

	void doctorNextPatient(int id);

}
