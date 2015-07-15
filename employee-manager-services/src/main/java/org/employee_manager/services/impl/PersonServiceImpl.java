package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Person;
import org.employee_manager.services.PersonService;
import org.employee_manager.services.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
    private PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return this.personRepository.findAll();
	}

	public Person savePerson(Person person) {
		return this.personRepository.save(person);
	}

	public Person getById(Long id) {
		return this.personRepository.findOne(id);
	}

	public void deleteById(Long id) {
		this.personRepository.delete(id);
		
	}

	public Person getByName(String name) {
		return this.personRepository.getByName(name);
	}

	public String getNameById(Long id) {
		return this.personRepository.getNameById(id);
	}

	public void updateById(String name, Long id) {
		this.personRepository.updateById(name, id);
		
	}

}
