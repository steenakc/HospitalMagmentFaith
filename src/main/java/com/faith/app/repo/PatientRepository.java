package com.faith.app.repo;

import java.util.List;

import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.Patient;

public interface PatientRepository  extends CrudRepository<Patient, Integer>{
	
	//disable patient
	
	 @Modifying

	    @Query("UPDATE Patient c SET c.isActive = false WHERE c.patientId = :id")

	   public  void disable(@Param("id") int id);
	 
	 //serach by phone_no or patient name
	 

	 
//	 @Query("FROM Patient WHERE phNo = :phNo OR patientName = :patientName")
//	 public List<Patient> listPatientByPhOrName(@Param("phNo") String phNo, @Param("patientName") String patientName);

	 
	 @Query("FROM Patient WHERE phNo LIKE %:searchTerm% OR patientName LIKE %:searchTerm%")
	 public List<Patient> searchPatientByNameOrPhone(@Param("searchTerm") String searchTerm);

	 
	 //list by is_Active
	 
	 @Query("FROM Patient WHERE isActive=true " )
	 public List<Patient> listIsActive();
	 
	 @Query(value = "select  das.*,patient_name as patientName,p.patient_reg_no,"
				+ " a.appointment_id from doctor_available_slots das"
				+ " left join appointment a on a.doctor_id=das.doctor_Id"
				+ " and concat(?,' ',das.time)= appointment_date_time"
				+ " left join patient p on p.patient_Id=a.patient_id where das.doctor_Id=?;", nativeQuery = true)
		public List<Map<String, Object>> getDoctorSlotDetails(String date, int doctorId);
	 
	


}
