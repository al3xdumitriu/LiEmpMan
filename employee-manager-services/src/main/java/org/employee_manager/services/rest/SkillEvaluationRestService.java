package org.employee_manager.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.employee_manager.model.SkillEvaluation;
import org.employee_manager.services.SkillEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/skillEvaluations")
public class SkillEvaluationRestService {

	@Autowired
	private SkillEvaluationService skillEvaluationService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSkillsEvaluation(){
		Status status = Response.Status.OK;
		List<SkillEvaluation> skillsEv = null;
		try {
			skillsEv = skillEvaluationService.findAll();
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.getStackTrace();
		}
		
		Response response = Response.status(status).entity(skillsEv).build();
		return response;
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response saveSkillEvaluation(SkillEvaluation skillEval){	
		Status status = Response.Status.CREATED;
		SkillEvaluation s = null;
		
		try {
			s= skillEvaluationService.save(skillEval);
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.getStackTrace();
		}
		
		Response response = Response.status(status).entity(s).build();
		
		return response;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getSkillEvaluationById(@PathParam("id")String id){
		Long skillEvalId = Long.parseLong(id);
		Status status = Response.Status.OK;
		SkillEvaluation s = null;
		
		try {
			s = skillEvaluationService.findById(skillEvalId);
			if(s == null){
				status = Response.Status.NO_CONTENT;
			}
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
		}

		Response response = Response.status(status).entity(s).build();
		
		return response;
	}
}
