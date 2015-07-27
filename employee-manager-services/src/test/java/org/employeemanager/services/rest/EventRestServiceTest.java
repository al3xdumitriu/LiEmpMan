package org.employeemanager.services.rest;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/employee-manager-services-config-test.xml")
@Transactional
public class EventRestServiceTest {

	@Test
	public void testGetAllEvents() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/event/");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testGetByName() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/event/?name=ziuaaIsabelei");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() ==  Response.Status.OK.getStatusCode()) {
			Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		} else {
			Assert.assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
		}
	}
	
	@Test
	public void testSaveEvent() {
		
		Event event = new Event();
		event.setName("rrrrrrrrrrr");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/event");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(event,MediaType.APPLICATION_JSON_TYPE));
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testGetById() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/event/10");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() ==  Response.Status.OK.getStatusCode()) {
			Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		} else {
			Assert.assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
		}
	}

}
