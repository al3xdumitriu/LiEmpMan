package org.employee_manager.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "EMAIL_SEND")
public class Email implements Serializable {

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_EMAIL")
	@SequenceGenerator(name = "SEQ_GEN_EMAIL", sequenceName = "email_id_sequence", allocationSize = 10)
	private long id;

	@Column(name = "EMAIL_TO")
	private String to;

	@Column(name = "EMAIL_FROM")
	private String from;

	@Column(name = "EMAIL_SUBJECT")
	private String subject;

	@Column(name = "EMAIL_TEXT")
	private String text;

	@Column(name = "IMAGE_NAME")
	private String imageName;
	
	@Column(name = "IMAGE_DATA")
	private byte[] imageData;

	@Column(name = "ATTACHMENT_NAME")
	private String attachmentName;
	
	@Column(name = "ATTACHMENT_DATA")
	private byte[] attachmentData;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Email.serialVersionUID = serialVersionUID;
	}

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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public byte[] getAttachmentData() {
		return attachmentData;
	}

	public void setAttachmentData(byte[] attachmentData) {
		this.attachmentData = attachmentData;
	}
}
