package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Event;
import org.employee_manager.services.EventService;
import org.employee_manager.services.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> findAllEvents() {
		return this.eventRepository.findAll();
	}

	@Override
	public Event saveEvent(Event event) {
		return this.eventRepository.save(event);
	}

	@Override
	public List<Event> saveEvents(List<Event> events) {
		return this.eventRepository.save(events);
	}

	@Override
	public Event findById(Long id) {
		return this.eventRepository.findOne(id);
	}

}
