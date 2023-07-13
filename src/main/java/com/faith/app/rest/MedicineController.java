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
import com.faith.app.service.IMedicineService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class MedicineController {

	@Autowired
	private IMedicineService medService;
	
	@PostMapping("medicine")
	public void addMedicine(@RequestBody Medicine medicine) {
		System.out.println(medicine);
		
		medService.addMedicine(medicine);
	}
	
	@GetMapping("/medicine")
	public List<Medicine> listAllMedicine(){
		return medService.listAllMedicine();
	}
	
	@GetMapping("/medicines/{medicineId}")		
	public Medicine getMedicineId(@PathVariable int medicineId) {		
		return medService.medicineById(medicineId);
	}
	
	@PutMapping("/medicine")
	public void updateMedicine(@RequestBody Medicine medicine) {
		medService.updateMedicine(medicine);
	}
	
	@DeleteMapping("/medicine/{id}")
	public void deleteMedicine(@PathVariable int id) {
		medService.deleteMedicine(id);
	}
}
