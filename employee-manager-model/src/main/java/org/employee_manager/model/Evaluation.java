package org.employee_manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EVALUATION")
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVALUATION_ID")
	private long id;

	@Column(name = "EVALUATION_GRADE")
	private int grade;

	@Column(name = "EVALUATION_COMMENT")
	private String comment;

	/*
	 * @ManyToOne
	 * 
	 * @Column(name = "EVALUATION_EMPLOYEE_ID") private Employee employeeId;
	 */

	@Column(name = "EVALUATION_ANONYM")
	private boolean anonym;

	public Evaluation() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isAnonym() {
		return anonym;
	}

	public void setAnonym(boolean anonym) {
		this.anonym = anonym;
	}

}
