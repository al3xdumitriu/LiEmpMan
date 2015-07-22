package org.employee_manager.services;

import java.util.List;

import org.employee_manager.model.EventStatus;

public interface EventStatusService {
	List<EventStatus> findAllEvents();

	EventStatus saveEvent(EventStatus eventStatus);

	List<EventStatus> saveEventsStatus(List<EventStatus> eventsStatus);

	EventStatus findById(Long id);
}
