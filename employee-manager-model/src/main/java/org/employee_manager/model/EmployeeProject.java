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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_PROJECT")
public class EmployeeProject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_PROJECT_ID")
	private long id;
	/*
	 * @JoinColumn(name = "employeeId")
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL) private Employee idEmployee;
	 */
	@JoinColumn(name = "PROJECT_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Project projectId;

	@Column(name = "EMPLOYEE_PROJECT_HOURS_ALLOCATED")
	private int hoursAllocated;

	public EmployeeProject() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public int getHoursAllocated() {
		return hoursAllocated;
	}

	public void setHoursAllocated(int hoursAllocated) {
		this.hoursAllocated = hoursAllocated;
	}

}
