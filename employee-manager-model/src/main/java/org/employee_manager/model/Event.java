package org.employee_manager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class Event implements Serializable {

	@Id
	@Column(name = "EVENT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EVENT")
	@SequenceGenerator(name = "SEQ_GEN_EVENT", sequenceName = "event_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PARTICIPANTS_NUMBER")
	private String participantsNumber;

	@OneToOne(mappedBy = "eventId")
	private EventType eventType;
	
	@OneToOne(mappedBy = "eventId")
	private EventType eventStatus;
	
	@OneToMany(mappedBy="accountId")
    private Set<Role> eventEvaluations;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParticipantsNumber() {
		return participantsNumber;
	}

	public void setParticipantsNumber(String participantsNumber) {
		this.participantsNumber = participantsNumber;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public EventType getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventType eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Set<Role> getEventEvaluations() {
		return eventEvaluations;
	}

	public void setEventEvaluations(Set<Role> eventEvaluations) {
		this.eventEvaluations = eventEvaluations;
	}
}
