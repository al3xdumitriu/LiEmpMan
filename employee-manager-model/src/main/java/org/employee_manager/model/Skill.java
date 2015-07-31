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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "SKILL")
@XmlRootElement
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Skill implements Serializable {
	@Id
	@Column(name = "SKILL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_SKILL")
	@SequenceGenerator(name = "SEQ_GEN_SKILL", sequenceName = "skill_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "SKILL_NAME")
	private String name;

	@Column(name = "SKILL_DESCRIPTION")
	private String description;

	@Column(name = "SKILL_EXPERIENCE")
	private String experience;

	@JoinColumn(name = "EMPLOYEE_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employeeId;

	@OneToMany(mappedBy = "skillId", fetch = FetchType.EAGER)
	private List<SkillEvaluation> skillEvaluations;

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

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public List<SkillEvaluation> getSkillEvaluations() {
		return skillEvaluations;
	}

	public void setSkillEvaluations(List<SkillEvaluation> skillEvaluations) {
		this.skillEvaluations = skillEvaluations;
	}

	@Transient
	public double getRating() {
		if(skillEvaluations == null){
			return 0;
		}
		double avg = 0;
		int count = 0;
		for(SkillEvaluation se : skillEvaluations){
			avg = avg + se.getEvaluationId().getGrade();
			count++;
		}
		if(count != 0){
			avg = avg / count;
		}
		
		return avg;		
	}
}
