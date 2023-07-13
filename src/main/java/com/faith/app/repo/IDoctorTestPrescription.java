package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.TestPrescription;

public interface IDoctorTestPrescription extends CrudRepository<TestPrescription, Integer>{



	@Query("FROM TestPrescription WHERE appointment.patientId = ?1 AND appointment.appointmentDateTime != CURRENT_DATE")
	List<TestPrescription> getLabPrescription(int patientId);

	@Query("from TestPrescription where appointmentId=?1")
	List<TestPrescription> getlabPrescriptionAppointment(int appointmentId);

	@Query("from TestPrescription where testPrescriptionId=?1")
	List<TestPrescription> getTestPrescriptionReport(int id);

}
