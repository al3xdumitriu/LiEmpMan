package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.CoordinatorEvaluation;
import org.employee_manager.model.Employee;
import org.employee_manager.model.Evaluation;
import org.employee_manager.model.SkillEvaluation;
import org.junit.Test;

import junit.framework.Assert;

public class EvaluationServicesImplTest extends BaseServicesTest {

	@Test
	public void testSave() {
		Evaluation eval = new Evaluation();
		eval.setGrade(2);
		eval.setComment("Awesome comment");		
		eval.setEmployeeId(null);
		eval.setAnonym(true);
		eval.setProjectEvaluation(null);
		eval.setSkillEvaluation(null);
		eval.setCoordinatorEvaluation(null);
		eval.setOrganizerEvaluation(null);
		eval.setEventEvaluation(null);
		
		
		Evaluation newEval = this.evaluationService.saveEvaluation(eval);

		Assert.assertEquals(2, newEval.getGrade());
		Assert.assertEquals("Awesome comment", newEval.getComment());
		Assert.assertEquals(null, newEval.getEmployeeId());
		Assert.assertEquals(true, newEval.isAnonym());
		Assert.assertEquals(null, newEval.getProjectEvaluation());
		Assert.assertEquals(null, newEval.getSkillEvaluation());
		Assert.assertEquals(null, newEval.getCoordinatorEvaluation());
		Assert.assertEquals(null, newEval.getOrganizerEvaluation());
		Assert.assertEquals(null, newEval.getEventEvaluation());
		
		
	}

	@Test
	public void testSaveAllEvaluations() {

		List<Evaluation> evaluations = new ArrayList();
		Evaluation eval1 = new Evaluation();
		Evaluation eval2 = new Evaluation();
		eval1.setComment("such cool");
		eval2.setComment("very comment:))");
		evaluations.add(eval1);
		evaluations.add(eval2);

		List<Evaluation> result = this.evaluationService.saveAllEvaluations(evaluations);

		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testFindById() {

		Evaluation eval = new Evaluation();
		eval.setGrade(2);
		eval.setComment("Awesome comment");
		Employee angajat1 = new Employee();
		angajat1.setName("Alex");
		eval.setEmployeeId(angajat1);
		eval.setAnonym(true);
		SkillEvaluation example1 = new SkillEvaluation();
		eval.setSkillEvaluation(example1);
		CoordinatorEvaluation coordEval = new CoordinatorEvaluation();
		eval.setCoordinatorEvaluation(coordEval);
		Evaluation newEval = this.evaluationService.saveEvaluation(eval);
		Evaluation found = this.evaluationService.findById(newEval.getId());
		Assert.assertEquals("Awesome comment", found.getComment());

	}

	@Test
	public void testFindAllEvaluations() {

		List<Evaluation> evaluations = new ArrayList();
		Evaluation eval1 = new Evaluation();
		Evaluation eval2 = new Evaluation();
		eval1.setComment("such cool");
		eval2.setComment("very comment:))");
		evaluations.add(eval1);
		evaluations.add(eval2);

		List<Evaluation> result = this.evaluationService.saveAllEvaluations(evaluations);
		List<Evaluation> found = this.evaluationService.findAllEvaluations();

		Assert.assertEquals(result.size(), found.size());

	}

}
