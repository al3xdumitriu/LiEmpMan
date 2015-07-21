package org.employee_manager.services.repositories;

import org.employee_manager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
