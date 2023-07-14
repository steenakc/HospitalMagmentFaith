package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.MedicnePrescription;

public interface IMedicineprescription extends CrudRepository<MedicnePrescription, Integer>{

	@Modifying
    @Query("UPDATE MedicnePrescription c SET c.isActive = false WHERE c.medicnePrescriptionId = :id")
    public void disablemedicineprescription(@Param("id") int id);
	
	@Query("from MedicnePrescription where appointmentId=?1")
	public List<MedicnePrescription> getmedicinePrescribe(int appointmentId);
	
	@Modifying
    @Query("UPDATE MedicnePrescription c SET c.pharmaStatus = false WHERE c.appointmentId = :id")
    public void disablepharmaStatus(@Param("id") int id);
	
	@Query("from MedicnePrescription where pharmaStatus=true")
	public List<MedicnePrescription> displayByPharma();
}
