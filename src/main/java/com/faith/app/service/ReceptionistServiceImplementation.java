package com.faith.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.DTO.DoctorSlotAppointments;
import com.faith.app.common.APIResponse;
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

	@Autowired
	RecepDepartmentRepository recepdepartmnetrepo;

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

	@Override
	public APIResponse generateBill(int appointmentId) {
		try {

			try {
				Map<String, Object> billData = patientrepo.getPendingBillForAppointment(appointmentId);
				if (billData != null && !billData.isEmpty()) {
					return new APIResponse(true, "", billData);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			int patientBillId = 0;
			int patientBillReg = 0;
			int patientBillApp = 0;
			Appointment appointment = appointrepo.findById(appointmentId)
					.orElseThrow(() -> new RuntimeException("Appointment not found  for id" + appointmentId));

			try {
				patientBillReg = patientrepo.hasPaidRegistractionBillForLastNDays(appointment.getPatientId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				patientBillApp = patientrepo.hasPaidAppointmentBillForLastNDays(appointment.getPatientId(),
						appointment.getAppointmentDateTime());
			} catch (Exception e) {
			}
			System.out.println("patientBillReg : " + patientBillReg);
			System.out.println("patientBillApp : " + patientBillApp);
			if (patientBillReg == 0) {
				if (patientBillId == 0) {
					patientrepo.insertPatientBill(appointment.getPatientId());
					patientBillId = patientrepo.lastInsertedBillIdOfPatient(appointment.getPatientId());
				}
				patientBillReg = patientrepo.insertPatientBillRegistraction(patientBillId, 200);
			}

			if (patientBillApp == 0) {
				if (patientBillId == 0) {
					patientrepo.insertPatientBill(appointment.getPatientId());
					patientBillId = patientrepo.lastInsertedBillIdOfPatient(appointment.getPatientId());
				}
				patientBillApp = patientrepo.insertPatientBillAppointment(patientBillId, appointmentId,
						appointment.getDoctor().getConsultationFee());
			}
			System.out.println("patientBillReg final : " + patientBillReg);
			System.out.println("patientBillApp final : " + patientBillApp);

			Map<String, Object> billData = null;
			try {
				billData = patientrepo.getFinalBill(patientBillId);
			} catch (Exception e) {
			}
			String message = null;
			if (billData != null && !billData.isEmpty()) {
				message = "";
			} else {
				message = "No Pending Bills";
			}
			return new APIResponse(true, message, billData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new APIResponse(false, "Something went wrong");
	}

	@Override
	public APIResponse markBillPaid(int patientBillId) {
		try {
			patientrepo.markBillPaid(patientBillId);
			return new APIResponse(true, "Bill Paid");
		} catch (Exception e) {
		}
		return new APIResponse(false, "Something went wrong");
	}

	@Override
	public APIResponse cancelAppointment(int appointmentId) {
		try {
			Appointment appointment = appointrepo.findById(appointmentId)
					.orElseThrow(() -> new RuntimeException("Appointment not found  for id" + appointmentId));
			appointrepo.delete(appointment);
			return new APIResponse(true, "Appointment Cancelled");
		} catch (Exception e) {
		}
		return new APIResponse(false, "Something went wrong");
	}

}
