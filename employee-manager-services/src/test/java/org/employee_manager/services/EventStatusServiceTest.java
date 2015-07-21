package org.employee_manager.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.employee_manager.model.EventStatus;
import org.junit.Test;

import junit.framework.Assert;

public class EventStatusServiceTest extends BaseServicesTest {

	@Test
	public void testSave() {
		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		EventStatus newEventStatus = this.eventStatusService.saveEvent(eventStatus);

		System.out.println(newEventStatus.getName());

		// retrieve && test the newEventStatus name saved in db
		Assert.assertEquals("Pending", newEventStatus.getName());
	}

	@Test
	public void testSaveAll() {
		List<EventStatus> eventStatusList = new ArrayList<>();

		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		EventStatus eventStatus2 = new EventStatus();
		eventStatus2.setName("Cancelled");

		eventStatusList.add(eventStatus);
		eventStatusList.add(eventStatus2);

		List<EventStatus> eventStatusSavedList = new ArrayList<>();
		eventStatusSavedList = this.eventStatusService.saveEventsStatus(eventStatusList);

		System.out.println(eventStatusSavedList.size());

		// retrieve && test eventStatusSavedList size saved in db
		Assert.assertEquals(2, eventStatusSavedList.size());

	}

	@Test
	public void testFindById() {
		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Expired");

		EventStatus newEventStatus = this.eventStatusService.saveEvent(eventStatus);
		EventStatus foundEventStatus = this.eventStatusService.findById(newEventStatus.getId());

		System.out.println(foundEventStatus.getName());

		// compare && test the newEventStatus name && foundEventStatus name
		Assert.assertEquals("Expired", newEventStatus.getName());
	}

	@Test
	public void testFindAll() {
		List<EventStatus> eventStatusList = new LinkedList<>();

		EventStatus eventStatus = new EventStatus();
		eventStatus.setName("Pending");

		EventStatus eventStatus2 = new EventStatus();
		eventStatus2.setName("Cancelled");

		eventStatusList.add(eventStatus);
		eventStatusList.add(eventStatus2);

		List<EventStatus> eventStatusSavedList = new ArrayList<>();
		eventStatusSavedList = this.eventStatusService.saveEventsStatus(eventStatusList);

		System.out.println(eventStatusSavedList.size());

		// compare && test the statusName for the first element index in the
		// eventStatusSavedList saved in db

		List<EventStatus> foundEventStatus = this.eventStatusService.findAllEvents();
		Assert.assertEquals("Pending", foundEventStatus.get(0).getName());

		// ccompare && test the first statusName for eventStatusSavedList with
		// the first statusName found in newEventStatusLis
		/*
		 * List<EventStatus> newEventStatusList =
		 * this.eventStatusService.findAllEvents(); Assert.assertEquals(2,
		 * newEventStatusList.size());
		 */
	}

}
