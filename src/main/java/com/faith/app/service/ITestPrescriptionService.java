package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.LabTest;
import com.faith.app.entity.TestPrescription;

public interface ITestPrescriptionService {
	
	//List
	public List<TestPrescription> getTestPrescription();
	
	//insert
	public void addTestPrescription(TestPrescription pres);
	
	//list particular
	public List<TestPrescription>getTestPrescriptionHistory(Integer patientId);
	
	//List by testPrescriptionId
	public TestPrescription testPrescriptionById(int testPrescriptionId);


}