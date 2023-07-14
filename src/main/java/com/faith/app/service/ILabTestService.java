package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.LabTest;

public interface ILabTestService {
	
	//list
	public List<LabTest> getListTest();
	
	//add
	public void saveLabTest(LabTest labtest);
	
	//update
	public LabTest getLabTest(Integer id);
	
	//delete
	public void disableLabTest(int id);

	//find by lab test name
	public List<LabTest> getLabTestByName(String name);
	
	//List by labtestId
		public LabTest labtestById(int labTestId);

}
