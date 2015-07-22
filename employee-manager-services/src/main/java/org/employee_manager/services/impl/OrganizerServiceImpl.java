package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Organizer;
import org.employee_manager.services.OrganizerService;
import org.employee_manager.services.repositories.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerRepository organizerRepository;

	@Override
	public Organizer save(Organizer organizer) {
		return organizerRepository.save(organizer);
	}

	@Override
	public List<Organizer> saveAll(List<Organizer> organizerList) {
		return organizerRepository.save(organizerList);
	}

	@Override
	public Organizer findById(Long id) {
		return organizerRepository.findOne(id);
	}

	@Override
	public List<Organizer> findAll() {
		return organizerRepository.findAll();
	}
}
