package org.employee_manager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZER")
public class Organizer extends Employee{
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="EVENT_ID")
//	@Column(name="ORGANIZER_EVENT")
//	private Event organizerEvent;

//	public Event getOrganizerEvent() {
//		return organizerEvent;
//	}
//
//	public void setOrganizerEvent(Event organizerEvent) {
//		this.organizerEvent = organizerEvent;
//	}	
	
	@OneToMany(mappedBy="organizerId")
	private List<OrganizerEvaluation> organizerEvaluations;

	public List<OrganizerEvaluation> getOrganizerEvaluations() {
		return organizerEvaluations;
	}

	public void setOrganizerEvaluations(List<OrganizerEvaluation> organizerEvaluations) {
		this.organizerEvaluations = organizerEvaluations;
	}
	
}
