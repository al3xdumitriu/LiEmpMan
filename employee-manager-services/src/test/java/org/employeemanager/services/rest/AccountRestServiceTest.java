package org.employeemanager.services.rest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Account;
import org.junit.Test;

public class AccountRestServiceTest {

	@Test
	public void testGetAllAccounts() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/account");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void testSaveAccount() {
		Account account = new Account();
		account.setUsername("testUser");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/account");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(account, MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
	}

	@Test
	public void testGetAccount() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/account/");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
}
