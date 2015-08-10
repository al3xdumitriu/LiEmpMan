package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Evaluation;
import org.employee_manager.services.EvaluationService;
import org.employee_manager.services.SkillEvaluationService;
import org.employee_manager.services.SkillService;
import org.employee_manager.services.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;
	@Autowired
	private SkillService skillService;
	@Autowired
	private SkillEvaluationService skillEvaluationService;
	
	@Override
	public Evaluation saveEvaluation(Evaluation evaluation) {
		return this.evaluationRepository.save(evaluation);
	}

	@Override
	public List<Evaluation> saveAllEvaluations(List<Evaluation> evaluations) {		
		for(Evaluation eval : evaluations){				
			eval.getSkillEvaluation().setSkillId(skillService.findById(eval.getSkillEvaluation().getSkillId().getId()));
			eval.getSkillEvaluation().setEvaluationId(eval);
			eval.setEmployeeId(eval.getSkillEvaluation().getSkillId().getEmployeeId());
			
			skillEvaluationService.save(eval.getSkillEvaluation());
		}

		return this.evaluationRepository.save(evaluations);
	}

	@Override
	public Evaluation findById(Long id) {

		return this.evaluationRepository.findOne(id);
	}

	@Override
	public List<Evaluation> findAllEvaluations() {
		return this.evaluationRepository.findAll();
	}

}
