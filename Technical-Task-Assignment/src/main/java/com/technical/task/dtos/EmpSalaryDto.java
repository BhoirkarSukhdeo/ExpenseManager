package com.technical.task.dtos;

import com.technical.task.model.Employee;

import lombok.Getter;
import lombok.Setter;


public class EmpSalaryDto {

	private Integer id;
	private double employeeSalary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Employee getEmployee() {
		return employeeId;
	}
	public void setEmployee(Employee employee) {
		this.employeeId = employee;
	}
	private String month;
	private Employee employeeId;
	
	
}
