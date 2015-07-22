package org.employee_manager.services.impl;

import java.util.List;

import org.employee_manager.model.Event;
import org.employee_manager.model.EventStatus;
import org.employee_manager.services.EventStatusService;
import org.employee_manager.services.repositories.EventRepository;
import org.employee_manager.services.repositories.EventStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventStatusServiceImpl implements EventStatusService {

	@Autowired
	private EventStatusRepository eventStatusRepository;

	@Override
	public List<EventStatus> findAllEvents() {
		return this.eventStatusRepository.findAll();
	}

	@Override
	public EventStatus saveEvent(EventStatus eventStatus) {
		return this.eventStatusRepository.save(eventStatus);
	}

	@Override
	public List<EventStatus> saveEventsStatus(List<EventStatus> eventsStatus) {
		return this.eventStatusRepository.save(eventsStatus);
	}

	@Override
	public EventStatus findById(Long id) {
		return this.eventStatusRepository.findOne(id);
	}

}
