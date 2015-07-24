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

import org.employee_manager.model.Skill;
import org.employee_manager.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
@Component
@Path("/skill")
public class SkillRestService {

	@Autowired
	private SkillService skillService;

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllSkills() {

		List<Skill> allSkills = new ArrayList<Skill>();
		int status = 200;
		try {
			allSkills = skillService.findAllSkills();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allSkills).build();
		return res;

	}
	
	@GET
	@Path("{param1}")
	@Produces("application/json")
	public Response getSkill(@PathParam("param1") String param1)
	{
		Long id=Long.parseLong(param1);
		int status=200;
		Skill myskill=null;
		//Long id=1L;
		
		try{
			myskill=skillService.findById(id);
			if(myskill==null)
				status=204;
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(myskill).build();
		return res;

	}
	

	@POST
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response saveSkill(Skill skill) {
		int status = 200;

		System.out.println(skill);
		try {
			skillService.saveSkill(skill);
			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(skill).build();
		return res;

	}

}
*/
