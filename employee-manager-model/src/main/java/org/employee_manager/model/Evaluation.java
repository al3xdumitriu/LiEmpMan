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
@Table(name = "EVALUATION")
public class Evaluation implements Serializable {

	@Id
	@Column(name = "EVALUATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EVALUATION")
	@SequenceGenerator(name = "SEQ_GEN_EVALUATION", sequenceName = "evaluation_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "EVALUATION_GRADE")
	private int grade;

	@Column(name = "EVALUATION_COMMENT")
	private String comment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employeeId;

	@Column(name = "EVALUATION_ANONYM")
	private boolean anonym;

	@OneToOne(mappedBy = "evaluationId")
	private ProjectEvaluation projectEvaluation;

	@OneToOne(mappedBy = "evaluationId")
	private SkillEvaluation skillEvaluation;

	@OneToOne(mappedBy = "evaluationId")
	private CoordinatorEvaluation coordinatorEvaluation;

	@OneToOne(mappedBy = "evaluationId")
	private OrganizerEvaluation organizerEvaluation;

	@OneToOne(mappedBy = "evaluationId")
	private EventEvaluation eventEvaluation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isAnonym() {
		return anonym;
	}

	public void setAnonym(boolean anonym) {
		this.anonym = anonym;
	}

	public ProjectEvaluation getProjectEvaluation() {
		return projectEvaluation;
	}

	public void setProjectEvaluation(ProjectEvaluation projectEvaluation) {
		this.projectEvaluation = projectEvaluation;
	}

	public SkillEvaluation getSkillEvaluation() {
		return skillEvaluation;
	}

	public void setSkillEvaluation(SkillEvaluation skillEvaluation) {
		this.skillEvaluation = skillEvaluation;
	}

	public CoordinatorEvaluation getCoordinatorEvaluation() {
		return coordinatorEvaluation;
	}

	public void setCoordinatorEvaluation(CoordinatorEvaluation coordinatorEvaluation) {
		this.coordinatorEvaluation = coordinatorEvaluation;
	}

	public OrganizerEvaluation getOrganizerEvaluation() {
		return organizerEvaluation;
	}

	public void setOrganizerEvaluation(OrganizerEvaluation organizerEvaluation) {
		this.organizerEvaluation = organizerEvaluation;
	}

	public EventEvaluation getEventEvaluation() {
		return eventEvaluation;
	}

	public void setEventEvaluation(EventEvaluation eventEvaluation) {
		this.eventEvaluation = eventEvaluation;
	}

}
