package com.faith.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.LabTest;
import com.faith.app.repo.ILabTestRepository;

@Service
public class LabTestServiceImple implements ILabTestService{
	
	@Autowired
	private ILabTestRepository labtestrepo;

	@Override
	public List<LabTest> getListTest() {
		
		return (List<LabTest>) labtestrepo.listIsActive();
	}

	@Override
	public void saveLabTest(LabTest labtest) {
		labtestrepo.save(labtest);
	}

	@Override
	public LabTest getLabTest(Integer id) {
		// TODO Auto-generated method stub
		return  labtestrepo.findById(id).orElseThrow(() -> new RuntimeException("Test not found for id" + id));
	}

	

	@Override
	public List<LabTest> getLabTestByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Transactional
	public void disableLabTest(int id) {
		labtestrepo.disabletest(id);
		
	}

	
	public LabTest labtestById(int labTestId) {
		// TODO Auto-generated method stub
		return labtestrepo.gettestbyId(labTestId);
	}

}
