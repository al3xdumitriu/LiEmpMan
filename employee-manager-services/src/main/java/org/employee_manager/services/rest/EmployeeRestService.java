package org.employee_manager.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Achievement;
import org.employee_manager.model.Employee;
import org.employee_manager.model.EmployeeProject;
import org.employee_manager.model.Evaluation;
import org.employee_manager.model.Project;
import org.employee_manager.model.Skill;
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
	@Path("{id}/achievement")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeAchievements(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<Achievement> achievements = new ArrayList<Achievement>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				achievements.addAll(employeeFound.getAchievements());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(achievements).build();
		return res;
	}

	@GET
	@Path("{id}/skill")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeSkills(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<Skill> skills = new ArrayList<Skill>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				skills.addAll(employeeFound.getSkills());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(skills).build();
		return res;
	}

	@GET
	@Path("{id}/project")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeProjects(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<EmployeeProject> employeeProjects = new ArrayList<EmployeeProject>();
		List<Project> project = new ArrayList<Project>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				employeeProjects.addAll(employeeFound.getEmployeeProjects());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeProjects).build();
		return res;
	}

	@GET
	@Path("{id}/evaluation")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeEvaluations(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<Evaluation> employeeEvaluations = new ArrayList<Evaluation>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				employeeEvaluations.addAll(employeeFound.getEvaluations());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeEvaluations).build();
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
			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeFound).build();
		return res;
	}

	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response update(@PathParam("id") String id, Employee emp) {
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
				employeeService.updateById(emp.getName(), emp.getCnp(), emp.getPhone(), emp.getEmail(),
						emp.getExperienceLevel(), emp.getJobTitle(), emp.getId());
			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeFound).build();
		return res;

	}

}
