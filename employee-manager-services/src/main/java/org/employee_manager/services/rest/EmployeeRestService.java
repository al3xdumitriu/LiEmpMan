package org.employee_manager.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Employee;
import org.employee_manager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/employee")
public class EmployeeRestService {
	
	@Autowired
	private EmployeeService employeeService;

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllemployees() {

		List<Employee> allEmployees = new ArrayList<Employee>();
		int status = 200;
		try {
			allEmployees = employeeService.findAll();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		
		for(Employee a:allEmployees){
			a.setAchievements(null);
			a.setEmployeeProjects(null);
			a.setEvaluations(null);
			a.setSkills(null);
		}
		Response res = Response.status(status).entity(allEmployees).build();
		return res;

	}
	
	@GET
	@Path("{param1}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response getEmployee(@PathParam("param1") String param1)
	{
		Long id=Long.parseLong(param1);
		int status=200;
		Employee myEmployee=null;
		//Long id=1L;
		
		try{
			myEmployee=employeeService.findById(id);
			if(myEmployee==null)
				status=204;
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		
		myEmployee.setAchievements(null);
		myEmployee.setEmployeeProjects(null);
		myEmployee.setEvaluations(null);
		myEmployee.setSkills(null);
		Response res = Response.status(status).entity(myEmployee).build();
		return res;

	}
	

	@POST
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response saveEmployee(Employee employee) {
		int status = 200;

		System.out.println(employee);
		try {
			employeeService.save(employee);
			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(employee).build();
		return res;

	}
}
