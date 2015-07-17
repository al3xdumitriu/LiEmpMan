package org.employee_manager.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "EVENT_TYPE")
public class EventType implements Serializable {

	@Id
	@Column(name="EVENT_TYPE_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EVENT_TYPE")
	@SequenceGenerator(name = "SEQ_GEN_EVENT_TYPE", sequenceName = "event_type_id_sequence", allocationSize = 10)
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
