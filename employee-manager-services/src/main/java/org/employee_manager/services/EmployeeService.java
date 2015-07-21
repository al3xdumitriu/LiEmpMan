package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Employee;
import org.employee_manager.model.Person;

public interface EmployeeService {

	Employee save(Employee employee);
	
	List<Employee> saveAll(List<Employee> employeeList);
		
	Employee findById(Long id);
	
	List<Employee> findAll();
}
