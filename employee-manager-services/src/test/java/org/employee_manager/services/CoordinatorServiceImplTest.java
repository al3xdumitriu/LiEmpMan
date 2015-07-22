package org.employee_manager.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Coordinator;
import org.employee_manager.model.Employee;
import org.junit.Before;
import org.junit.Test;

public class CoordinatorServiceImplTest extends BaseServicesTest {

	private Coordinator coordinator, coordinatorSecond;

	@Before
	public void init() {

		// coordinator object
		coordinator = new Coordinator();
		coordinator.setName("coordinatorName");
		coordinator.setCnp(987654321);
		coordinator.setPhone("0231767676");
		coordinator.setEmail("test2@email.com");
		coordinator.setExperienceLevel("junior");
		coordinator.setAvailableHours(40);
		coordinator.setJobTitle("javaDeveloper");
		coordinator.setAccount(null);
		coordinator.setAddressId(null);
		coordinator.setAchievements(null);
		coordinator.setEmployeeProjects(null);
		coordinator.setEvaluations(null);
		coordinator.setSkills(null);

		// coordinator second object
		coordinatorSecond = new Coordinator();
		coordinatorSecond.setName("secondCoordinatorName");
		coordinatorSecond.setCnp(987654321);
		coordinatorSecond.setPhone("073176376");
		coordinatorSecond.setEmail("test1@email.com");
		coordinatorSecond.setExperienceLevel("junior");
		coordinatorSecond.setAvailableHours(40);
		coordinatorSecond.setJobTitle("javaDeveloper");
		coordinatorSecond.setAccount(null);
		coordinatorSecond.setAddressId(null);
		coordinatorSecond.setAchievements(null);
		coordinatorSecond.setEmployeeProjects(null);
		coordinatorSecond.setEvaluations(null);
		coordinatorSecond.setSkills(null);
	}

	@Test
	public void testSave() {

		Coordinator coordinatorResult = coordinatorService.save(coordinator);

		assertEquals("coordinatorName", coordinatorResult.getName());
		assertEquals(987654321, coordinatorResult.getCnp());
		assertEquals("0231767676", coordinatorResult.getPhone());
		assertEquals("test2@email.com", coordinatorResult.getEmail());
		assertEquals("junior", coordinatorResult.getExperienceLevel());
		assertEquals(40, coordinatorResult.getAvailableHours());
		assertEquals("javaDeveloper", coordinatorResult.getJobTitle());
	}

	@Test
	public void testSaveAll() {

		List<Coordinator> coordinatorList = new ArrayList<Coordinator>();
		coordinatorList.add(coordinator);
		coordinatorList.add(coordinatorSecond);

		List<Coordinator> coordinatorListResult = coordinatorService.saveAll(coordinatorList);
		assertEquals(2, coordinatorListResult.size());
		assertEquals("coordinatorName", coordinatorListResult.get(0).getName());
		assertEquals("secondCoordinatorName", coordinatorListResult.get(1).getName());
	}

	@Test
	public void testFindById() {

		Employee coordinatorResult = coordinatorService.save(coordinator);
		Employee coordinatorResultTwo = coordinatorService.findById(coordinatorResult.getId());

		assertEquals(coordinatorResultTwo.getId(), coordinatorResult.getId());
		assertEquals("coordinatorName", coordinatorResult.getName());
		assertEquals(987654321, coordinatorResult.getCnp());
		assertEquals("0231767676", coordinatorResult.getPhone());
		assertEquals("test2@email.com", coordinatorResult.getEmail());
		assertEquals("junior", coordinatorResult.getExperienceLevel());
		assertEquals(40, coordinatorResult.getAvailableHours());
		assertEquals("javaDeveloper", coordinatorResult.getJobTitle());
	}

	@Test
	public void testFindAll() {

		List<Coordinator> coordinatorList = new ArrayList<Coordinator>();
		coordinatorList.add(coordinator);
		coordinatorList.add(coordinatorSecond);

		List<Coordinator> coordinatorListSave = coordinatorService.saveAll(coordinatorList);
		List<Coordinator> coordinatorListResultFind = coordinatorService.findAll();

		assertEquals(true, coordinatorListResultFind.containsAll(coordinatorListSave));
	}
}
