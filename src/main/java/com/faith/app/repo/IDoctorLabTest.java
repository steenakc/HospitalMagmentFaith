package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.LabTest;

public interface IDoctorLabTest extends CrudRepository<LabTest, Integer> {

}
