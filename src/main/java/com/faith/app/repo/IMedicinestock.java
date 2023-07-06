package com.faith.app.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.MedicineStock;

public interface IMedicinestock extends CrudRepository<MedicineStock, Integer>{
	
	@Modifying
    @Query("UPDATE MedicineStock c SET c.isActive = false WHERE c.medicineStockId = :id")
    public void disablemedicinestock(@Param("id") int id);

}
