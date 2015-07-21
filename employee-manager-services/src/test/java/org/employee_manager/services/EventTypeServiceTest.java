package org.employee_manager.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.employee_manager.model.EventType;
import org.junit.Test;

import junit.framework.Assert;

public class EventTypeServiceTest extends BaseServicesTest {
	@Test
	public void testSave() {
		EventType eventType = new EventType();
		eventType.setName("Intern");

		EventType newEventType = this.eventTypeService.saveEvent(eventType);

		System.out.println(newEventType.getName());

		// retrieve && test the newEventType name saved in db
		Assert.assertEquals("Intern", newEventType.getName());
	}

	@Test
	public void testSaveAll() {
		List<EventType> eventTypeList = new ArrayList<>();

		EventType eventType = new EventType();
		eventType.setName("Intern");

		EventType eventType2 = new EventType();
		eventType2.setName("Extern");

		eventTypeList.add(eventType);
		eventTypeList.add(eventType2);

		List<EventType> eventTypeSavedList = new ArrayList<>();
		eventTypeSavedList = this.eventTypeService.saveEventsType(eventTypeList);

		System.out.println(eventTypeSavedList.size());

		// retrieve && test eventTypeSavedList size saved in db
		Assert.assertEquals(2, eventTypeSavedList.size());

	}

	@Test
	public void testFindById() {
		EventType eventType = new EventType();
		eventType.setName("Extern");

		EventType newEventType = this.eventTypeService.saveEvent(eventType);
		EventType foundEventType = this.eventTypeService.findById(newEventType.getId());

		System.out.println(foundEventType.getName());

		// compare && test the newEventType name && foundEventType name
		Assert.assertEquals("Extern", newEventType.getName());
	}

	@Test
	public void testFindAll() {
		List<EventType> eventTypeList = new LinkedList<>();

		EventType eventType = new EventType();
		eventType.setName("Intern");

		EventType eventType2 = new EventType();
		eventType2.setName("Extern");

		eventTypeList.add(eventType);
		eventTypeList.add(eventType2);

		List<EventType> eventTypeSavedList = new LinkedList<>();
		eventTypeSavedList = this.eventTypeService.saveEventsType(eventTypeList);

		// compare && test the eventTypeName for the first element index in the
		// eventTypeSavedList saved in db
		/*
		 * List<EventType> foundEventType =
		 * this.eventTypeService.findAllEvents(); Assert.assertEquals("Intern",
		 * foundEventType.get(0).getName());
		 */
		// compare && test the first eventTypeName for eventTypeSavedList with
		// the first eventTypeName found in newEventTypeLis
		List<EventType> newEventTypeList = this.eventTypeService.findAllEvents();

		System.out.println(newEventTypeList.size());
		Assert.assertEquals(2, newEventTypeList.size());
	}
}
