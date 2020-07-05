package com.technical.task.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technical.task.model.EmpSalary;

import lombok.Getter;
import lombok.Setter;

public class EmployeeDto implements Serializable {

	private Integer employeeId;
	private String employeeName;
	private Integer employeeAge;
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
	private List<EmpSalary> empSalary;

}
