package com.alighthub.dms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.alighthub.dms.model.Admin;

/*
 * 
 * @author Ravindra Sonawane
 * @page Admin Dao
 * @time 08/09/2019 - 9.05 PM
 * @purpose To controll admin dao
 * 
 *
 */
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	@Query(name = "findByLoginId")
	public Admin findByLoginId(int id,String type);
	
	@Query("from Admin a left outer join Login l on a.login=l.loginId where l.loginuname=:uname AND l.loginpassword=:pass")
	public Admin findByUnameAndPass(String uname,String pass);
	
	public List<Admin> findByAdminFnameOrAdminLname(String fname,String Lname);
	
	
	@Query("from Admin a right outer join Login l on a.login=l.loginId where l.loginuname=:uname")
	public Admin findByLoginuname(String uname);
}
