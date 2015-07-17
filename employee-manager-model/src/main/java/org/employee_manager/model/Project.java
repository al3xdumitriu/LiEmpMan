package org.employee_manager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

	@Id
	@Column(name = "PROJECT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_PROJECT")
	@SequenceGenerator(name = "SEQ_GEN_PROJECT", sequenceName = "project_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "PROJECT_NAME")
	private String name;

	@Column(name = "PROJECT_DESCRIPTION")
	private String description;

	@Column(name = "PROJECT_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "PROJECT_END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "PROJECT_STATUS")
	private boolean status;

	@OneToMany(mappedBy = "projectId")
	private List<EmployeeProject> employeeProjects;

	@OneToMany(mappedBy = "projectId")
	private List<ProjectEvaluation> projectEvaluations;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<EmployeeProject> getEmployeeProjects() {
		return employeeProjects;
	}

	public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public List<ProjectEvaluation> getProjectEvaluations() {
		return projectEvaluations;
	}

	public void setProjectEvaluations(List<ProjectEvaluation> projectEvaluations) {
		this.projectEvaluations = projectEvaluations;
	}

}