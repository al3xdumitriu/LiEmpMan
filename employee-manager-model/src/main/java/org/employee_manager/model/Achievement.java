package org.employee_manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACHIEVEMENT")
public class Achievement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACHIEVEMENT_ID")
	private long id;

	@Column(name = "ACHIEVEMENT_NAME")
	private String name;

	@Column(name = "ACHIEVEMENT_DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employeeId;

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

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

}
