package com.technical.task.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.technical.task.dtos.EmployeeDto;
import com.technical.task.model.Employee;
@Repository
public interface EmpDao extends JpaRepository<Employee, Integer>{
	
	EmployeeDto findByEmployeeNameAndEmpSalary(String employeeName,double Salary);
	@Query(value="select e.employeeName,s.month,s.employeeSalary from Employee e left join EmpSalary s on e.employeeId=s.employeeId Order By month Asc")
	List<Object[]> getAllEmployee() ;

}
