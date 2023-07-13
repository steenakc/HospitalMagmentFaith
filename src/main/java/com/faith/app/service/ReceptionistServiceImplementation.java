package com.faith.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.DTO.DoctorSlotAppointments;
import com.faith.app.entity.Appointment;
import com.faith.app.entity.Department;
import com.faith.app.entity.Doctor;
import com.faith.app.entity.Patient;
import com.faith.app.repo.AppointmentRepository;
import com.faith.app.repo.PatientRepository;
import com.faith.app.repo.RecepDepartmentRepository;
import com.faith.app.repo.ReceptionistDoctorRepository;

@Service
public class ReceptionistServiceImplementation implements ReceptionistService {

	@Autowired
	PatientRepository patientrepo;

	@Autowired
	AppointmentRepository appointrepo;

	@Autowired
	ReceptionistDoctorRepository recepdpctorrepo;
	
	@Autowired RecepDepartmentRepository recepdepartmnetrepo;

	@Override
	public Patient savePatient(Patient patient) {
		return patientrepo.save(patient);

	}

	@Override
	public List<Patient> getPatients() {
		return (List<Patient>) patientrepo.findAll();
	}

	@Override
	public Patient getPatient(int id) {

		return patientrepo.findById(id).orElseThrow(() -> new RuntimeException("Patinet not found  for id" + id));

	}

	@Transactional
	public void deletePatient(int id) {
		patientrepo.disable(id);

	}

	@Transactional
	public List<Patient> listPatinetByISActive() {
		return (List<Patient>) patientrepo.listIsActive();
	}
	
	
//	@Transactional
//	public List<Patient> listPatientByPhOrName(String phNo, String patientName) {
//	    return patientrepo.listPatientByPhOrName(phNo, patientName);
//	}

	@Transactional
	    public List<Patient> searchPatientByNameOrPhone(String searchTerm) {
	        return patientrepo.searchPatientByNameOrPhone(searchTerm);
	    }

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointrepo.save(appointment);
	}

	@Override
	public List<DoctorSlotAppointments> getDashboardDetails(int departnemtnId, String date) {

		List<DoctorSlotAppointments> returnList = new ArrayList<>();
		try {

			List<Doctor> doctorlist = recepdpctorrepo.getdoctorfromdepartmentid(departnemtnId); // getdoctorfromdepartmentid;

			for (Doctor doctor : doctorlist) {
				DoctorSlotAppointments doctorSlotAppointment = new DoctorSlotAppointments();
				doctorSlotAppointment.setDoctor(doctor);
				doctorSlotAppointment
						.setDoctorSlotAppointments(patientrepo.getDoctorSlotDetails(date, doctor.getDoctorId())); // next
				// query
				returnList.add(doctorSlotAppointment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}

	@Override
	public List<Appointment> getAppointmnets() {

		return (List<Appointment>) appointrepo.findAll();

	}

	@Override
	public List<Department> getDepartments() {
		return (List<Department>) recepdepartmnetrepo.findAll();
		
	}

	@Override
	public Appointment getAppointment(int id) {
	return appointrepo.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found  for id" + id));

	}

}
