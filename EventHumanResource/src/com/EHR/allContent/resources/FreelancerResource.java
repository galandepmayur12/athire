package com.EHR.allContent.resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.internal.util.Base64;

import com.EHR.allContent.daoLayer.CredentialDao;
import com.EHR.allContent.daoLayer.FreeLancerDao;

import com.EHR.allContent.module.User_FreeLancer;


public class FreelancerResource {
	
	FreeLancerDao freelancerDao = new FreeLancerDao();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response freelancerProfilePage() {
		java.net.URI location = null;
		try {
			System.out.println("html waala");
			location = new java.net.URI("../Employee_profile.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location)
					.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User_FreeLancer getFreelancer(@PathParam("userId") long userId) {
		
		try {
			return freelancerDao.getFreeLancer(userId);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@PUT
	@Path("/updatePassword")
	public Response updatePassword(@HeaderParam("PasswordChange") String passwords, @PathParam("userId") long user_id) throws ClassNotFoundException, IOException, SQLException {
		CredentialDao credentialDao = new CredentialDao();
		String decodedString = Base64.decodeAsString(passwords);
		StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
		String oldPassword = tokenizer.nextToken();
		String newPassword = tokenizer.nextToken();
		if(credentialDao.checkPassword(user_id, oldPassword)) {
			boolean result = credentialDao.updatePassword(user_id, newPassword);
			
			if (result) {
				return Response.ok().entity("Password changed Successfully!!").build();
			}else {
				return Response.ok()
						.entity("Sorry Unable to update your password please try again!!!")
						.build(); 
			}
		}else {
			return Response.ok()
					.entity("Enter Correct old password!!")
					.build();
		}
	}
	
	@Path("/update-profile")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("userId") long userId, User_FreeLancer user_freelancer) {
		try {
			System.out.println("in freelancer update");
			freelancerDao.updateFreeLancer(userId, user_freelancer);
			return Response.ok()
					.entity("Updated profiile Successfully!!")
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok()
				.entity("Unable to update your profiile Try again!!")
				.build();
	}
	
	@Path("/jobs")
	public JobResource getJobDetails() {
		
		return new JobResource();
		
	}
	
	@Path("/delete")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFreelancer(@PathParam("userId") long userId) {
		try {
			freelancerDao.deleteFreeLancer(userId);
			return Response.ok()
					.entity("Profiile Deleted Successfully!!")
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(Status.NOT_IMPLEMENTED)
				.entity("Unable to update your profiile Try again!!")
				.build();
	}
	
	@Path("/logout")
	public Logout logoutUser() {
		
		return new Logout();
	}

	
}
