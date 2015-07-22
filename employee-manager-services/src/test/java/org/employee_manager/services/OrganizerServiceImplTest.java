package org.employee_manager.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Organizer;
import org.junit.Before;
import org.junit.Test;

public class OrganizerServiceImplTest extends BaseServicesTest {

	private Organizer organizer, organizerSecond;

	@Before
	public void init() {

		// coordinator object
		organizer = new Organizer();
		organizer.setName("organizerName");
		organizer.setCnp(987651221);
		organizer.setPhone("0231767688");
		organizer.setEmail("test22@email.com");
		organizer.setExperienceLevel("junior");
		organizer.setAvailableHours(40);
		organizer.setJobTitle("javaDeveloper");
		organizer.setAccount(null);
		organizer.setAddressId(null);
		organizer.setAchievements(null);
		organizer.setEmployeeProjects(null);
		organizer.setEvaluations(null);
		organizer.setSkills(null);

		// coordinator second object
		organizerSecond = new Organizer();
		organizerSecond.setName("secondOrganizerName");
		organizerSecond.setCnp(987634321);
		organizerSecond.setPhone("073176399");
		organizerSecond.setEmail("test12@email.com");
		organizerSecond.setExperienceLevel("junior");
		organizerSecond.setAvailableHours(40);
		organizerSecond.setJobTitle("javaDeveloper");
		organizerSecond.setAccount(null);
		organizerSecond.setAddressId(null);
		organizerSecond.setAchievements(null);
		organizerSecond.setEmployeeProjects(null);
		organizerSecond.setEvaluations(null);
		organizerSecond.setSkills(null);
	}

	@Test
	public void testSave() {

		Organizer organizerResult = organizerService.save(organizer);

		assertEquals("organizerName", organizerResult.getName());
		assertEquals(987651221, organizerResult.getCnp());
		assertEquals("0231767688", organizerResult.getPhone());
		assertEquals("test22@email.com", organizerResult.getEmail());
		assertEquals("junior", organizerResult.getExperienceLevel());
		assertEquals(40, organizerResult.getAvailableHours());
		assertEquals("javaDeveloper", organizerResult.getJobTitle());
	}

	@Test
	public void testSaveAll() {

		List<Organizer> organizerList = new ArrayList<Organizer>();
		organizerList.add(organizer);
		organizerList.add(organizerSecond);

		List<Organizer> organizerListResult = organizerService.saveAll(organizerList);
		assertEquals(2, organizerListResult.size());
		assertEquals("organizerName", organizerListResult.get(0).getName());
		assertEquals("secondOrganizerName", organizerListResult.get(1).getName());
	}

	@Test
	public void testFindById() {

		Organizer organizerResult = organizerService.save(organizer);
		Organizer organizerResultTwo = organizerService.findById(organizerResult.getId());

		assertEquals(organizerResultTwo.getId(), organizerResult.getId());
		assertEquals("organizerName", organizerResult.getName());
		assertEquals(987651221, organizerResult.getCnp());
		assertEquals("0231767688", organizerResult.getPhone());
		assertEquals("test22@email.com", organizerResult.getEmail());
		assertEquals("junior", organizerResult.getExperienceLevel());
		assertEquals(40, organizerResult.getAvailableHours());
		assertEquals("javaDeveloper", organizerResult.getJobTitle());
	}

	@Test
	public void testFindAll() {

		List<Organizer> organizerList = new ArrayList<Organizer>();
		organizerList.add(organizer);
		organizerList.add(organizerSecond);

		List<Organizer> organizerListSave = organizerService.saveAll(organizerList);
		List<Organizer> organizerListResultFind = organizerService.findAll();

		assertEquals(true, organizerListResultFind.containsAll(organizerListSave));
	}
}
