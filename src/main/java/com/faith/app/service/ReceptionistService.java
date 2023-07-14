package com.faith.app.service;

import java.util.List;

import com.faith.app.DTO.DoctorSlotAppointments;
import com.faith.app.common.APIResponse;
import com.faith.app.entity.Appointment;
import com.faith.app.entity.Department;
import com.faith.app.entity.Patient;

public interface ReceptionistService {

	// insert Patient
	public Patient savePatient(Patient patient);

	// list Patient
	public List<Patient> getPatients();

	// list by id
	public Patient getPatient(int id);

	// list apppointment by id

	public Appointment getAppointment(int id);

	// list by isActive
	public List<Patient> listPatinetByISActive();

	// delete Patient
	public void deletePatient(int id);

	// list patient by name or phone number

	public List<Patient> searchPatientByNameOrPhone(String searchTerm);

	// List Departments
	public List<Department> getDepartments();

	// Add Appointment

	public Appointment saveAppointment(Appointment appointment);

	// list appointments

	public List<Appointment> getAppointmnets();

	// list apppointments in dashboard

	public List<DoctorSlotAppointments> getDashboardDetails(int departnemtnId, String date);

	public APIResponse generateBill(int appointmentId);

	public APIResponse markBillPaid(int patientBillId);

	public APIResponse cancelAppointment(int appointmentId);

}
