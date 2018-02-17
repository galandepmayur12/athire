package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.EHR.allContent.daoLayer.EventLogDao;
import com.EHR.allContent.module.EventLog;


public class EventResource {
	
	EventLogDao eventDao = new EventLogDao();
//	EventLog eventLog = new EventLog(100l, 0l, "jsdh", "sfad", "asdh", new Date(12, 02, 1998), "hju", "jkg", "hu", null, 165);
	
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<EventLog> getEvent(@PathParam("userId") Long userId) throws ClassNotFoundException, SQLException, IOException {  
		return eventDao.getUserEvents(userId);
	}
	
	@Path("/createEvent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEvent(@PathParam("userId") long userId, EventLog eventLog) {
		System.out.println(eventLog.toString());
		try {
			eventDao.createEventLog(userId, eventLog);
			return Response.ok()
					.entity("Event Created Successfully!!")
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.ok()
				.entity("Unable to create event try again!!")
				.build();
		
	}
	
	@Path("/{eventId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EventLog getEvent(@PathParam("eventId") long eventId, @PathParam("userId") long userId) {
		
		try {
			return eventDao.getEventLog(eventId,userId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/{eventId}/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEvent(@PathParam("eventId") long eventId, @PathParam("userId") long userId, EventLog eventLog) {
		
		try {
			eventDao.updateEventLog(eventId, eventLog);
			return Response.ok()
					.entity("Event details updated successfully!!")
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(Status.NOT_MODIFIED)
			.entity("Unable to modfiy event details try again!!")
			.build();
		
	}
	
	@Path("/{eventId}/delete")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEvent(@PathParam("eventId") long eventId, @PathParam("userId") long userId) {
		
		try {
			eventDao.deleteEventLog(eventId);
			return Response.ok()
					.entity("Event deleted successfully!!")
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(Status.NOT_MODIFIED)
				.entity("Unable to delete event details try again!!")
				.build();
		
	}
}
