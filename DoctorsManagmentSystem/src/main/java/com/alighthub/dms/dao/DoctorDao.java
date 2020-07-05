package com.alighthub.dms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alighthub.dms.model.Doctor;

/*
 * 
 * @author Ravindra Sonawane
 * @page Doctor Dao
 * @time 08/09/2019 - 9.20 PM
 * @purpose To controll doctor dao
 * 
 *
 */
@Repository
public interface DoctorDao extends JpaRepository<Doctor,Integer>{

}
