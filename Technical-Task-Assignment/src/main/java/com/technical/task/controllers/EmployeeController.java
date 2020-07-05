package com.technical.task.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technical.task.daos.EmpDao;
import com.technical.task.dtos.EmployeeDto;
import com.technical.task.exceptions.ResouceNotFoundException;
import com.technical.task.model.Employee;
import com.technical.task.service.EmpServicei;



@RestController
@RequestMapping("/employee_controller")
public class EmployeeController {
	
	@Autowired
	private EmpDao em;
	
	@Autowired
	private EmpServicei empService;
	
	private static final Logger LOG = LogManager.getLogger(EmployeeController.class);
	
	// Add Employee Details
	
	@PostMapping("/add_employee")
	public ResponseEntity<EmployeeDto> addEmployeeDetails(@RequestBody Employee employee){
		try{
			LOG.info("In the EmployeeController Controller Of Add Employee details method");
			EmployeeDto response=empService.addEmployeeDetails(employee);
			return ResponseEntity.ok().body(response);
			}
			catch(Exception e) {
			LOG.error("Excpeton occurs in EmployeeController adding Employee " + e);
			throw new ResouceNotFoundException("something went wrong When Add Employee Details");
			}
	}
	
	@GetMapping("/get_employee")
	public ResponseEntity<EmployeeDto> getEmployeeDetailsById(@RequestParam(value = "employeeId", required = true) Integer employeeId) {
		LOG.info("In the EmployeeController Controller Of get All Employee details method");
		
			if(employeeId!=null){
				try {
				EmployeeDto emp=empService.getEmployeeDetailsById(employeeId);
				return new ResponseEntity<EmployeeDto>(emp,HttpStatus.OK);
				}
				catch(Exception e) {
					throw new ResouceNotFoundException("Employee Id Does Not Exist");
				}
			}
			else{
				LOG.info("In the EmployeeController Controller Of get All Employee details");
				throw new ResouceNotFoundException("please Enter Employee Id");
			}
		}
	
	@DeleteMapping("/delete_employee")
	public ResponseEntity<String> deleteEmployeeById(@RequestParam(value = "employeeId", required = true) Integer employeeId) {
		LOG.info("In Employee Controller ,deleteEmployeeById method");
			if(employeeId!=null){
				try {
				empService.deleteEmployeeDetailsById(employeeId);
				return new ResponseEntity<String>("delete successfully",HttpStatus.OK);
			}catch(Exception e) {
				throw new ResouceNotFoundException("Employee Id Does Not Exist");
			}
		 }
			else {
				throw new ResouceNotFoundException("Please Enter Employee Id");
			}
		}
		
	
	
	@PutMapping(value="/update_employee")
	public ResponseEntity<EmployeeDto> updateEmployeeDetails(@RequestBody Employee employee) {
	
		try{
			LOG.info("In the EmployeeController Controller Of update Employee details method");
			EmployeeDto response=empService.updateEmployeeDetails(employee);
			return ResponseEntity.ok().body(response);
			}
			catch(Exception e) {
			LOG.error("Excpeton occurs in EmployeeController adding Employee " + e);
			throw new ResouceNotFoundException("something went wrong When update Employee Details");
			}
	}
 
	@GetMapping("/get")
	public List<Object[]> getEmployee(){
		try {
		LOG.error("In EmployeeEontroller getEmployee method");
		return em.getAllEmployee();
		}
		catch (Exception e) {
			throw new ResouceNotFoundException("Empty List");
		}
	}

	@GetMapping("/get_employeeby_salary")
	public EmployeeDto findByNameAndSalary(@RequestParam(value = "employeeName", required = true) String employeeName,
			@RequestParam(value = "employeeSalary", required = true) double employeeSalary){
		
		return empService.findEmployeeByNameAndSalary(employeeName, employeeSalary);
	}
}
