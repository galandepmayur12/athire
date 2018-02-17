package com.EHR.allContent.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/welcome")
@Singleton
public class Welcom {
	private int count1;
	@GET
	@Produces(MediaType.TEXT_PLAIN)

	public String hello() {
		count1 += 1;
		return count1 + " hi";
	}
	
}
