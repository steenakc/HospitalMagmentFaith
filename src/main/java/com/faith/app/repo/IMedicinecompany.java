package com.faith.app.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.MedicineCompany;

public interface IMedicinecompany extends CrudRepository<MedicineCompany, Integer>{
	
	@Modifying
    @Query("UPDATE MedicineCompany c SET c.isActive = false WHERE c.medicneCompanyId = :id")
    public void disablecompany(@Param("id") int id);


}
