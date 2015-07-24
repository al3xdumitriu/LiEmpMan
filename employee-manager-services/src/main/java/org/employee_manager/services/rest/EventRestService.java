package org.employee_manager.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Event;
import org.employee_manager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("event")
public class EventRestService {

	@Autowired
	private EventService eventService;

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents(@QueryParam("name") String name) {

		List<Event> events = new ArrayList<Event>();
		Response res=null;
		int status = 200;
		if (name == null) {
			try {

				events = eventService.findAllEvents();
			} catch (Exception e) {
				status = 500;
				e.getStackTrace();
			}
			for (Event e : events) {
				e.setEventEvaluations(null);
				e.setOrganizers(null);
			}
			res = Response.status(status).entity(events).build();
		} else {
			Event event = eventService.findByName(name);
			if(event==null)
				status=204;
			else{
			event.setEventEvaluations(null);
			event.setOrganizers(null);
			}
			res = Response.status(status).entity(event).build();
		}
		return res;
	}

	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveEvent(Event event) {

		int status = 200;
		try {
			event = eventService.saveEvent(event);
		} catch (Exception e) {
			status = 500;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(event).build();
		return res;
	}

	@GET
	@Path("{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("param") String param) {

		Long id = Long.parseLong(param);
		Event event = null;
		int status = 200;
		try {
			event = eventService.findById(id);
			if (event == null)
				status = 204;
			else {
				event.setOrganizers(null);
				event.setEventEvaluations(null);
			}
		} catch (Exception e) {
			status = 500;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(event).build();
		return res;
	}

}
