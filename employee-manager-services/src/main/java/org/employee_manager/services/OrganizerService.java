package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Organizer;

public interface OrganizerService {
	
	Organizer save(Organizer organizer);

	List<Organizer> saveAll(List<Organizer> organizer);

	Organizer findById(Long id);

	List<Organizer> findAll();
}
