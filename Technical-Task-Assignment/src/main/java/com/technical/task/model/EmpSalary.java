package com.technical.task.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="emp_salary")
public class EmpSalary {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@JsonIgnore
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="employee_salary")
	private Double employeeSalary;
	
	@Column(name="month")
	private String month;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employee_id",referencedColumnName = "employee_id")
	private Employee employeeId;
	


	

}
