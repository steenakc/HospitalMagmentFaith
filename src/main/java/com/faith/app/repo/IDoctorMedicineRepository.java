package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Medicine;

public interface IDoctorMedicineRepository extends CrudRepository<Medicine, Integer>{

}
