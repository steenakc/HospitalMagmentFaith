package com.faith.app.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.LabTest;
import com.faith.app.entity.MedicnePrescription;
import com.faith.app.entity.TestPrescription;
import com.faith.app.service.ITestPrescriptionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabTestPrescriptionContoller {
	
	@Autowired
	private ITestPrescriptionService testpresService;
	
	@GetMapping("testpres")
	public List<TestPrescription>getAllTestPrescription(){
		return testpresService.getTestPrescription();
		
	}
	
	@PostMapping("testpres")
	public void addTestPrescription(@RequestBody TestPrescription pres) {

		int testPrescriptionId=pres.getTestPrescriptionId();
		TestPrescription testPrescription=testpresService.testPrescriptionById(testPrescriptionId);
		System.out.println(testPrescription);
		testPrescription.setReportCreateDate(LocalDate.now());
		testPrescription.setActualValue(pres.getActualValue());
				testpresService.addTestPrescription(testPrescription);
	}
	@GetMapping("testpres/{patientId}")
	public List<TestPrescription>getTestPrescriptionHistory(@PathVariable Integer patientId){
		return testpresService.getTestPrescriptionHistory(patientId);
	}
	@GetMapping("/tests/{testPrescriptionId}")
	public TestPrescription listTestById(@PathVariable int testPrescriptionId){
		return testpresService.testPrescriptionById(testPrescriptionId);
	}
	
	// Get prescription by id
		@GetMapping("/prescribes/{appointmentId}")
		public List<TestPrescription> getPrescription(@PathVariable int appointmentId) {
			
			return testpresService.testPrescriptionId(appointmentId);
		}
		
		

	

}