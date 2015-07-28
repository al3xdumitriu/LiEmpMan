package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.SkillEvaluation;
import org.employee_manager.services.SkillEvaluationService;
import org.employee_manager.services.repositories.SkillEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillEvaluationImpl implements SkillEvaluationService{

	@Autowired
	SkillEvaluationRepository skillEvaluationRepository;
	
	@Override
	public SkillEvaluation save(SkillEvaluation skillEvaluation) {
		return skillEvaluationRepository.save(skillEvaluation);
	}

	@Override
	public List<SkillEvaluation> saveAll(List<SkillEvaluation> skillEvaluations) {
		return skillEvaluationRepository.save(skillEvaluations);
	}

	@Override
	public SkillEvaluation findById(Long id) {
		return skillEvaluationRepository.findOne(id);
	}

	@Override
	public List<SkillEvaluation> findAll() {
		return skillEvaluationRepository.findAll();
	}

}
