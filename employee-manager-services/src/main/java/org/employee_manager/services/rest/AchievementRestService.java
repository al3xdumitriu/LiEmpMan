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
import org.employee_manager.model.Skill;
import org.employee_manager.services.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/achievement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AchievementRestService {

	@Autowired
	private AchievementService achievementService;

	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAchievement(Achievement c1) {
		
		int status = 200;

		try {
			achievementService.saveAchievement(c1);
			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(c1).build();
		return res;
	}

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAchievements(@QueryParam("name") String name) {

		int status = 200;
		List<Achievement> achievementList = new ArrayList<Achievement>();
		try {
			if (name == null) {
				achievementList = achievementService.findAllAchievements();
			} else {
				achievementList= achievementService.findByName(name);
			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}

		Response res = Response.status(status).entity(achievementList).build();
		return res;

	}

	@GET
	@Path("{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAchievement(@PathParam("param1") String param1) {
		Long id = Long.parseLong(param1);
		int status = 200;
		Achievement myAchiev = null;

		try {
			myAchiev = achievementService.findById(id);
			if (myAchiev == null)
				status = 204;
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(myAchiev).build();
		return res;

	}

}
