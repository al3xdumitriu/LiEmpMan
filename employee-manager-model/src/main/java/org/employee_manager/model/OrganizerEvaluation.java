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
@Table(name = "ORGANIZER_EVALUATION")
public class OrganizerEvaluation implements Serializable {

	@Id
	@Column(name = "ORGANIZER_EVALUATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_ORGANIZER_EVALUATION")
	@SequenceGenerator(name = "SEQ_GEN_ORGANIZER_EVALUATION", sequenceName = "organizer_evaluation_id_sequence", allocationSize = 10)
	private long id;

	@JoinColumn(name = "ORGANIZER_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Organizer organizerId;

	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne(cascade = CascadeType.ALL)
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
