package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Person;

public interface PersonService {

	List<Person> getAllPersons();

	Person savePerson(Person person);

	Person getById(Long id);

	void deleteById(Long id);

	Person getByName(String name);

	String getNameById(Long id);

	void updateById(String name, Long id);

}
