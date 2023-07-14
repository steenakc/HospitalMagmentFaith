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
	public List<MedicnePrescription> listAllPrescription() {
		return medService.listAllMedicineprescription();
	}

	// Get prescription by id
	@GetMapping("/prescribe/{appointmentId}")
	public List<MedicnePrescription> getPrescription(@PathVariable int appointmentId) {
		return medService.getmedprescribe(appointmentId);
	}
	
	// Get prescription by id
		@GetMapping("/pharmacy")
		public List<MedicnePrescription> getPharmaPrescription() {
			return medService.listByPharma();
		}
	

	@PutMapping("/prescribe")
	public void updateMedPrescription(@RequestBody MedicnePrescription medprescribe) {
		medService.updateMedicineprescription(medprescribe);
	}

	@DeleteMapping("/prescribe/{id}")
	public void deleteMedPrescribe(@PathVariable int id) {
		medService.disableMedicineprescription(id);
	}
	
	//deletePharmaStaus
	@DeleteMapping("/pharma/{appointmentId}")
	public void updatePharmaStatus(@PathVariable int appointmentId) {
		medService.updatePharma(appointmentId);
		}
}
