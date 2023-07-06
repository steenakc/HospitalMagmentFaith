package com.faith.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.MedicineStock;
import com.faith.app.repo.IMedicinestock;

@Service
public class MedicinestockImplementation implements IMedicinestockService {

	@Autowired
	private IMedicinestock medstockrepo;
	
	//Add
	public void addMedicinestock(MedicineStock medstock) {
		
		System.out.println("service");
		
		medstockrepo.save(medstock);

	}

	//List
	public List<MedicineStock> listAllMedStock() {
		
		return (List<MedicineStock>) medstockrepo.findAll();
	}

	//Update
	public void updateMedicinestock(MedicineStock medstock) {
		
		medstockrepo.save(medstock);
	}

	//Disable
	@Transactional
	public void deleteMedicinestock(int id) {
		
		medstockrepo.disablemedicinestock(id);
	}

}
