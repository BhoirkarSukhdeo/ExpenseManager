package com.technical.task.serviceimp;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.task.daos.EmpDao;
import com.technical.task.dtos.EmployeeDto;
import com.technical.task.exceptions.ResouceNotFoundException;
import com.technical.task.model.Employee;
import com.technical.task.service.EmpServicei;
@Service
public class EmpServiceImp implements EmpServicei{

	@Autowired
	private EmpDao empdao;
	@Autowired
	private ModelMapperService modelMapperService;
	
	private static final Logger LOG = LogManager.getLogger(EmpServiceImp.class);
	
	@Override
	public EmployeeDto addEmployeeDetails(Employee employee) {
		if(empdao.existsById(employee.getEmployeeId())) {
			LOG.info("EmpServiceImp class AddEmployeeDetails Method");
			throw new ResouceNotFoundException("EmployeeId id is already Exists,Want Unique user id");
		}
		else {
			Employee emp=empdao.save(employee);
			return modelMapperService.mappedToEmployeeDto(emp);
		}
	}

	@Override
	public EmployeeDto getEmployeeDetailsById(Integer employeeId) {
		
		Boolean empExist=empdao.existsById(employeeId);
		if(empExist) {
		Employee emp=empdao.findById(employeeId).get();
		return modelMapperService.mappedToEmployeeDto(emp);
		}
		else {
			throw new ResouceNotFoundException("Employee Does Not Exist");
			}
		}

	@Override
	public void deleteEmployeeDetailsById(Integer employeeId) {
		boolean empExist=empdao.existsById(employeeId);
		if(empExist) {
 			empdao.deleteById(employeeId);
		}else {
			throw new ResouceNotFoundException("Employee does not exist");
		}
		
	}

	@Override
	public EmployeeDto updateEmployeeDetails(Employee employee) {
		if(empdao.existsById(employee.getEmployeeId())) {
			LOG.info("EmpServiceImp class AddEmployeeDetails Method");
			Employee emp=empdao.save(employee);
			return modelMapperService.mappedToEmployeeDto(emp);
			
		}
		else {
			throw new ResouceNotFoundException("EmployeeId id is does not Exists");
		}
	}

	@Override
	public EmployeeDto findEmployeeByNameAndSalary(String employeeName, double salary) {
		
		return empdao.findByEmployeeNameAndEmpSalary(employeeName, salary);
	}

	@Override
	public List<Object[]> getAllEmployeeDetails() {
		try {
		List<Object[]>empList=empdao.getAllEmployee();
		return empList;
		}
		catch (Exception e) {
			throw new ResouceNotFoundException("Empty List");
		}
		
	}

	
}
