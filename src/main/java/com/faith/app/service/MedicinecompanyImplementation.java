package com.faith.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faith.app.entity.MedicineCompany;
import com.faith.app.repo.IMedicinecompany;

@Service
public class MedicinecompanyImplementation implements IMedicinecompanyService {

	@Autowired 
	private IMedicinecompany companyrepo;

	//Add
	public void addCompany(MedicineCompany company) {
		
		companyrepo.save(company);
	}

	//List
	public List<MedicineCompany> listAllCompany() {
		
		return (List<MedicineCompany>) companyrepo.findAll();
	}

	//Update
	public void updateCompany(MedicineCompany company) {
		
		companyrepo.save(company);

	}

	//Delete
	@Transactional
	public void deleteCompany(int id) {
			
		companyrepo.disablecompany(id);
	}


}
