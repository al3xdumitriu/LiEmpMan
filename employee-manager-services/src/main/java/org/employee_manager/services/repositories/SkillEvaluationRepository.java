package org.employee_manager.services.repositories;

import org.employee_manager.model.SkillEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillEvaluationRepository extends JpaRepository<SkillEvaluation, Long>{

}
