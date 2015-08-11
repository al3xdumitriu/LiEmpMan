package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Employee;
import org.employee_manager.model.Skill;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.services.SkillService;
import org.employee_manager.services.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private EmployeeService employeeService;
	
	
	@Override
	public Skill saveSkill(Skill skill) {
		Employee employee = employeeService.findById(skill.getEmployeeId().getId());
		skill.setEmployeeId(employee);
		return this.skillRepository.save(skill);
	}

	@Override
	public List<Skill> saveAllSkills(List<Skill> skill) {
		return this.skillRepository.save(skill);
	}

	@Override
	public Skill findById(Long id) {
		return this.skillRepository.findOne(id);
	}

	@Override
	public List<Skill> findAllSkills() {
		return this.skillRepository.findAll();
	}

	@Override
	public List<Skill> findAllSkillsWithName(String name) {
		return skillRepository.getByName(name);
	}

	@Override
	public List<Skill> findAllSkillsForEmployee(Long employeeId) {
		return skillRepository.findSkillsByEmployeeId(employeeId);
	}

	@Override
	public Skill createSkill(Long employeeId, Skill skill) {
		Employee employee = employeeService.findById(employeeId);
		employee.getAchievements().size();
		employee.getEmployeeProjects().size();
		employee.getEvaluations().size();
		employee.getSkills().size();
		skill.setEmployeeId(employee);
		skillRepository.save(skill);
		return skill;
	}
}
