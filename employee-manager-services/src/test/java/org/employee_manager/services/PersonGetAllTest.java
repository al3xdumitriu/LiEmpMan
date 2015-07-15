package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Person;
import org.junit.Test;

import junit.framework.Assert;

public class PersonGetAllTest extends BaseServicesTest{

	
	@Test
	public void testGetAll(){
		Person p = new Person();
		p.setName("TTT");
		Person savedPerson = personService.savePerson(p);
		
		List<Person> pers = this.personService.getAllPersons();
		Assert.assertEquals(1, pers.size());
	}
}
