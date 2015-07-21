package org.employee_manager.services;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Employee;
import org.employee_manager.model.Evaluation;
import org.employee_manager.model.Person;
import org.employee_manager.model.Skill;
import org.junit.Test;

import junit.framework.Assert;

public class SkillServiceImplTest extends BaseServicesTest {

	@Test
	public void testSave() {
		Skill skill = new Skill();
		skill.setName("AwesomeSkill");
		skill.setDescription("The best skill ever");
		skill.setExperience("3 years");
		skill.setEmployeeId(null);
		skill.setSkillEvaluations(null);

		Skill newSkill = this.skillService.saveSkill(skill);

		Assert.assertEquals("AwesomeSkill", newSkill.getName());
		Assert.assertEquals("The best skill ever", newSkill.getDescription());
		Assert.assertEquals("3 years", newSkill.getExperience());
		Assert.assertEquals(null, newSkill.getEmployeeId());
		Assert.assertEquals(null, newSkill.getSkillEvaluations());
	}

	@Test
	public void testSaveAllSkills() {

		List<Skill> skills = new ArrayList();
		Skill eval1 = new Skill();
		Skill eval2 = new Skill();
		eval1.setName("Java");
		eval2.setName(".Net");
		skills.add(eval1);
		skills.add(eval2);

		List<Skill> result = this.skillService.saveAllSkills(skills);

		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testFindById() {
		Skill skill = new Skill();
		skill.setName("AwesomeSkill");
		skill.setDescription("The best skill ever");
		// skill.setExperience("3 years");

		Skill newSkill = this.skillService.saveSkill(skill);
		Skill found = this.skillService.findById(newSkill.getId());
		Assert.assertEquals("AwesomeSkill", found.getName());
	}

	@Test
	public void testFindAllSkills() {
		List<Skill> skills = new ArrayList();
		Skill eval1 = new Skill();
		Skill eval2 = new Skill();
		eval1.setName("Java");
		eval2.setName(".Net");
		skills.add(eval1);
		skills.add(eval2);

		List<Skill> result = this.skillService.saveAllSkills(skills);
		List<Skill> found = this.skillService.findAllSkills();

		Assert.assertEquals(result.size(), found.size());
	}

}
