package org.employee_manager.services;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Event;
import org.junit.Test;

import junit.framework.Assert;

public class EventRestServiceTest {

	@Test
	public void testGetAllEvents() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/event/");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testGetByName() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/event/?name=ziuaIsabelei");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testSaveEvent() {
		
		Event event = new Event();
		event.setName("CodeCamp");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/event");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(event,MediaType.APPLICATION_JSON_TYPE));
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testGetById() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/event/10");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(200, response.getStatus());
	}

}
