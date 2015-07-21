package org.employee_manager.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.employee_manager.model.Coordinator;
import org.employee_manager.model.Event;
import org.employee_manager.model.EventStatus;
import org.employee_manager.model.EventType;
import org.junit.Test;

import junit.framework.Assert;

public class EventServiceImplTest extends BaseServicesTest {

	@Test
	public void testSave() {
		Coordinator coordninator = new Coordinator();
		coordninator.setName("Andrei");

		EventType eventType = new EventType();
		eventType.setName("Extern");

		EventType eventType2 = new EventType();
		eventType2.setName("Intern");

		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		EventStatus eventStatus2 = new EventStatus();
		eventStatus2.setName("Cancelled");

		Event event = new Event();
		event.setName("CodeCamp");
		event.setDescription("CodeCamp Iasi, September 25th, 2015. Probably the largest IT conference in Romania!");
		event.setStartDate(null);
		event.setEndDate(null);
		event.setParticipantsNumber("2");
		event.setEventTypeId(eventType);
		event.setCoordinatorId(coordninator);
		event.setEventStatusId(eventStatus);

		Event newEvent = this.eventService.saveEvent(event);

		System.out.println(newEvent.getName());

		// retrieve && test the newEventType name saved in db
		Assert.assertEquals(event.getName(), newEvent.getName());
		Assert.assertEquals(event.getDescription(), newEvent.getDescription());
		Assert.assertEquals(null, newEvent.getStartDate());
		Assert.assertEquals(null, newEvent.getEndDate());
		Assert.assertEquals(event.getParticipantsNumber(), newEvent.getParticipantsNumber());
		Assert.assertEquals(event.getCoordinatorId(), newEvent.getCoordinatorId());
		Assert.assertEquals(event.getEventTypeId(), newEvent.getEventTypeId());
		Assert.assertEquals(event.getEventStatusId(), newEvent.getEventStatusId());
	}

	@Test
	public void testSaveAll() {
		Coordinator coordninator = new Coordinator();
		coordninator.setName("Andrei");

		EventType eventType = new EventType();
		eventType.setName("Extern");

		EventType eventType2 = new EventType();
		eventType2.setName("Intern");

		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		EventStatus eventStatus2 = new EventStatus();
		eventStatus2.setName("Cancelled");

		Event event = new Event();
		event.setName("CodeCamp");
		event.setDescription("CodeCamp Iasi, September 25th, 2015. Probably the largest IT conference in Romania!");
		event.setStartDate(new Date());
		event.setEndDate(new Date());
		event.setParticipantsNumber("2");
		event.setEventTypeId(eventType);
		event.setCoordinatorId(coordninator);
		event.setEventStatusId(eventStatus);

		Event event2 = new Event();
		event2.setName("Internship");
		event2.setDescription(".NET, JAVA, Testing internship");
		event2.setStartDate(new Date());
		event2.setEndDate(new Date());
		event2.setParticipantsNumber("20");
		event2.setEventTypeId(eventType2);
		event2.setCoordinatorId(coordninator);
		event2.setEventStatusId(eventStatus);

		List<Event> events = new LinkedList<>();
		events.add(event);
		events.add(event2);

		List<Event> eventSavedList = new ArrayList<>();
		eventSavedList = this.eventService.saveEvents(events);

		System.out.println(eventSavedList.size());
		// compare && test the event2 object attrib saved in the
		// eventSavedList
		Assert.assertEquals(event2.getName(), eventSavedList.get(1).getName());
		Assert.assertEquals(event2.getDescription(), eventSavedList.get(1).getDescription());
		Assert.assertEquals(event2.getStartDate(), eventSavedList.get(1).getStartDate());
		Assert.assertEquals(event2.getEndDate(), eventSavedList.get(1).getEndDate());
		Assert.assertEquals(event2.getParticipantsNumber(), eventSavedList.get(1).getParticipantsNumber());
		Assert.assertEquals(event2.getEventTypeId(), eventSavedList.get(1).getEventTypeId());
		Assert.assertEquals(event2.getCoordinatorId(), eventSavedList.get(1).getCoordinatorId());
		Assert.assertEquals(event2.getEventStatusId(), eventSavedList.get(1).getEventStatusId());

		// retrieve && test eventSavedList size saved in db
		// Assert.assertEquals(2, eventSavedList.size());

	}

