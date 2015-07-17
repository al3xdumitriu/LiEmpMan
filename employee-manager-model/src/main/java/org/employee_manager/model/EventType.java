package org.employee_manager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@Column(name="EVENT_TYPE_NAME")
	private String name;
	
	@OneToMany(mappedBy="eventTypeId")
    private List<Event> event;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEventId() {
		return event;
	}

	public void setEventId(List<Event> eventId) {
		this.event = eventId;
	}

	
}
