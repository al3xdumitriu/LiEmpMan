package org.employee_manager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private String status;

	@OneToMany(mappedBy = "projectId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	private List<EmployeeProject> employeeProjects;

	@OneToMany(mappedBy = "projectId", fetch = FetchType.EAGER)
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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