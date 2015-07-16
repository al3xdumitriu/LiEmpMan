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
@Table(name = "PROJECT_EVALUATION")
public class ProjectEvaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROJECT_EVALUATION_ID")
	private long id;

	@JoinColumn(name = "PROJECT_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Project idProject;

	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne
	private Evaluation idEvaluation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Project getIdProject() {
		return idProject;
	}

	public void setIdProject(Project idProject) {
		this.idProject = idProject;
	}

	public Evaluation getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(Evaluation idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

}
