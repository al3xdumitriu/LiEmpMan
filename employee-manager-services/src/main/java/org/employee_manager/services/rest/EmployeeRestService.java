package org.employee_manager.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Employee;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.services.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Path("employee")
public class EmployeeRestService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@POST
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response saveEmployee(Employee emp) {
		int status = 200;
		try {
			employeeService.save(emp);
			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(emp).build();
		return res;
	}

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllEmployees(@QueryParam("name") String name) {
		List<Employee> allEmployees = new ArrayList<Employee>();
		Response res = null;
		int status = 200;
		try {
			if (name == null) {
				allEmployees = employeeService.findAll();
				res = Response.status(status).entity(allEmployees).build();
			} else {
				allEmployees = employeeService.findByName(name);
			}

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		for (Employee employeeFound : allEmployees) {
			employeeFound.setEmployeeProjects(null);
			employeeFound.setAchievements(null);
			employeeFound.setEvaluations(null);
			employeeFound.setSkills(null);
		}
		res = Response.status(status).entity(allEmployees).build();
		return res;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployee(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();
		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				 
				
				employeeFound = employeeService.findById(idParse);
				employeeFound.setEmployeeProjects(null);
				employeeFound.setAchievements(null);
				employeeFound.setEvaluations(null);
				employeeFound.setSkills(null);
			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeFound).build();
		return res;
	}

}
