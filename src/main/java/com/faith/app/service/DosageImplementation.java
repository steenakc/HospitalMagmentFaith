package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Dosage;
import com.faith.app.repo.IDosage;

@Service
public class DosageImplementation implements IDosageService {

	@Autowired 
	private IDosage doserepo;
	
	
	public void addDosage(Dosage dose) {
		doserepo.save(dose);

	}
	
	public List<Dosage> listAllDose() {
		
		return (List<Dosage>) doserepo.findAll();
	}

}
