package org.employeemanager.services.rest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.SkillEvaluation;
import org.junit.Test;

import junit.framework.Assert;

public class SkillEvaluationRestServiceTest {

	@Test
	public void testGetAllSkillsEvaluation(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/skillEvaluations");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}
	
//	@Test
	public void testGetSkillEvaluationById(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/skillEvaluations/1500");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		
		if (response.getStatus() ==  Response.Status.OK.getStatusCode()) {
			Assert.assertEquals(200, response.getStatus());
		} else {
			Assert.assertEquals(404, response.getStatus());
		}
	}
	
	@Test
	public void testSaveSkillEvaluation() {
		SkillEvaluation skillEval = new SkillEvaluation();
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/skillEvaluations");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(skillEval, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(201, response.getStatus());
		
	}
}
