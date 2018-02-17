package com.EHR.allContent.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;



@Path("/user")
public class UserResource {
	
	@Path("/{userId}/freelancer")
	public FreelancerResource getFreelancerProfile(@PathParam("userId") long user_id) {
		
		return new FreelancerResource();
		
	}
	
	@Path("/{userId}/client")
	public ClientResource getClientProfile(@PathParam("userId") long user_id) {
		
		return new ClientResource();
		
	}
	

	
}
