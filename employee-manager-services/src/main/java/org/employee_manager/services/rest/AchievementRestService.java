package org.employee_manager.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Achievement;
import org.employee_manager.services.AchievementService;
import org.employee_manager.services.repositories.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AchievementRestService {

	@Autowired
	private AchievementService achievementService;

	
	@POST
	@Path("")
	@Produces("application/json")
	public Response saveAchievement() {

		int status = 200;
		Achievement c1 = new Achievement();
		c1.setName("TheBest");
		c1.setDescription("TheBestDescription");

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
	
}
