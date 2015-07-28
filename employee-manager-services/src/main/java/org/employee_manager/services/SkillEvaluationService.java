package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.SkillEvaluation;

public interface SkillEvaluationService {

	SkillEvaluation save(SkillEvaluation skillEvaluation);

	List<SkillEvaluation> saveAll(List<SkillEvaluation> skillEvaluations);

	SkillEvaluation findById(Long id);

	List<SkillEvaluation> findAll();
}
