package org.employee_manager.services.repositories;


import org.employee_manager.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long>{

}
