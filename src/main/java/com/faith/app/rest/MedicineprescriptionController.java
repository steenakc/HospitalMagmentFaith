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

import com.faith.app.entity.MedicnePrescription;
import com.faith.app.service.IMedicineprescriptionService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class MedicineprescriptionController {

	@Autowired
	private IMedicineprescriptionService medService;
	
	@PostMapping("/prescribe")
	public void addMedicineprescription(@RequestBody MedicnePrescription medprescribe) {
		
		medService.addMedicineprescription(medprescribe);
	}
	
	@GetMapping("/prescribe")
	public List<MedicnePrescription> listAllPrescription(){
		return medService.listAllMedicineprescription();
	}
	
	@PutMapping("/prescribe")
	public void updateMedPrescription(@RequestBody MedicnePrescription medprescribe) {
		medService.updateMedicineprescription(medprescribe);
	}
	
	@DeleteMapping("/prescribe/{id}")
	public void deleteMedPrescribe(@PathVariable int id) {
		medService.disableMedicineprescription(id);
	}
}
