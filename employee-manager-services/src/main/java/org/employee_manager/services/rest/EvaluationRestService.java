package org.employee_manager.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.employee_manager.model.Evaluation;
import org.employee_manager.model.SkillEvaluation;
import org.employee_manager.services.EvaluationService;
import org.employee_manager.services.SkillEvaluationService;
import org.employee_manager.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/evaluation")
public class EvaluationRestService {

	@Autowired
	private EvaluationService evaluationService;
	@Autowired
	private SkillEvaluationService skillEvaluationService;
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response saveEvaluationForEmployee(List<Evaluation> evaluations){
		Status status = null;
		try {			
			evaluations = evaluationService.saveAllEvaluations(evaluations);
			
			//For saving the skillEvaluations
//			for(Evaluation eval : evaluations){				
//				skillEvaluationService.save(eval.getSkillEvaluation());
//			}
			
			status = Response.Status.CREATED;
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		Response res = Response.status(status).entity(evaluations).build();
		return res;
	}
}
