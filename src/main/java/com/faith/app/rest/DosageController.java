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
import com.faith.app.entity.Dosage;
import com.faith.app.service.IDosageService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class DosageController {

	@Autowired
	private IDosageService doseService;
	
	@PostMapping("/dose")
	public void addDose(@RequestBody Dosage dose) {
		doseService.addDosage(dose);
	}
	
	@GetMapping("/dose")
	public List<Dosage> listAllDose(){
		return doseService.listAllDose();
	}
	
}
