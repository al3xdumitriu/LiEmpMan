package org.employee_manager.services.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Employee;
import org.employee_manager.model.Event;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.services.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("employee")
public class EmployeeRestService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@POST
	@Path("")
	@Produces("application/json")
	public Response saveEmployee() {

		int status = 200;
		Employee emp1 = new Employee();
		emp1.setEmail("adsas@yahoo.ro");
		emp1.setAvailableHours(5);
		emp1.setExperienceLevel("2 ani jumate");
		emp1.setJobTitle("developer");
		emp1.setName("John");
		emp1.setPhone("0743991341");

		try {
			employeeService.save(emp1);

			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(emp1).build();
		return res;
	}

	@GET
	@Path("")
	@Produces("application/json")
	public Response getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		int status = 200;
		try {
			allEmployees = employeeService.findAll();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allEmployees).build();
		return res;
	}
}
