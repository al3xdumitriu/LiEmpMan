package org.employee_manager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "SKILL_EVALUATION")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class SkillEvaluation implements Serializable {

	@Id
	@Column(name = "SKILL_EVALUATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_SKILL_EVALUATION")
	@SequenceGenerator(name = "SEQ_GEN_SKILL_EVALUATION", sequenceName = "skill_evaluation_id_sequence", allocationSize = 10)
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
