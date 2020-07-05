package com.alighthub.dms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alighthub.dms.model.Admin;
import com.alighthub.dms.model.Employee;

/*
 * 
 * @author Ravindra Sonawane
 * @page Employee Dao
 * @time 08/09/2019 - 9.20 PM
 * @purpose To controll employee dao
 * 
 *
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{

	@Query("from Employee a left outer join Login l on a.login=l.loginId where l.loginuname=:uname AND l.loginpassword=:pass")
	public Employee findByUnameAndPass(String uname,String pass);
}
