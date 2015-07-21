package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Project;

public interface ProjectService {
	Project saveProject(Project project);

	List<Project> saveAllProjects(List<Project> projects);

	Project findById(Long id);

	List<Project> findAllProjects();

}
