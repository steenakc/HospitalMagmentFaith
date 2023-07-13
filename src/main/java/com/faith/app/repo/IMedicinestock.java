package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faith.app.entity.MedicineStock;
import com.faith.app.entity.MedicnePrescription;

public interface IMedicinestock extends CrudRepository<MedicineStock, Integer>{
	
	@Modifying
    @Query("UPDATE MedicineStock c SET c.isActive = false WHERE c.medicineStockId = :id")
    public void disablemedicinestock(@Param("id") int id);

	@Modifying
    @Query(value = "UPDATE MedicineStock ms SET ms.purchasedCount = ms.noOfBoxes * ms.unitPerBox WHERE ms.medicineStockId = :id")
	public void updatePurchasedCountById(@Param("id") Integer id);
	
	@Query("from MedicineStock where medicineId=?1")
	public MedicineStock getmedicineById(int medicineId);
	
	@Query("FROM MedicineStock WHERE isActive=true")
	public List<MedicineStock> listbyActive();
	
	
	@Query("from MedicineStock where medicineStockId=?1")
	public MedicineStock getmedicineStockId(int medicineStockId);
}