	@Test
	public void testFindById() {
		Coordinator coordninator = new Coordinator();
		coordninator.setName("Andrei");

		EventType eventType = new EventType();
		eventType.setName("Extern");

		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		Event event = new Event();
		event.setName("CodeCamp");
		event.setDescription("CodeCamp Iasi, September 25th, 2015. Probably the largest IT conference in Romania!");
		event.setStartDate(new Date());
		event.setEndDate(new Date());
		event.setParticipantsNumber("2");
		event.setEventTypeId(eventType);
		event.setCoordinatorId(coordninator);
		event.setEventStatusId(eventStatus);

		Event newEvent = this.eventService.saveEvent(event);
		Event foundEvent = this.eventService.findById(newEvent.getId());

		System.out.println(foundEvent.getName());

		// retrieve && test the newEventType object name set in the newEvent
		// object saved in db
		/*
		 * System.out.println(foundEvent.getEventTypeId().getName());
		 * Assert.assertEquals(eventType.getName(),
		 * foundEvent.getEventTypeId().getName());
		 */

		// retrieve && test the coordinator object name set in the newEvent
		// object saved in db
		/*
		 * System.out.println(newEvent.getCoordinatorId().getName());
		 * Assert.assertEquals(coordninator.getName(),
		 * newEvent.getCoordinatorId().getName());
		 * 
		 */

		// retrieve && test the eventStatus object name set in the newEvent
		// object saved in db

		System.out.println(newEvent.getName());
		Assert.assertEquals(eventStatus.getName(), newEvent.getEventStatusId().getName());

		// compare && test the newEvent name && foundEvent name
		// Assert.assertEquals(event.getName(), foundEvent.getName());
	}

	@Test
	public void testFindAll() {

		Coordinator coordninator = new Coordinator();
		coordninator.setName("Andrei");

		EventType eventType = new EventType();
		eventType.setName("Extern");

		EventType eventType2 = new EventType();
		eventType2.setName("Intern");

		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		EventStatus eventStatus2 = new EventStatus();
		eventStatus2.setName("Cancelled");

		Event event = new Event();
		event.setName("CodeCamp");
		event.setDescription("CodeCamp Iasi, September 25th, 2015. Probably the largest IT conference in Romania!");
		event.setStartDate(new Date());
		event.setEndDate(new Date());
		event.setParticipantsNumber("2");
		event.setEventTypeId(eventType);
		event.setCoordinatorId(coordninator);
		event.setEventStatusId(eventStatus);

		Event event2 = new Event();
		event2.setName("Internship");
		event2.setDescription(".NET, JAVA, Testing internship");
		event2.setStartDate(new Date());
		event2.setEndDate(new Date());
		event2.setParticipantsNumber("20");
		event2.setEventTypeId(eventType2);
		event2.setCoordinatorId(coordninator);
		event.setEventStatusId(eventStatus);

		List<Event> events = new LinkedList<>();
		events.add(event);
		events.add(event2);

		List<Event> eventSavedList = new LinkedList<>();
		eventSavedList = this.eventService.saveEvents(events);

		List<Event> newEventList = this.eventService.findAllEvents();
		// compare && test the event object with
		// the first object found in newEventLiss

		Assert.assertEquals(event.getName(), newEventList.get(0).getName());
		Assert.assertEquals(event.getDescription(), newEventList.get(0).getDescription());
		Assert.assertEquals(event.getStartDate(), newEventList.get(0).getStartDate());
		Assert.assertEquals(event.getEndDate(), newEventList.get(0).getEndDate());
		Assert.assertEquals(event.getParticipantsNumber(), newEventList.get(0).getParticipantsNumber());
		Assert.assertEquals(event.getCoordinatorId(), newEventList.get(0).getCoordinatorId());
		Assert.assertEquals(event.getEventStatusId(), newEventList.get(0).getEventStatusId());
		Assert.assertEquals(event.getEventTypeId(), newEventList.get(0).getEventTypeId());

		// retrieve && test eventSavedList size saved in db
		// Assert.assertEquals(event.getName(), newEventList.get(0).getName());
	}

}
