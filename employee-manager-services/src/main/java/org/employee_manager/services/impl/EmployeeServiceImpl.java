package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Employee;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.services.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> saveAll(List<Employee> employeeList) {
		return employeeRepository.save(employeeList);
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepository.getByName(name);
	}

	@Override
	public void updateById(String name, Long cnp, String phone, String email, String experienceLevel, String jobTitle,
			Long id) {
		this.employeeRepository.updateById(name, cnp, phone, email, experienceLevel, jobTitle, id);
		
	}

	

}
