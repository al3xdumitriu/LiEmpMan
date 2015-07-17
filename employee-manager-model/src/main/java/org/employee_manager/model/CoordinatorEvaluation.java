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

@Entity
public class CoordinatorEvaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COORDINATOR_EVALUATION_ID")
	private long id;
	
	@JoinColumn(name = "COORDINATOR_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Coordinator coordinatorId;

	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne(cascade=CascadeType.ALL)
	private Evaluation evaluationId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Coordinator getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(Coordinator coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public Evaluation getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Evaluation evaluationId) {
		this.evaluationId = evaluationId;
	}
	
}
