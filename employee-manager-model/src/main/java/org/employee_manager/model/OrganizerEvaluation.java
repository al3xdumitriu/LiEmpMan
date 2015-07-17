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
public class OrganizerEvaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORGANIZER_EVALUATION_ID")
	private long id;
	
	@JoinColumn(name = "ORGANIZER_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Organizer organizerId;

	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne(cascade=CascadeType.ALL)
	private Evaluation evaluationId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Organizer getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(Organizer organizerId) {
		this.organizerId = organizerId;
	}

	public Evaluation getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Evaluation evaluationId) {
		this.evaluationId = evaluationId;
	}

}
