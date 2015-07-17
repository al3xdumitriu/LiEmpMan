package org.employee_manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_STATUS")
public class EventStatus implements Serializable {

	@Id
	@Column(name="EVENT_STATUS_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EVENT_STATUS")
	@SequenceGenerator(name = "SEQ_GEN_EVENT_STATUS", sequenceName = "event_status_id_sequence", allocationSize = 10)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "EVENT_ID", nullable=false)
    private Event eventId;

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
}
