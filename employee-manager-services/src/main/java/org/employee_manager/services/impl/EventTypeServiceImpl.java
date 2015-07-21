package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.EventType;
import org.employee_manager.services.EventStatusService;
import org.employee_manager.services.EventTypeService;
import org.employee_manager.services.repositories.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventTypeServiceImpl implements EventTypeService {

	@Autowired
	private EventTypeRepository eventTypeRepository;

	@Override
	public List<EventType> findAllEvents() {
		return this.eventTypeRepository.findAll();
	}

	@Override
	public EventType saveEvent(EventType eventType) {
		return this.eventTypeRepository.save(eventType);
	}

	@Override
	public List<EventType> saveEventsType(List<EventType> eventsType) {
		return this.eventTypeRepository.save(eventsType);
	}

	@Override
	public EventType findById(Long id) {
		return this.eventTypeRepository.findOne(id);
	}

}
