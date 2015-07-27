package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Skill;

public interface SkillService {
	Skill saveSkill(Skill skill);

	List<Skill> saveAllSkills(List<Skill> skills);

	Skill findById(Long id);

	List<Skill> findAllSkills();

	List<Skill> findAllSkillsWithName(String name);

}
