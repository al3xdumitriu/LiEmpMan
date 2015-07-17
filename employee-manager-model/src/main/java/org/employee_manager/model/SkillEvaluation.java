package org.employee_manager.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL_EVALUATION")
public class SkillEvaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_EVALUATION_ID")
	private long id;

	@JoinColumn(name = "SKILL_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Skill skillId;

	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne(cascade = CascadeType.ALL)
	private Evaluation evaluationId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Skill getSkillId() {
		return skillId;
	}

	public void setSkillId(Skill skillId) {
		this.skillId = skillId;
	}

	public Evaluation getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Evaluation evaluationId) {
		this.evaluationId = evaluationId;
	}

}
