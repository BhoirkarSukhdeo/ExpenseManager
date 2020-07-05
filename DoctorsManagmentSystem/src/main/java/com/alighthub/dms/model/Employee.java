package com.alighthub.dms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * 
 * @author Ravindra Sonawane
 * @page Employee
 * @time 08/09/2019 - 9.05 PM
 * @purpose We have created employee POJO and it will manage Doctor/Nurse/Student
 * 
 * 
 *
 */
@Entity
@Table(name="Employee")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="Employee_Id")
private int employeeId;
@Column(name="Employee_Fname")
private String employeeFname;

@Column(name="Employee_Lname")
private String employeeLname;

@Column(name="Employee_Email")
private String employeeEmail;


@Column(name="Employee_MObileNo")
private int employeeMobileNo;

@Column(name="Employee_Status")
private String employeeStatus;
@Column(name="Employee_JoiningDate")
private String employeeJoiningDate;

@Column(name="Employee_Role")
private String employeeRole;
@Column(name="Employee_Gender")
private String employeeGender;
/*@Column(name="Employee_DOB")
private String employeeDob;*/
@Column(name="Employee_Salary")
private double employeeSalary;

@OneToMany(cascade=CascadeType.ALL)
private List<Doctor> doctorList=new ArrayList<Doctor>();

@OneToOne(cascade=CascadeType.ALL)
/*@Column(name="Login_Details")*/
private Login login;


@OneToOne(cascade=CascadeType.ALL)
/*@Column(name="Address_Details")*/
private Address address;


/*@ManyToOne(cascade=CascadeType.ALL)
private Admin admin;*/

@OneToMany(cascade=CascadeType.ALL)
private List<Doctor> docList=new ArrayList<>();



public int getEmployeeId() {
	return employeeId;
}

public String getEmployeeFname() {
	return employeeFname;
}

public String getEmployeeLname() {
	return employeeLname;
}

public String getEmployeeEmail() {
	return employeeEmail;
}

public int getEmployeeMobileNo() {
	return employeeMobileNo;
}

public String getEmployeeStatus() {
	return employeeStatus;
}

public String getEmployeeJoiningDate() {
	return employeeJoiningDate;
}

public String getEmployeeRole() {
	return employeeRole;
}

public String getEmployeeGender() {
	return employeeGender;
}

public double getEmployeeSalary() {
	return employeeSalary;
}

public List<Doctor> getDoctorList() {
	return doctorList;
}

public Login getLogin() {
	return login;
}

public Address getAddress() {
	return address;
}



public List<Doctor> getDocList() {
	return docList;
}



public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}

public void setEmployeeFname(String employeeFname) {
	this.employeeFname = employeeFname;
}

public void setEmployeeLname(String employeeLname) {
	this.employeeLname = employeeLname;
}

public void setEmployeeEmail(String employeeEmail) {
	this.employeeEmail = employeeEmail;
}

public void setEmployeeMobileNo(int employeeMobileNo) {
	this.employeeMobileNo = employeeMobileNo;
}

public void setEmployeeStatus(String employeeStatus) {
	this.employeeStatus = employeeStatus;
}

public void setEmployeeJoiningDate(String employeeJoiningDate) {
	this.employeeJoiningDate = employeeJoiningDate;
}

public void setEmployeeRole(String employeeRole) {
	this.employeeRole = employeeRole;
}

public void setEmployeeGender(String employeeGender) {
	this.employeeGender = employeeGender;
}

public void setEmployeeSalary(double employeeSalary) {
	this.employeeSalary = employeeSalary;
}

public void setDoctorList(List<Doctor> doctorList) {
	this.doctorList = doctorList;
}

public void setLogin(Login login) {
	this.login = login;
}

public void setAddress(Address address) {
	this.address = address;
}

public void setDocList(List<Doctor> docList) {
	this.docList = docList;
}



/*@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
private List<Nurse> nurseList=new ArrayList<>();

@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
private List<Student> studentList=new ArrayList<>();*/
}
