package com.technical.task.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
public class Employee {
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	
	public List<EmpSalary> getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(List<EmpSalary> empSalary) {
		this.empSalary = empSalary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_age")
	private Integer employeeAge;
	
	@OneToMany(mappedBy = "employeeId",cascade = CascadeType.ALL)
	private List<EmpSalary> empSalary;



}
