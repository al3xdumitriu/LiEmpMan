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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_PROJECT")
public class EmployeeProject implements Serializable {

	@Id
	@Column(name = "EMPLOYEE_PROJECT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EMPLOYEE_PROJECT")
	@SequenceGenerator(name = "SEQ_GEN_EMPLOYEE_PROJECT", sequenceName = "employee_project_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "EMPLOYEE_PROJECT_HOURS_ALLOCATED")
	private int hoursAllocated;

	@JoinColumn(name = "PROJECT_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Project projectId;

	@JoinColumn(name = "EMPLOYEE_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Project employeeId;

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

	public Project getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Project employeeId) {
		this.employeeId = employeeId;
	}

}
