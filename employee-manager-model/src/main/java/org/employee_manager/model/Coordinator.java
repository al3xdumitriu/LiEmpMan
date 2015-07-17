package org.employee_manager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COORDINATOR")
public class Coordinator extends Employee{
	
//	@OneToOne(mappedBy = "id")
//	@Column(name="COORDINATOR_EVENT")
//	private Event event;
	
	@OneToMany(mappedBy="coordinatorId")
	private List<CoordinatorEvaluation> coordinatorEvaluations;

//	public Event getEvent() {
//		return event;
//	}
//
//	public void setEvent(Event event) {
//		this.event = event;
//	}
	
}
