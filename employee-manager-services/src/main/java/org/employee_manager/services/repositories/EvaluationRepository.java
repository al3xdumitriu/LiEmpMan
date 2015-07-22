package org.employee_manager.services.repositories;

import org.employee_manager.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {


}
