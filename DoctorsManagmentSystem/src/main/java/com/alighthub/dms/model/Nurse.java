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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * 
 * @author Ravindra Sonawane
 * @page Nurse
 * @time 08/09/2019 - 9.05 PM
 * @purpose We have created nurse POJO it wont have any relationship 
 *  with student...... 
 * 
 *
 */
@Entity
@Table(name="Nurse")

public class Nurse {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Nurse_Id")
private int nurseId;
@Column(name="Nurse_Fname")
private String nurseFname;
@Column(name="Nurse_Lname")
private String nurseLname;
@Column(name="Nurse_Email")
private String nurseEmail;

@Column(name="Nurse_MobileNo")
private int nurseMobileNo;

@Column(name="Nurse_Status")
private String nurseStatus;

@Column(name="Nurse_Role")
private String nurseRole;

@Column(name="Nurse_Gender")
private String nurseGenader;


/*@Column(name="Nurse_Department")
private String nurseDepartment;*/

public int getNurseId() {
	return nurseId;
}

public String getNurseFname() {
	return nurseFname;
}

public String getNurseLname() {
	return nurseLname;
}

public String getNurseEmail() {
	return nurseEmail;
}

public int getNurseMobileNo() {
	return nurseMobileNo;
}

public String getNurseStatus() {
	return nurseStatus;
}

public String getNurseRole() {
	return nurseRole;
}

public String getNurseGenader() {
	return nurseGenader;
}

public Address getAddress() {
	return address;
}

public Login getLogin() {
	return login;
}





public void setNurseId(int nurseId) {
	this.nurseId = nurseId;
}

public void setNurseFname(String nurseFname) {
	this.nurseFname = nurseFname;
}

public void setNurseLname(String nurseLname) {
	this.nurseLname = nurseLname;
}

public void setNurseEmail(String nurseEmail) {
	this.nurseEmail = nurseEmail;
}

public void setNurseMobileNo(int nurseMobileNo) {
	this.nurseMobileNo = nurseMobileNo;
}

public void setNurseStatus(String nurseStatus) {
	this.nurseStatus = nurseStatus;
}

public void setNurseRole(String nurseRole) {
	this.nurseRole = nurseRole;
}

public void setNurseGenader(String nurseGenader) {
	this.nurseGenader = nurseGenader;
}

public void setAddress(Address address) {
	this.address = address;
}

public void setLogin(Login login) {
	this.login = login;
}






@OneToOne(cascade=CascadeType.ALL)
/*@Column(name="Address_Details")*/
private Address address;

@OneToOne(cascade=CascadeType.ALL)
/*@Column(name="Login_Details")*/
private Login login;



}
