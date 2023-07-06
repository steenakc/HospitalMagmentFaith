package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

}
