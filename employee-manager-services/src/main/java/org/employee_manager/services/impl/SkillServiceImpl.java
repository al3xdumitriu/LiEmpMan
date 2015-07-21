package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Evaluation;
import org.employee_manager.model.Skill;
import org.employee_manager.services.SkillService;
import org.employee_manager.services.repositories.EvaluationRepository;
import org.employee_manager.services.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillRepository skillRepository;



	@Override
	public Skill saveSkill(Skill skill) {
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



	
	
}
