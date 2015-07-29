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
@Table(name = "ACHIEVEMENT")
public class Achievement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594631964604917094L;

	@Id
	@Column(name = "ACHIEVEMENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_ACHIEVEMENT")
	@SequenceGenerator(name = "SEQ_GEN_ACHIEVEMENT", sequenceName = "achievement_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "ACHIEVEMENT_NAME")
	private String name;

	@Column(name = "ACHIEVEMENT_DESCRIPTION")
	private String description;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	 @LazyCollection(LazyCollectionOption.FALSE)
	@JsonBackReference
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
