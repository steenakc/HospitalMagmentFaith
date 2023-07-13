package com.faith.app.DTO;

import java.util.List;
import java.util.Map;

import com.faith.app.entity.Doctor;

public class DoctorSlotAppointments {

	Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	List<Map<String, Object>> doctorSlotAppointments;

	public DoctorSlotAppointments() {
		super();
	}

	public List<Map<String, Object>> getDoctorSlotAppointments() {
		return doctorSlotAppointments;
	}

	public void setDoctorSlotAppointments(List<Map<String, Object>> doctorSlotAppointments) {
		this.doctorSlotAppointments = doctorSlotAppointments;
	}

}
