package com.alighthub.dms.serviceimpl;


import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alighthub.dms.dao.AdminDao;
import com.alighthub.dms.dao.DaoFeed;
import com.alighthub.dms.dao.DoctorDao;
import com.alighthub.dms.dao.EmployeeDao;
import com.alighthub.dms.dao.LoginDao;
import com.alighthub.dms.dao.NurseDao;
import com.alighthub.dms.dao.StudentDao;
import com.alighthub.dms.model.Admin;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.model.Feedback;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.model.Student;
import com.alighthub.dms.service.ServiceDMS;

/*
 * 
 * @author Ravindra Sonawane
 * @page Service Implimentation
 * @time 08/09/2019 - 9.20 PM
 * @purpose To impliment all Service methods
 * 
 *
 */
@Service
public class ServiceImplimentation implements ServiceDMS{
	@Autowired
    private DaoFeed feeddao;
     
	@Autowired
	private StudentDao std;
	@Autowired
	private AdminDao admindao;
	@Autowired
	private LoginDao logindao;
    @Autowired
    private EmployeeDao empDao;
    
    @Autowired
    private NurseDao nurse;
    
    @Autowired
    private StudentDao stud;
    
    @Autowired
    private DoctorDao  doct;
    
    
	@Override
	public void addData(Admin admin) {
		
		admindao.save(admin);
		
	}

	@Override
	public Admin displayAdmin(String loginuname, String loginpassword) {
          
		
		return admindao.findByUnameAndPass(loginuname, loginpassword);
      	}
     
      public Admin displayAdminData(String loginuname, String loginpassword) {
  		Login l=logindao.findByLoginunameAndLoginpassword(loginuname, loginpassword);
  		System.out.println(l.getLoginuname()+"\t"+l.getLoginpassword());
  		
        return   admindao.findByLoginId(l.getLoginId(),l.getLoginType());
	 }

	@Override
	public Admin editAdminData(int adminId) {
		
		return admindao.findById(adminId).get();
	}

	@Override
	public Admin upadateAdminData(Admin admin) {
		
		return admindao.saveAndFlush(admin);
	}

	@Override
	public List<Admin> findByAdminFnameOrAdminLname(String fname, String Lname) {
	
		return admindao.findByAdminFnameOrAdminLname(fname, Lname);
	}

	@Override
	public Login getLoginUnameAndPassword(String uname, String password) {
		
		return logindao.findByLoginunameAndLoginpassword(uname,password);
	}

	@Override
	public Login getLoginUname(String uname) {
		
		return logindao.findByLoginuname(uname);
	}

	@Override
	public Admin findByLoginuname(String uname) {
		
		return admindao.findByLoginuname(uname);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empDao.findAll();
	}

	@Override
	public void addFeed(Feedback feed) {
		 
		feeddao.save(feed);
	}

	@Override
	public List<Feedback> getFeed() {
		
		return feeddao.findAll();
	}

	@Override
	public long getEmpCount() {
		
		return empDao.count();
	}

	@Override
	public long getStudCount() {
		
		return stud.count();
	}

	@Override
	public long getDoctorCount() {
		
		return doct.count();
	}

	@Override
	public long getNurseCount() {
		
		return nurse.count();
	}

	@Override
	public List<Student> get() {
		
		return std.findAll();
	}

	@Override
	public Student addStudent(Student std) {
		
		return stud.save(std);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return empDao.save(employee);
	}

	@Override
	public Employee getEmployeeData(String loginuname, String loginpassword) {
		
		return empDao.findByUnameAndPass(loginuname, loginpassword);
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		empDao.deleteById(id);
		return empDao.findAll();
	}
	
}
