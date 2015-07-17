package org.employee_manager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private long id;

	@Column(name = "EMPLOYEE_NAME")
	private String name;

	@Column(name = "EMPLOYEE_CNP")
	private long cnp;

	@Column(name = "EMPLOYEE_PHONE")
	private String phone;

	@Column(name = "EMPLOYEE_EMAIL")
	private String email;

	@Column(name = "EMPLOYEE_EXPERIENCE_LEVEL")
	private String experienceLevel;

	@Column(name = "EMPLOYEE_AVAILABLE_HOURS")
	private int availableHours;

	@Column(name = "EMPLOYEE_JOB_TITLE")
	private String jobTitle;

	@OneToOne(mappedBy = "employeeId")
	public Account account;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address addressId;

	@OneToMany(mappedBy = "employeeId")
	private List<Achievement> achievements;

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

	public long getCnp() {
		return cnp;
	}

	public void setCnp(long cnp) {
		this.cnp = cnp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public int getAvailableHours() {
		return availableHours;
	}

	public void setAvailableHours(int availableHours) {
		this.availableHours = availableHours;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public List<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	
	// @Column(name="EMPLOYEE_EMPLOYEE_PROJECTS")
	// @OneToMany(mappedBy="projectId")
	// private List<EmployeeProject> employeeProjects;
	//
	// @Column(name="EMPLOYEE_EVALUATIONS")
	// @OneToMany(mappedBy="id")
	// private List<Evaluation> evaluations;
	//
	// @Column(name="EMPLOYEE_SKILLS")
	// @OneToMany(mappedBy="id")
	// private List<Skill> skills;

}
