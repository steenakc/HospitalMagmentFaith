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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.DTO.DoctorSlotAppointments;
import com.faith.app.entity.Appointment;
import com.faith.app.entity.Department;
import com.faith.app.entity.Patient;
import com.faith.app.service.ReceptionistService;

@CrossOrigin
@RestController
@RequestMapping("/receptionist")

public class RecptionistController {
	@Autowired
	ReceptionistService recepService;

	// add new patients
	@PostMapping("/add-patient")
	public Patient addPatient(@RequestBody Patient patient) {
		return recepService.savePatient(patient);

	}
	// add appointment
		@PostMapping("/appointment")
		public Appointment addAppointment(@RequestBody Appointment appointment) {
			return recepService.saveAppointment(appointment);
		}

	// list patients
	@GetMapping("/list-patient")

	public List<Patient> getAllPatinets() {

		return recepService.getPatients();

	}
	
	//seacrh patient by Phone number or Patient name
//	@GetMapping("/search-patient")
//	public List<Patient> listPatientByPhOrName(@RequestParam String phNo, @RequestParam String patientName) {
//	    return recepService.listPatientByPhOrName(phNo, patientName);
//	}

	@GetMapping("/search-patient")
	public List<Patient> searchPatientByNameOrPhone(@RequestParam(required = false) String searchTerm) {
	    return recepService.searchPatientByNameOrPhone(searchTerm);
	}

	

	// list by id
//path param
	@GetMapping("/get-patient/{id}")
	public Patient getPatient(@PathVariable int id) {
		return recepService.getPatient(id);
	}
	
	//appointment list by id
	
	@GetMapping("/get-appointment/{id}")
	public Appointment getAppointment(@PathVariable int id) {
		return recepService.getAppointment(id);
	}
	//request-param
	
//	@GetMapping("/get-patient")
//	public Patient getPatiendsdst(@RequestParam("aaaa") int bbbb) {
//		return recepService.getPatient(id);
//	}

	// list by isActive
	@GetMapping("/patientIsActive")
	public List<Patient> getPatientByIsActive() {
		return recepService.listPatinetByISActive();
	}

	// edit patientdetails

	@PutMapping("/edit-patient")
	public  Patient updatePatient(@RequestBody Patient patient) {
		 return recepService.savePatient(patient);

	}

	// disable patient

	@DeleteMapping("/diasble-patient/{id}")
	public  boolean disablePatient(@PathVariable int id) {
		 recepService.deletePatient(id);
		return true;
	}

	
	
	//list aappointment
	
	@GetMapping("/appointment")
	public List<Appointment>getAppointmnets(){
		return recepService.getAppointmnets();
	}
	
//list departments
	@GetMapping("/departments")
	public List<Department>getDepartments(){
		return recepService.getDepartments();
	}
	
	// listing appointments in dashboard

	@GetMapping("/dashboard-appointmnets-details")
	public List<DoctorSlotAppointments> getDashboardDetails(@RequestParam("departmentId") int departnemtnId,
			@RequestParam("date") String date) {
		return recepService.getDashboardDetails(departnemtnId, date);

	}

}
