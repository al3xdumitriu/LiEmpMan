package org.employee_manager.services;

import org.employee_manager.model.Person;
import org.junit.Test;

import junit.framework.Assert;


public class PersonTest extends BaseServicesTest {

	@Test
	public void testSave(){
		Person p = new Person();
		p.setName("TTT");
		Person newPErson = this.personService.savePerson(p);
		Person found = this.personService.getById(newPErson.getId());	
		Assert.assertEquals("TTT", found.getName());
	}
	

}
