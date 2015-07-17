package org.employee_manager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_STATUS")
public class EventStatus implements Serializable {

	@Id
	@Column(name = "EVENT_STATUS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EVENT_STATUS")
	@SequenceGenerator(name = "SEQ_GEN_EVENT_STATUS", sequenceName = "event_status_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "EVENT_STATUS_NAME")
	private String name;

	@OneToMany(mappedBy = "eventStatusId")
	private List<Event> events;

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

	public List<Event> getEvent() {
		return events;
	}

	public void setEvent(List<Event> event) {
		this.events = event;
	}
}
