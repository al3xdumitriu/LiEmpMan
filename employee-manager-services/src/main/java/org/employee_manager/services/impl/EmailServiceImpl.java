package org.employee_manager.services.impl;

import org.employee_manager.model.Email;
import org.employee_manager.services.EmailService;
import org.employee_manager.services.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Override
	public Email save(Email email) {
		return emailRepository.save(email);
	}

}
