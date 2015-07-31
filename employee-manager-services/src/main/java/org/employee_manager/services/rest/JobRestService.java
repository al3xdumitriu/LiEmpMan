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

import org.employee_manager.model.Job;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/job")
public class JobRestService {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private EmployeeService employeeService;

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJobs(@QueryParam("name") String name) {

		List<Job> jobs = new ArrayList<Job>();
		Response response = null;

		if (name == null) {
			try {
				jobs = jobService.findAll();
			} catch (Exception e) {
				e.getStackTrace();
				response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
			for (Job job : jobs) {
				job.setEmployee(null);
			}
			response = Response.status(Response.Status.OK).entity(jobs).build();
		} else {
			Job job = jobService.findJobByName(name);
			if (job == null) {
				response = Response.status(Response.Status.NO_CONTENT).build();
			} else {
				job.setEmployee(null);
			}
			response = Response.status(Response.Status.OK).entity(job).build();
		}
		return response;
	}
	
//	@POST
//	@Path("")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response saveJob(Job job) {
//
//		Response response = null;
//		try {
//			jobService.save(job);
//			employeeService.save(job.get);
//			response = Response.status(Response.Status.CREATED).build();
//		} catch (Exception e) {
//			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//		}
//		return response;
//	}
	
	@GET
	@Path("{jobId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJob(@PathParam("jobId") String jobId) {

		Job job = null;
		Response response = null;

		try {
			job = jobService.findById(Long.parseLong(jobId));
			job.setEmployee(null);
			response = Response.status(Response.Status.OK).entity(job).build();
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

}
