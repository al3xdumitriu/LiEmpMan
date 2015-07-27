package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.SkillEvaluation;
import org.junit.Test;

import junit.framework.Assert;

public class SkillEvaluationServiceImplTest extends BaseServicesTest{

	@Test
	public void testSave() {
		SkillEvaluation skillEvaluation = new SkillEvaluation();
		skillEvaluation.setEvaluationId(null);
		skillEvaluation.setSkillId(null);

		SkillEvaluation newSkillEvaluation = this.skillEvaluationService.save(skillEvaluation);

		Assert.assertEquals(null, newSkillEvaluation.getEvaluationId());
		Assert.assertEquals(null, newSkillEvaluation.getSkillId());
	}
	
	@Test
	public void testSaveAll() {

		List<SkillEvaluation> skillEvaluations = new ArrayList();
		SkillEvaluation skillEvaluation1 = new SkillEvaluation();
		SkillEvaluation skillEvaluation2 = new SkillEvaluation();
		skillEvaluations.add(skillEvaluation1);
		skillEvaluations.add(skillEvaluation2);

		List<SkillEvaluation> result = this.skillEvaluationService.saveAll(skillEvaluations);

		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void testFindById() {
		SkillEvaluation skillEvaluation = new SkillEvaluation();

		SkillEvaluation newSkillEvaluation = this.skillEvaluationService.save(skillEvaluation);
		SkillEvaluation foundSkillEvaluation = this.skillEvaluationService.findById(newSkillEvaluation.getId());
		Assert.assertEquals(newSkillEvaluation.getId(), foundSkillEvaluation.getId());
	}
	
	@Test
	public void testFindAll() {
		int skillEvaluationsBefore = this.skillEvaluationService.findAll().size();
		List<SkillEvaluation> skillEvaluations = new ArrayList();
		SkillEvaluation skillEvaluation1 = new SkillEvaluation();
		SkillEvaluation skillEvaluation2 = new SkillEvaluation();
		skillEvaluations.add(skillEvaluation1);
		skillEvaluations.add(skillEvaluation2);

		List<SkillEvaluation> result = this.skillEvaluationService.saveAll(skillEvaluations);
		List<SkillEvaluation> found = this.skillEvaluationService.findAll();

		Assert.assertEquals(result.size()+skillEvaluationsBefore, found.size());
	}

}
