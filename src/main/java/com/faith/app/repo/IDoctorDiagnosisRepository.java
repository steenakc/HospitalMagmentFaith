package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Diagnosis;

public interface IDoctorDiagnosisRepository extends CrudRepository<Diagnosis, Integer>{
	@Query("from Diagnosis where patientId=?1")
	List<Diagnosis> getDiagnosis(int patientId);

	

}
