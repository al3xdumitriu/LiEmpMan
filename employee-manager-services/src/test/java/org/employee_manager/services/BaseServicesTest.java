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
	protected RoleService roleService;
	
	@Autowired
	protected AchievementService achievementService;

	@Autowired
	protected AddressService addressService;

	@Autowired 
	protected AccountService accountService;
	
	@Autowired
	protected EmployeeService employeeService;
	
	@Autowired
    protected CoordinatorService coordinatorService;
	
	@Autowired
    protected OrganizerService organizerService;
}
