package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineCompany;

public interface IMedicinecompanyService {

			//Add
			public void addCompany(MedicineCompany company);
			
			//List
			public List<MedicineCompany> listAllCompany();
			
			//List by medicinecompanyId
			public MedicineCompany companyById(int medicneCompanyId);
		
			//Update
			public void updateCompany(MedicineCompany company);
			
			//Delete
			public void deleteCompany(int id);

}
