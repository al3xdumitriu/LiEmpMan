package org.employee_manager.services.repositories;


import java.util.List;

import org.employee_manager.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SkillRepository extends JpaRepository<Skill, Long>{

	@Query("select s from Skill s where s.name=:name") //hql
	 List<Skill> getByName(@Param("name") String name);

}
