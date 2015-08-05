package org.employee_manager.services.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMail {
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String from, String to, String subject, String msg, String image, String attachment) {

//		 SimpleMailMessage message = new SimpleMailMessage();
//		 message.setFrom(from);
//		 message.setTo(to);
//		 message.setSubject(subject);
//		 message.setText(msg);
//		 mailSender.send(message);

		MimeMessage message = mailSender.createMimeMessage();

		// use the true flag to indicate you need a multipart message
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(msg);

			FileSystemResource res = new FileSystemResource(new File(image));
			helper.addInline("image.jpg", res);
			
			FileSystemResource file = new FileSystemResource(new File(attachment));
			helper.addAttachment("attachment.txt", file);
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}