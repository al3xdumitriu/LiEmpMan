package org.employee_manager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROJECT_ID")
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
	private boolean statust;

	public Project() {
		super();
	}

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

	public boolean isStatust() {
		return statust;
	}

	public void setStatust(boolean statust) {
		this.statust = statust;
	}

}