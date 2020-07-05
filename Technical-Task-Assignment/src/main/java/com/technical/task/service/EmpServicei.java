package com.technical.task.service;

import java.util.List;

import com.technical.task.dtos.EmployeeDto;
import com.technical.task.model.Employee;

public interface EmpServicei {
	
	// add Employee Details
	EmployeeDto addEmployeeDetails(Employee employee);
	
	// get Employee Details
    EmployeeDto	getEmployeeDetailsById(Integer employeeId);
    
    // delete Employee by employee id
    void deleteEmployeeDetailsById(Integer employeeId);
    
    //update employee By employee id
    EmployeeDto updateEmployeeDetails(Employee employee);
    
    //get All List of Employee
    List<Object[]> getAllEmployeeDetails();
    
    EmployeeDto findEmployeeByNameAndSalary(String employeeName,double salary);
    
}
