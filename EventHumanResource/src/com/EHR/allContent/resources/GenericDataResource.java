package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.EHR.allContent.daoLayer.ClientDao;
import com.EHR.allContent.daoLayer.CredentialDao;
import com.EHR.allContent.daoLayer.EventLogDao;
import com.EHR.allContent.daoLayer.FreeLancerDao;
import com.EHR.allContent.daoLayer.SkillSetDao;
import com.EHR.allContent.module.EventLog;
import com.EHR.allContent.module.User_Client;
import com.EHR.allContent.module.User_FreeLancer;

@Path("/{Id}")
public class GenericDataResource {

	EventLogDao eventLogDao = new EventLogDao();
	FreeLancerDao freeLancerDao = new FreeLancerDao();
	ClientDao clientDao = new ClientDao();
	SkillSetDao skillSetDao = new SkillSetDao();
	CredentialDao credentialDao = new CredentialDao();
	@Path("/event")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EventLog getEventDetails(@PathParam("Id") long eventId ) {
		try {
			//Mailer.send("humanresourceservices1246@gmail.com", "miniteitb3", "mayurthetecy.12@gmail.com", "yolo", "check");
			return eventLogDao.getSingleEventLog(eventId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/client")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User_Client getClientDetails(@PathParam("Id") long clientId ) {
		try {
			//Mailer.send("humanresourceservices1246@gmail.com", "miniteitb3", "mayurthetecy.12@gmail.com", "yolo", "check");
			return clientDao.getClient(clientId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/freelancer")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User_FreeLancer getFreeLancerDetails(@PathParam("Id") long freeLancerId ) {
		try {
			return freeLancerDao.getFreeLancer(freeLancerId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/skillset")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSkillDetails(@PathParam("Id") long skillId) {
		try {
			return skillSetDao.getSkillNameById(skillId);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
