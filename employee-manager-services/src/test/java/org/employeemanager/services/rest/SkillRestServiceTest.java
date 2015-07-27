package org.employeemanager.services.rest;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.Assert;

import org.employee_manager.model.Skill;
import org.junit.Test;

public class SkillRestServiceTest {

	@Test
	public void testGetAllSkills() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/skill");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}

	@Test
	public void testGetSkillByName() {
		//create mockSkill to save it into db, before veryfing that it exists
		Skill mockedSkill = new Skill();
		mockedSkill.setName("javaDeveloper");
		Client client = ClientBuilder.newClient();

		//the save part
		WebTarget targetSave = client.target("http://localhost:8080/employee-manager-container/rest/skill");
		Response r = targetSave.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(mockedSkill, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(201, r.getStatus());
		
		//the get Rest service
		WebTarget target = client
				.target("http://localhost:8080/employee-manager-container/rest/skill?name=javaDeveloper");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}

	@Test
	public void testGetSkillByNameNoResponse() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/employee-manager-container/rest/skill/?name=somethingThatDoesNotExist");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(204, response.getStatus());
	}

	@Test
	public void testSaveSkill() {
		Skill skill = new Skill();
		skill.setName("something");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/skill");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(skill, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(201, response.getStatus());
		
	}

}
