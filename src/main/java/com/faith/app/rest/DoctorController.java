package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.Diagnosis;
import com.faith.app.entity.Dosage;
import com.faith.app.entity.LabTest;
import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicnePrescription;
import com.faith.app.entity.TestPrescription;
import com.faith.app.service.IDoctorService;

@CrossOrigin(origins = "*", allowedHeaders = "*") // to avoid the conflict btwn the tomcat and angular port numbers
@RestController // it is the compination of @Controller and @Configuration
@RequestMapping("/api")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;

	@GetMapping("/doctor/{userId}")
	public List<Appointment> getAllPatients(@PathVariable int userId) {
		return doctorService.getPatients(userId);

	}

	@GetMapping("/doctordiagnosis/{patientId}")
	public List<Diagnosis> getDiagnosis(@PathVariable int patientId) {
		System.out.println("im in controller");
		return doctorService.getDiagnosis(patientId);

	}

	@PostMapping("/doctordiagnosis")
	public void addDiagnosis(@RequestBody Diagnosis diagnosis) {
		doctorService.addDiagnosis(diagnosis);
	}

	@GetMapping("/doctordosage")
	public List<Dosage> getDosage(){
		
		return doctorService.getDosage();
	}

	@GetMapping("/doctormedicinelist")
	public List<Medicine> getMedicine() {
		

		return doctorService.getMedicine();
	}
	
	@GetMapping("/doctorMedicinePrescription/{patientId}")
	public List<MedicnePrescription> getMedicinePrescription(@PathVariable int patientId) {
		System.out.println("im in controller");
		return doctorService.getMedicinePrescription(patientId);

	}
	
	@PostMapping("/doctorMedicinePrescription")
	public void addMedicinePrescription(@RequestBody MedicnePrescription medicnePrescription) {
		doctorService.addMedicnePrescription(medicnePrescription);
	}
	@GetMapping("/doctorMedicinePrescriptionAppointment/{appointmentId}")
	public List<MedicnePrescription> getMedicinePrescriptionAppoinmtment(@PathVariable int appointmentId) {
	
		return doctorService.getMedicinePrescriptionAppointment(appointmentId);

	}
	@DeleteMapping("/doctorMedicinePrescription/{id}")
	public void deleteMedicinePrescription(@PathVariable int id) {
		doctorService.deleteMedicinePrescription(id);
	}
	//LABORATORY
	
	@GetMapping("/doctorLabName")
	public List<LabTest> getLabname() {
		

		return doctorService.getLabname();
	}
	
	@GetMapping("/doctorLabPrescription/{patientId}")
	public List<TestPrescription> getTestPrescription(@PathVariable int patientId) {
		System.out.println("im in controller");
		return doctorService.getTestPrescription(patientId);

	}
	
	@PostMapping("/doctorLabPrescription")
	public void addTestPrescription(@RequestBody TestPrescription testPrescription) {
		
		doctorService.addTestPrescription(testPrescription);
	}
	
	@GetMapping("/doctorTestPrescriptionAppointment/{appointmentId}")
	public List<TestPrescription> getTestPrescriptionAppoinmtment(@PathVariable int appointmentId) {
	
		return doctorService.getTestPrescriptionAppointment(appointmentId);

	}
	
	@DeleteMapping("/doctorTestPrescription/{id}")
	public void deleteTestPrescription(@PathVariable int id) {
		doctorService.deleteTestPrescription(id);
	}
	
	@GetMapping("/doctorTestPrescriptionAppointmentreport/{Id}")
	public List<TestPrescription> getTestPrescriptionReport(@PathVariable int Id) {
		System.out.println("im in controller");
		return doctorService.getTestPrescriptionReport(Id);

	}
	@DeleteMapping("/doctorNextPatient/{id}")
	public void doctorNextPatient(@PathVariable int id) {
		doctorService.doctorNextPatient(id);
	}
}