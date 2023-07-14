package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.LabTest;

@Repository
public interface ILabTestRepository extends CrudRepository<LabTest,Integer>{

	
	
	@Query("from LabTest where testName like %?1%")
	public List<LabTest> findByTestName(String name);

	@Modifying
	@Query("UPDATE LabTest  c SET c.isActive=false WHERE c.labTestId=:id")
	public void disabletest(@Param("id") int id);
	
	@Query("From LabTest WHERE isActive=true")
	public List<LabTest> listIsActive();
	
	
	@Query("from LabTest where labTestId=?1")
	public LabTest gettestbyId(int labTestId);
	

}
