package org.employee_manager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_COORDINATOR_EMPLOYEE")
	@SequenceGenerator(name = "SEQ_GEN_COORDINATOR_EMPLOYEE", sequenceName = "employee_evaluation_id_sequence", allocationSize = 10)
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
	@JsonManagedReference
	public Account account;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address addressId;

	@OneToMany(mappedBy = "employeeId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference(value="employee-achievements")
	private List<Achievement> achievements;

	@OneToMany(mappedBy = "employeeId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference(value="employee-employeeProjects")
	private List<EmployeeProject> employeeProjects;

	@OneToMany(mappedBy = "employeeId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference(value="employee-evaluations")
	private List<Evaluation> evaluations;

	@OneToMany(mappedBy = "employeeId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference(value="employee-skills")
	private List<Skill> skills;

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

	public List<EmployeeProject> getEmployeeProjects() {
		return employeeProjects;
	}

	public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}
