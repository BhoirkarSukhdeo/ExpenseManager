package com.technical.task.serviceimp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.task.dtos.EmpSalaryDto;
import com.technical.task.dtos.EmployeeDto;
import com.technical.task.model.EmpSalary;
import com.technical.task.model.Employee;

@Service
public class ModelMapperService {

	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeDto mappedToEmployeeDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}

	public EmpSalaryDto mappedToEmpSalaryDto(EmpSalary salary) {
		return modelMapper.map(salary, EmpSalaryDto.class);

	}

}
