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
import javax.ws.rs.core.Response.Status;

import org.employee_manager.model.Skill;
import org.employee_manager.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/skill")
public class SkillRestService {

	@Autowired
	private SkillService skillService;

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllSkills(@QueryParam(value = "name") String name) {

		Status status = Response.Status.OK;
		List<Skill> allSkills = null;
		if (name == null) {
			allSkills = new ArrayList<Skill>();
			try {
				allSkills = skillService.findAllSkills();
			} catch (Exception e) {
				status = Response.Status.INTERNAL_SERVER_ERROR;
				e.getStackTrace();
			}

		}
		if (name != null) {
			try {
				allSkills = skillService.findAllSkillsWithName(name);
				if (allSkills.isEmpty())
					status = Response.Status.NO_CONTENT;
			} catch (Exception e) {
				status = Response.Status.INTERNAL_SERVER_ERROR;
				e.getStackTrace();
			}
		}
		for (Skill skill : allSkills)
			skill.setSkillEvaluations(null);
		Response res = Response.status(status).entity(allSkills).build();
		return res;

	}

	@GET
	@Path("{param1}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getSkill(@PathParam("param1") String param1) {
		Status status = null;;
		Long id;
		try {
			id = Long.parseLong(param1);
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			return Response.status(status).entity("Invalid id passed.Please insert a valid integer id").build();
		}

		Skill mySkill = null;

		try {
			mySkill = skillService.findById(id);
			if (mySkill == null)
			{
				return Response.status(Response.Status.NO_CONTENT).entity("There is no object in database with this id").build();
			}
			else
				mySkill.setSkillEvaluations(null);
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.getStackTrace();
		}
		Response res = Response.status(Response.Status.OK).entity(mySkill).build();
		return res;

	}

	@POST
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response saveSkill(Skill skill) {

		Status status = null;

		System.out.println(skill);
		try {
			skill = skillService.saveSkill(skill);
			if (skill == null)
				status = Response.Status.NO_CONTENT;
			status = Response.Status.CREATED;
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(skill).build();
		return res;

	}
}
