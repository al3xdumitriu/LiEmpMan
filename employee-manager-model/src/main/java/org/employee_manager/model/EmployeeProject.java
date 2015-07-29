package org.employee_manager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EMPLOYEE_PROJECT")
public class EmployeeProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMPLOYEE_PROJECT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EMPLOYEE_PROJECT")
	@SequenceGenerator(name = "SEQ_GEN_EMPLOYEE_PROJECT", sequenceName = "employee_project_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "EMPLOYEE_PROJECT_HOURS_ALLOCATED")
	private int hoursAllocated;

	@JoinColumn(name = "PROJECT_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference
	private Project projectId;

	@JoinColumn(name = "EMPLOYEE_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference(value="employee-employeeProjects")
	private Employee employeeId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getHoursAllocated() {
		return hoursAllocated;
	}

	public void setHoursAllocated(int hoursAllocated) {
		this.hoursAllocated = hoursAllocated;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

}
