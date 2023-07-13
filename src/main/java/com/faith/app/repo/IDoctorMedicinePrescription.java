package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.MedicnePrescription;

public interface IDoctorMedicinePrescription extends CrudRepository<MedicnePrescription, Integer>{



	@Query("FROM MedicnePrescription WHERE appointment.patientId = ?1 AND appointment.appointmentDateTime != CURRENT_DATE")
	List<MedicnePrescription> getMedicnePrescription(int patientId);

	@Query("from MedicnePrescription where appointmentId=?1")
	List<MedicnePrescription> getMedicinePrescriptionAppointment(int appointmentId);


}
