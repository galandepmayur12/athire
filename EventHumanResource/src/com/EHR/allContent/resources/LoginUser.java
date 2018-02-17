package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

import com.EHR.allContent.daoLayer.ClientDao;
import com.EHR.allContent.daoLayer.ConfigDao;
import com.EHR.allContent.daoLayer.FreeLancerDao;
import com.EHR.allContent.daoLayer.NotificationDao;
import com.EHR.allContent.daoLayer.SessionDao;
import com.EHR.allContent.daoLayer.UserDao;
import com.EHR.allContent.module.User;
//import com.EHR.allContent.module.SessionInfo;
import com.EHR.allContent.module.User_Client;
import com.EHR.allContent.module.User_FreeLancer;

@Path("/login/verify-user")  
public class LoginUser {
	
	SessionDao sessionDao = new SessionDao();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginDetails(@QueryParam("username") String username, @CookieParam("Session") Cookie cookie) throws ClassNotFoundException, IOException, SQLException {
		
		ClientDao clientDao = new ClientDao();
		FreeLancerDao freeLancerDao = new FreeLancerDao();
		User_FreeLancer user_FreeLancer = new User_FreeLancer();
		UserDao userDao = new UserDao();
		User user = new User();
		User_Client user_Client = new User_Client();
		ConfigDao configDao = new ConfigDao();
		NotificationDao notificationDao = new NotificationDao();
		
		user = userDao.getUserDetails(username); 
		notificationDao.getNotifications(user.getUser_id());
		String url = "http://localhost:8080/EventHumanResource/rest/user/" + user.getUser_id() + "/" + user.getUsertype();
		String token = Base64.encodeAsString(sessionDao.addSession(user.getUser_id(), username));
		
		if (user.getUsertype().equals("client")) {
			
			user_Client = clientDao.getClient(user.getUser_id());
			//		return new SessionInfo(clientDao.getUserId(username), username, token);
			//String value = "Token " + token;
			//System.out.println(value);
			//		if(cookie != null ) {
			//			return Response
			//	                .ok()
			//	                .cookie(new NewCookie("Session", value))
			//	                .build();
			//		}
			//Cookie cookie2 = new NewCookie("Session", token);
			
			//		System.out.println(cookie.toString());
			user_Client.setUrl(url);
			configDao.setEventScheduler();
			return Response.ok().cookie(new NewCookie("Session", token, "/", "localhost", 1, "session token cookie",
					1500, null, false, true)).entity(user_Client).build();
			
			//return Response.ok().cookie(new NewCookie(cookie2, "session token cookie", 600, false)).build();
			//return Response.ok().cookie(new NewCookie("Session", token, "/EventHumanResource/User", "localhost", 1, "session token cookie", 600, null, true, true)).build();
		} else {			
			user_FreeLancer = freeLancerDao.getFreeLancer(user.getUser_id());
//			String url = "http://localhost:8080/EventHumanResource/rest/user/" + user.getUser_id() + "/"
//					+ user.getUsertype();
			//		System.out.println(cookie.toString());
			user_FreeLancer.setUrl(url);
			return Response.ok().cookie(new NewCookie("Session", token, "/", "localhost", 1, "session token cookie",
					1500, null, false, true)).entity(user_FreeLancer).build();
		}
	}
	


}
