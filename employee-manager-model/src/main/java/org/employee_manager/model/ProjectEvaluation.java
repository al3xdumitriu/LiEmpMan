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

@Entity
@Table(name = "PROJECT_EVALUATION")
public class ProjectEvaluation implements Serializable {

	@Id
	@Column(name = "PROJECT_EVALUATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_PROJECT_EVALUATION")
	@SequenceGenerator(name = "SEQ_GEN_PROJECT_EVALUATION", sequenceName = "project_evaluation_id_sequence", allocationSize = 10)
	private long id;

	@JoinColumn(name = "PROJECT_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Project projectId;

	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne(cascade = CascadeType.ALL)
	private Evaluation evaluationId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Project getIdProject() {
		return projectId;
	}

	public void setIdProject(Project idProject) {
		this.projectId = idProject;
	}

	public Evaluation getIdEvaluation() {
		return evaluationId;
	}

	public void setIdEvaluation(Evaluation idEvaluation) {
		this.evaluationId = idEvaluation;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public Evaluation getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Evaluation evaluationId) {
		this.evaluationId = evaluationId;
	}
}
