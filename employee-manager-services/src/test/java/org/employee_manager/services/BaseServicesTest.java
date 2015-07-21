package org.employee_manager.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/employee-manager-services-config-test.xml")
@Transactional
public abstract class BaseServicesTest {

	@Autowired
	protected PersonService personService;

	@Autowired
	protected EventService eventService;
	
	@Autowired
	protected EventStatusService eventStatusService;
	
	@Autowired
	protected EventTypeService eventTypeService;

}
