package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.EventType;

public interface EventTypeService {
	List<EventType> findAllEvents();

	EventType saveEvent(EventType eventType);

	List<EventType> saveEventsType(List<EventType> eventsType);

	EventType findById(Long id);
}
