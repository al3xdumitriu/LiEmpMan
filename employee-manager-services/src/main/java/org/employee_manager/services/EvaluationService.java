package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Evaluation;

public interface EvaluationService {

	
	
	Evaluation saveEvaluation(Evaluation evaluation);

	List<Evaluation> saveAllEvaluations(List<Evaluation> evaluations);
	
	Evaluation findById(Long id);

	List<Evaluation> findAllEvaluations();

}
