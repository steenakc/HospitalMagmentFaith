package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineCompany;
import com.faith.app.entity.MedicineStock;

public interface IMedicinecompany extends CrudRepository<MedicineCompany, Integer>{
	
	@Modifying
    @Query("UPDATE MedicineCompany c SET c.isActive = false WHERE c.medicneCompanyId = :id")
    public void disablecompany(@Param("id") int id);

	@Query("FROM MedicineCompany WHERE isActive=true")
	public List<MedicineCompany> listbyActive();

	@Query("from MedicineCompany where medicneCompanyId=?1")
	public MedicineCompany getmedicineCompanyById(int medicneCompanyId);
}
