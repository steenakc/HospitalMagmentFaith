package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Doctor;

@Repository
public interface ReceptionistDoctorRepository extends CrudRepository<Doctor, Integer> {

	@Query("from Doctor WHERE dept_id=?1")
	public List<Doctor> getdoctorfromdepartmentid(int deptId);

}
