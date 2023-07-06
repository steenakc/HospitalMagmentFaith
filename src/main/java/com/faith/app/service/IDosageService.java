package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Dosage;

public interface IDosageService {

	//Add
	public void addDosage(Dosage dose);
	
	//List
	public List<Dosage> listAllDose();
	
	
}
