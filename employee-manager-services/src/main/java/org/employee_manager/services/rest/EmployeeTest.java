package org.employee_manager.services.rest;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Employee;
import org.junit.Test;

import javax.ws.rs.client.Client;

import junit.framework.Assert;

public class EmployeeTest {

	@Test
	public void testGetEmployee() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/employee/10");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.toString());
		Assert.assertEquals(200, response.getStatus());
	}

	@Test
	public void testGetAllEmployees() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/employee");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.toString());
		Assert.assertEquals(200, response.getStatus());
	}

	@Test
	public void testSaveEmployee() {
		Employee emp = new Employee();
		emp.setName("Gigi");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-web/rest/employee/");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(emp, MediaType.APPLICATION_JSON_TYPE));
		Assert.assertEquals(200, response.getStatus());
	}

	
}
