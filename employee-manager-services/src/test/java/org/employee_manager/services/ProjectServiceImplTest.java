package org.employee_manager.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.employee_manager.model.Evaluation;
import org.employee_manager.model.Project;
import org.employee_manager.model.ProjectEvaluation;
import org.junit.Test;

import junit.framework.Assert;

public class ProjectServiceImplTest extends BaseServicesTest {

	@Test
	public void testSave() {
		Project proj = new Project();
		proj.setName("Awesome project");
		proj.setDescription("The best project in the whole world");
		proj.setStartDate(null);
		proj.setEndDate(null);
		proj.setStatus("Canceled");
		proj.setEmployeeProjects(null);
		proj.setProjectEvaluations(null);

		Project newProj = this.projectService.saveProject(proj);

		Assert.assertEquals("Awesome project", newProj.getName());
		Assert.assertEquals("The best project in the whole world", newProj.getDescription());
		Assert.assertEquals(null, newProj.getStartDate());
		Assert.assertEquals(null, newProj.getEndDate());
		Assert.assertEquals("Canceled", newProj.getStatus());
		Assert.assertEquals(null, newProj.getEmployeeProjects());
		Assert.assertEquals(null, newProj.getProjectEvaluations());
	}

	@Test
	public void testSaveAllProjects() {

		List<Project> projects = new ArrayList();
		Project proj1 = new Project();
		Project proj2 = new Project();
		proj1.setName("suchName");
		proj2.setName("veryExample");
		projects.add(proj1);
		projects.add(proj2);
		List<Project> result = this.projectService.saveAllProjects(projects);

		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testFindById() {
		Project proj = new Project();
		proj.setName("Awesome project");
		proj.setDescription("The best project in the whole world");
		Date randomDate = new Date();
		proj.setStartDate(randomDate);
		proj.setEndDate(randomDate);
		// proj.setStatus(status);
		Project newProj = this.projectService.saveProject(proj);
		Project found = this.projectService.findById(newProj.getId());
		Assert.assertEquals("Awesome project", found.getName());
	}

	@Test
	public void testFindAllProjects() {

		List<Project> projects = new ArrayList();
		Project proj1 = new Project();
		Project proj2 = new Project();
		proj1.setName("suchName");
		proj2.setName("veryExample");
		projects.add(proj1);
		projects.add(proj2);

		List<Project> result = this.projectService.saveAllProjects(projects);
		List<Project> found = this.projectService.findAllProjects();

		Assert.assertEquals(result.size(), found.size());
	}

}
