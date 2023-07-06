package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Medicine;
import com.faith.app.repo.IMedicine;

@Service
public class MedicineImplementation implements IMedicineService {

	@Autowired
	private IMedicine medicinerepo;
	
	//Add
	public void addMedicine(Medicine medicine) {
		
		medicinerepo.save(medicine);
	}

	//List
	public List<Medicine> listAllMedicine() {
		
		return (List<Medicine>) medicinerepo.findAll();
	}

	//Update
	public void updateMedicine(Medicine medicine) {
		medicinerepo.save(medicine);

	}

	//Delete
	public void deleteMedicine(int id) {
		medicinerepo.deleteById(id);

	}

}
