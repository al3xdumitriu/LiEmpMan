package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.WebResource;
import org.employee_manager.model.Achievement;
import org.employee_manager.model.Employee;
import org.glassfish.jersey.client.ClientResponse;
import org.junit.Test;


import junit.framework.Assert;

public class AchievementServiceImplTest extends BaseServicesTest {

	@Test
	public void testSaveAchievement() {
		Achievement achievement = new Achievement();
		achievement.setName("myAchievement");
		achievement.setDescription("description");
		achievement.setEmployeeId(null);
		Achievement newAchievement = this.achievementService.saveAchievement(achievement);

		Assert.assertEquals("myAchievement", newAchievement.getName());
		Assert.assertEquals("description", newAchievement.getDescription());
		Assert.assertEquals(null, newAchievement.getEmployeeId());

	}

	@Test
	public void testFindById() {
		Achievement achievement = new Achievement();
		achievement.setName("myAchievement");
		;
		achievement.setDescription("description");
		achievement.setEmployeeId(null);
		Achievement newAchievement = this.achievementService.saveAchievement(achievement);
		Achievement found = this.achievementService.findById(newAchievement.getId());

		Assert.assertEquals(achievement.getName(), found.getName());
	}

	@Test
	public void testSaveAllAchievements() {
		Achievement achievement1 = new Achievement();
		achievement1.setName("myAchievement");
		achievement1.setDescription("description");
		achievement1.setEmployeeId(null);

		Achievement achievement2 = new Achievement();
		achievement2.setName("myAchievement");
		achievement2.setDescription("description");
		achievement2.setEmployeeId(null);

		List<Achievement> achievements = new ArrayList<Achievement>();
		achievements.add(achievement1);
		achievements.add(achievement2);

		List<Achievement> newAchievements = this.achievementService.saveAllAchievements(achievements);
		Assert.assertEquals(achievements.get(0).getName(), newAchievements.get(0).getName());
		Assert.assertEquals(achievements.get(1).getName(), newAchievements.get(1).getName());
	}

	@Test
	public void testFindAllAchievements() {
		Achievement achievement1 = new Achievement();
		achievement1.setName("myAchievement");
		achievement1.setDescription("description");
		achievement1.setEmployeeId(null);

		Achievement achievement2 = new Achievement();
		achievement2.setName("myAchievement");
		achievement2.setDescription("description");
		achievement2.setEmployeeId(null);

		List<Achievement> achievements = new ArrayList<Achievement>();
		achievements.add(achievement1);
		achievements.add(achievement2);

		List<Achievement> newAchievements = this.achievementService.saveAllAchievements(achievements);
		List<Achievement> foundAchievements = this.achievementService.findAllAchievements();
		Assert.assertEquals(achievements.get(0).getName(), foundAchievements.get(0).getName());
		Assert.assertEquals(achievements.get(1).getName(), foundAchievements.get(1).getName());

	}
	
	
//	@Test
//	public void testSaveAchievementRest(){
//		
//		Client client=Client.create();     
//		WebResource webResourceTest =client.resource("http://localhost:8080/rentCar-web/rest/customer");
//		ClientResponse response=webResourceTest.type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
//		Assert.assertEquals(200, response.getStatus());
//	}
	
	
	
}
