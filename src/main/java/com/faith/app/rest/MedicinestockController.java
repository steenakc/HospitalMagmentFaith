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

import com.faith.app.entity.MedicineStock;
import com.faith.app.service.IMedicinestockService;

@CrossOrigin
@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class MedicinestockController {

	@Autowired
	private IMedicinestockService medstockservice;
	
	@PostMapping("/stock")
	public void addMedicinestock(@RequestBody MedicineStock medstock) {
		medstockservice.addMedicinestock(medstock);
	}
	
	@GetMapping("/stock")
	public List<MedicineStock> listAllStock(){
		return medstockservice.listAllMedStock();
	}
	
	@PutMapping("/stock")
	public void updateStock(@RequestBody MedicineStock medstock) {
		medstockservice.updateMedicinestock(medstock);
	}
	
	@DeleteMapping("/stock/{id}")
	public void deleteStock(@PathVariable int id) {
		medstockservice.deleteMedicinestock(id);
	}
}
