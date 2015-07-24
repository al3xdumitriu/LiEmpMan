package org.employeemanager.services.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Achievement;
import org.junit.Test;

import junit.framework.Assert;


public class AchievementRestServiceTest{
	

		@Test
		public void testGetAllAchievementsRest(){
			
			Client client = ClientBuilder.newClient();
			  WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/achievement");
			  Response response = target.request(MediaType.APPLICATION_JSON).get();
			  System.out.println(response.toString());
			  Assert.assertEquals(200, response.getStatus());
		}
		
		
		@Test
		public void testGetAchievementRest(){
			
			Client client = ClientBuilder.newClient();
			  WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/achievement/10");
			  Response response = target.request(MediaType.APPLICATION_JSON).get();
			  System.out.println(response.toString());
			  Assert.assertEquals(200, response.getStatus());
		}
		
		@Test
		public void testPostAchievementRest(){
			
			 Achievement achiev = new Achievement();
			 achiev.setName("CodeCamp");
			  Client client = ClientBuilder.newClient();
			  WebTarget target = client.target("http://localhost:8080/employee-manager-container/rest/achievement/");
			  Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(achiev,MediaType.APPLICATION_JSON_TYPE));
			  System.out.println(response.toString());
			  Assert.assertEquals(200, response.getStatus());
		}
		
		
	
    
}
