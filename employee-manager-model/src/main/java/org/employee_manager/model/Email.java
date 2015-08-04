package org.employee_manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL")
public class Email {
	
	@Id
	@Column(name = "EMAIL_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EMAIL")
	@SequenceGenerator(name = "SEQ_GEN_EMAIL", sequenceName = "email_id_sequence", allocationSize = 10)
	private long id;
	
	@Column(name="TO")
	private String to;
	
	@Column(name="FROM")
	private String from;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="TEXT")
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
