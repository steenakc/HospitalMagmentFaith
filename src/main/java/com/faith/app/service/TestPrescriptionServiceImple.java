package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.LabTest;
import com.faith.app.entity.TestPrescription;
import com.faith.app.repo.ILabTestPrescriptionRepository;


@Service
public class TestPrescriptionServiceImple implements ITestPrescriptionService {
	
	@Autowired
	private ILabTestPrescriptionRepository testprescription;

	@Override
	public List<TestPrescription> getTestPrescription() {
		return(List<TestPrescription>) testprescription.findAll();
	}

	@Override
	public void addTestPrescription(TestPrescription pres) {
		testprescription.save(pres);
	}

	@Override
	public List<TestPrescription> getTestPrescriptionHistory(Integer patientId) {
		
	System.out.println(testprescription.getTestPrescriptionHistory(patientId));
	return(List<TestPrescription>) testprescription.getTestPrescriptionHistory(patientId);

	}
	public TestPrescription testPrescriptionById(int testPrescriptionId) {
		// TODO Auto-generated method stub
		return testprescription.gettestbyId(testPrescriptionId);
	}


}