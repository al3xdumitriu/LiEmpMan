package org.employee_manager.services;

import static org.junit.Assert.*;

import org.employee_manager.model.Email;
import org.junit.Test;

import junit.framework.Assert;

public class EmailServiceImplTest extends BaseServicesTest {

	@Test
	public void testSave() {
		Email testEmail = new Email();
		testEmail.setTo("a.babinciuc@levi9.com");
		testEmail.setFrom("levitestmail@gmail.com");
		testEmail.setSubject("test");
		testEmail.setText("test");

		Email savedEmail = this.emailService.save(testEmail);

		Assert.assertNotNull(savedEmail);
		Assert.assertEquals("a.babinciuc@levi9.com", savedEmail.getTo());
		Assert.assertEquals("levitestmail@gmail.com", savedEmail.getFrom());
		Assert.assertEquals("test", savedEmail.getSubject());
		Assert.assertEquals("test", savedEmail.getText());
	}

}
