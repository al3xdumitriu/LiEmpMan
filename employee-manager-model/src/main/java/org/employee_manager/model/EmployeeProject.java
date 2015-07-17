package org.employee_manager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_PROJECT")
public class EmployeeProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_PROJECT_ID")
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
