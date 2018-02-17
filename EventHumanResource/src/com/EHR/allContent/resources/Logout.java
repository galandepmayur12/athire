package com.EHR.allContent.resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.EHR.allContent.daoLayer.SessionDao;


public class Logout {
	
	SessionDao sessionDao = new SessionDao();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response logout(@PathParam("userId") long userId, @CookieParam("Session") Cookie sessionToken) throws URISyntaxException {
		
		SessionDao sessionDao = new SessionDao();
//		return username;
		
		try {
			sessionDao.deleteToken(userId);
			System.out.println("hella");
//			return Response.ok()
//					.entity("logout successfull")
//					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		java.net.URI location = new java.net.URI("http://localhost:8080/EventHumanResource/index.html");
//		System.out.println(location);
//		return Response
//				.temporaryRedirect(location)
//				.build();
		if (sessionToken != null){
		
	        NewCookie newCookie = new NewCookie("Session", "", "/", null, null, 0, false);
	        return Response.ok()
				.entity("logout done successfully!!")
				.cookie(newCookie)
				.build();
		
			}
		 return Response.ok().build();
	
	
	}

}
