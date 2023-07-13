package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineStock;

public interface IMedicine extends CrudRepository<Medicine, Integer>{

	@Query("FROM Medicine WHERE isActive=true")
	public List<Medicine> listbyActive();
	
	@Modifying
    @Query("UPDATE Medicine c SET c.isActive = false WHERE c.medicineId = :id")
    public void disablemedicine(@Param("id") int id);
	
	@Query("from Medicine where medicineId=?1")
	public Medicine getmedicineById(int medicineId);
}
