package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.LabTest;
import com.faith.app.entity.TestPrescription;

@Repository
public interface ILabTestPrescriptionRepository extends CrudRepository<TestPrescription,Integer>{
	
	@Query("from TestPrescription where appointmentId=?1")
	public List<TestPrescription>getTestPrescriptionHistory(Integer patientId);
	
	@Query("from TestPrescription where testPrescriptionId=?1")
	public TestPrescription gettestbyId(int testPrescriptionId);

}