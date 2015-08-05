package org.employee_manager.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Email;
import org.employee_manager.services.EmailService;
import org.employee_manager.services.email.MailMail;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/sendEmail")
public class EmailRestService {

	@Autowired
	private EmailService emailService;

	@Autowired
	private MailMail mail;

	public void setMail(MailMail mail) {
		this.mail = mail;
	}

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendMail(Email email) {

		Response resultResponse = null;

		try {
			mail.sendMail(email.getFrom(), email.getTo(), email.getSubject(), email.getText(), email.getImage(), email.getAttachment());
			resultResponse = Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			resultResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return resultResponse;
	}

	@POST
	@Path("/db")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendMailToDb(Email email) {

		Response resultResponse = null;

		try {
			emailService.save(email);
			resultResponse = Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			resultResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return resultResponse;
	}
}
