package com.faith.app.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	// disable patient

	@Modifying

	@Query("UPDATE Patient c SET c.isActive = false WHERE c.patientId = :id")

	public void disable(@Param("id") int id);

	// serach by phone_no or patient name

//	 @Query("FROM Patient WHERE phNo = :phNo OR patientName = :patientName")
//	 public List<Patient> listPatientByPhOrName(@Param("phNo") String phNo, @Param("patientName") String patientName);

	@Query("FROM Patient WHERE phNo LIKE %:searchTerm% OR patientName LIKE %:searchTerm%")
	public List<Patient> searchPatientByNameOrPhone(@Param("searchTerm") String searchTerm);

	// list by is_Active

	@Query("FROM Patient WHERE isActive=true ")
	public List<Patient> listIsActive();

	@Query(value = "select  das.*,patient_name as patientName,p.patient_reg_no,"
			+ " a.appointment_id from doctor_available_slots das"
			+ " left join appointment a on a.doctor_id=das.doctor_Id"
			+ " and concat(?,' ',das.time)= appointment_date_time"
			+ " left join patient p on p.patient_Id=a.patient_id where das.doctor_Id=?;", nativeQuery = true)
	public List<Map<String, Object>> getDoctorSlotDetails(String date, int doctorId);

	@Query(value = "select patient_bill_appointment_id from patient_bill_appointment pa"
			+ " inner join appointment a on a.appointment_id=pa.appointment_Id"
			+ " where a.patient_id=:patientId and date(a.appointment_date_time)>=date(date_add(:date, interval -7 day)) limit 1;", nativeQuery = true)
	public int hasPaidAppointmentBillForLastNDays(@Param("patientId") int patientId,@Param("date") LocalDateTime date);

	@Query(value = "select patient_bill_registration_id from patient_bill_registration pr"
			+ " inner join patient_bill pb on pb.patient_bill_id=pr.patient_bill_id"
			+ " where pb.patient_id=:patientId "
			+ " and date(pr.date_time)>=date(date_add(utc_timestamp(), interval -6 month)) limit 1;", nativeQuery = true)
	public int hasPaidRegistractionBillForLastNDays(@Param("patientId") int patientId);
	
	@Query(value = "select patient_bill_id from patient_bill pb where patient_Id=:patientId order by patient_bill_id desc limit 1;", nativeQuery = true)
	public int lastInsertedBillIdOfPatient(@Param("patientId") int patientId);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `patient_bill` (`bill_generated_time`,"
			+ "  `patient_id`, `is_paid`) VALUES (utc_timestamp(), :patientId, '0')", nativeQuery = true)
	public int insertPatientBill(@Param("patientId") int patientId);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `patient_bill_registration` (`patient_bill_id`,"
			+ " `date_time`, `amount`) VALUES (:patientBillId, utc_timestamp(), :billAmount);", nativeQuery = true)
	public int insertPatientBillRegistraction(@Param("patientBillId") int patientBillId,
			@Param("billAmount") int billAmount);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `patient_bill_appointment` (`patient_bill_id`, `appointment_id`,"
			+ " `amount`) VALUES (:patientBillId, :appointmentId, :billAmount);", nativeQuery = true)
	public int insertPatientBillAppointment(@Param("patientBillId") int patientBillId,
			@Param("appointmentId") int appointmentId, @Param("billAmount") Double billAmount);

	@Query(value = "select pb.*,coalesce(pr.amount,0) as registractionBillAmount, "
			+ " coalesce(pa.amount,0) as appointmentBillAmount,"
			+ " (coalesce(pr.amount,0)+ coalesce(pa.amount,0)) as totalAmount from patient_bill pb "
			+ " left join patient_bill_registration pr on pr.patient_bill_id=pb.patient_bill_id"
			+ " left join patient_bill_appointment pa on pa.patient_bill_id=pb.patient_bill_id"
			+ " where pb.patient_bill_id=:patientBillId and pb.is_paid=0;", nativeQuery = true)
	public Map<String, Object> getFinalBill(@Param("patientBillId") int patientBillId);
	
	@Query(value = "select pb.*,coalesce(pr.amount,0) as registractionBillAmount, " + 
			" coalesce(pa.amount,0) as appointmentBillAmount," + 
			" (coalesce(pr.amount,0)+ coalesce(pa.amount,0)) as totalAmount from patient_bill pb " + 
			" inner join patient_bill_appointment pa on pa.patient_bill_id=pb.patient_bill_id" + 
			" left join patient_bill_registration pr on pr.patient_bill_id=pb.patient_bill_id" + 
			" where pa.appointment_id=:appointmentId and pb.is_paid=0;", nativeQuery = true)
	public Map<String, Object> getPendingBillForAppointment(@Param("appointmentId") int appointmentId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE `patient_bill` SET `is_paid` = '1' WHERE (`patient_bill_id` =:patientBillId)", nativeQuery = true)
	public int markBillPaid(@Param("patientBillId") int patientBillId);
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	
}
