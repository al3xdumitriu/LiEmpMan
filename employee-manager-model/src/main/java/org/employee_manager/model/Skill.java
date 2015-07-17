package org.employee_manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private long id;
	/*
	 * @ManyToOne
	 * 
	 * @Column(name = "SKILL_EMPLOYEE_ID") private Employee skillEmployeeId;
	 */
	@Column(name = "SKILL_NAME")
	private String name;

	@Column(name = "SKILL_DESCRIPTION")
	private String description;

	@Column(name = "SKILL_EXPERIENCE")
	private String experience;

	public Skill() {
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
