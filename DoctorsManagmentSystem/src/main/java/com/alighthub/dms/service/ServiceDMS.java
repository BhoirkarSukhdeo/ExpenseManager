package com.alighthub.dms.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.alighthub.dms.model.Admin;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.model.Feedback;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.model.Student;

/*
 * 
 * @author Ravindra Sonawane
 * @page Service Interface
 * @time 08/09/2019 - 9.20 PM
 * @purpose To create all abstract methods
 * 
 *
 */

public interface ServiceDMS {
	
	void addData(Admin admin);
	Admin displayAdmin(String loginuname,String loginpassword);
	public Admin displayAdminData(String loginuname, String loginpassword);
	public Admin editAdminData(int adminId);
	public Admin upadateAdminData(Admin admin);
	public List<Admin> findByAdminFnameOrAdminLname(String fname,String Lname);
	public Login getLoginUnameAndPassword(String uname,String password);
	Login getLoginUname(String uname);
	public List<Employee> getAllEmployee();
	public Admin findByLoginuname(String uname);
	
	public void addFeed(Feedback feed);
	public List<Feedback> getFeed();
	public Student addStudent(Student std);
	public long getEmpCount();
	
	public long getStudCount();
	
	public long getDoctorCount();
	
	public long getNurseCount();
	public List<Student> get();
	
	public Employee updateEmployee(Employee employee);
	Employee getEmployeeData(String loginuname, String loginpassword);
	List<Employee> deleteEmployee(int id);
	
}
