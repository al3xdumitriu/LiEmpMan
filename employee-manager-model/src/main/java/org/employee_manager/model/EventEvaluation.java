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
@Table(name = "EVENT_EVALUATION")
public class EventEvaluation implements Serializable {

	@Id
	@Column(name="EVENT_EVALUATION_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EVENT_EVALUATION")
	@SequenceGenerator(name = "SEQ_GEN_EVENT_EVALUATION", sequenceName = "event_evaluation_type_id_sequence", allocationSize = 10)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "EVENT_ID", nullable=false)
    private Event eventId;
	
	@JoinColumn(name = "EVALUATION_ID")
	@OneToOne(cascade=CascadeType.ALL)
	private Evaluation evaluationId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Event getEventId() {
		return eventId;
	}

	public void setEventId(Event eventId) {
		this.eventId = eventId;
	}

	public Evaluation getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Evaluation evaluationId) {
		this.evaluationId = evaluationId;
	}


}
