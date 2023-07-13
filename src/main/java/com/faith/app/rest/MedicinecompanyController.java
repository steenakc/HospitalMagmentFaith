package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineCompany;
import com.faith.app.service.IMedicinecompanyService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")

public class MedicinecompanyController {

	@Autowired
	IMedicinecompanyService companyservice;
	
	@PostMapping("/company")
	public void addCompany(@RequestBody MedicineCompany company) {
		companyservice.addCompany(company);
	}
	
	@GetMapping("/company")
	public List<MedicineCompany> listAllCompany(){
		return companyservice.listAllCompany();
	}
	
	@GetMapping("/company/{medicneCompanyId}")		
	public MedicineCompany getCompanyId(@PathVariable int medicneCompanyId) {		
		return companyservice.companyById(medicneCompanyId);
	}
	
	@PutMapping("/company")
	public void updateCustomer(@RequestBody MedicineCompany company) {
		companyservice.updateCompany(company);
	}
	
	
	@DeleteMapping("/company/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyservice.deleteCompany(id);
	}
}
