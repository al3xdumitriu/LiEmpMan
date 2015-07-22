package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Project;
import org.employee_manager.services.ProjectService;
import org.employee_manager.services.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {

		return this.projectRepository.save(project);
	}

	@Override
	public List<Project> saveAllProjects(List<Project> projects) {

		return this.projectRepository.save(projects);
	}

	@Override
	public Project findById(Long id) {

		return this.projectRepository.findOne(id);
	}

	@Override
	public List<Project> findAllProjects() {

		return this.projectRepository.findAll();
	}

}
