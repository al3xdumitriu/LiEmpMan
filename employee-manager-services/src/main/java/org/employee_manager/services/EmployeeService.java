package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> saveAll(List<Employee> employeeList);

	Employee findById(Long id);

	List<Employee> findByName(String name);

	List<Employee> findAll();

	void updateById(String name, Long cnp,String phone, String email, String experienceLevel,String jobTitle,Long id);
}
