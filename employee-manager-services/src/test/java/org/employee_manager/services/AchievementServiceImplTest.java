package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		Achievement found1 = this.achievementService.findById(achievement1.getId());
		Achievement found2 = this.achievementService.findById(achievement2.getId());
		Assert.assertEquals(achievements.get(0).getName(), found1.getName());
		Assert.assertEquals(achievements.get(1).getName(), found2.getName());
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
		
		List<Achievement> initialFoundAchievements = this.achievementService.findAllAchievements();
		List<Achievement> newAchievements = this.achievementService.saveAllAchievements(achievements);
		List<Achievement> foundAchievements = this.achievementService.findAllAchievements();
		Assert.assertEquals(initialFoundAchievements.size()+newAchievements.size(), foundAchievements.size());
	
	}
	
	
}
