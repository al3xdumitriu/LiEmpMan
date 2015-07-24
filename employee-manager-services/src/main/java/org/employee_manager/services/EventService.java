package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.Event;

public interface EventService {
	List<Event> findAllEvents();

	Event saveEvent(Event event);

	List<Event> saveEvents(List<Event> events);

	Event findById(Long id);
	
	Event findByName(String name);

}
