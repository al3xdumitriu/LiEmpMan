package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Evaluation;
import org.employee_manager.services.EvaluationService;
import org.employee_manager.services.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;

	@Override
	public Evaluation saveEvaluation(Evaluation evaluation) {
		return this.evaluationRepository.save(evaluation);
	}

	@Override
	public List<Evaluation> saveAllEvaluations(List<Evaluation> evaluations) {

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
