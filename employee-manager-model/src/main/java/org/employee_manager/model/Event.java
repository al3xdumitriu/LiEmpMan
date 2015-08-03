package org.employee_manager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(name = "EVENT_NAME")
	private String name;
	
	@Column(name = "EVENT_COORDINATES")
	private String coordinates;

	@Column(name = "EVENT_VIDEO")
	private String video;

	@Column(name = "EVENT_START_DATE")
	private Date startDate;

	@Column(name = "EVENT_END_DATE")
	private Date endDate;

	@Column(name = "EVENT_DESCRIPTION")
	private String description;

	@Column(name = "EVENT_PARTICIPANTS_NUMBER")
	private String participantsNumber;

	@OneToMany(mappedBy = "eventId")
	private Set<EventEvaluation> eventEvaluations;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COORDINATOR_ID")
	private Coordinator coordinatorId;

	@OneToMany(mappedBy = "eventId")
	private List<Organizer> organizers;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EVENT_TYPE_ID")
	private EventType eventTypeId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EVENT_STATUS_ID")
	private EventStatus eventStatusId;

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

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
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

	public Set<EventEvaluation> getEventEvaluations() {
		return eventEvaluations;
	}

	public void setEventEvaluations(Set<EventEvaluation> eventEvaluations) {
		this.eventEvaluations = eventEvaluations;
	}

	public Coordinator getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(Coordinator coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public List<Organizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<Organizer> organizers) {
		this.organizers = organizers;
	}

	public EventType getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(EventType eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public EventStatus getEventStatusId() {
		return eventStatusId;
	}

	public void setEventStatusId(EventStatus eventStatusId) {
		this.eventStatusId = eventStatusId;
	}

}
