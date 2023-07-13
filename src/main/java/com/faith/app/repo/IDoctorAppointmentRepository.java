package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Appointment;

public interface IDoctorAppointmentRepository extends CrudRepository<Appointment, Integer>{
	@Query("from Appointment where doctor.user.userId=?1 and doctorStatus=true and appointmentDateTime=current_date()")
	List<Appointment> getTodaysPatients(int userId);
	
	@Modifying
	@Query("UPDATE Appointment c SET c.doctorStatus = false WHERE c.appointmentId = :id")
	void disablePatient(int id);

	
	
	



}
