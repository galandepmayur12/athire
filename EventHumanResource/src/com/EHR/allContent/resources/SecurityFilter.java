package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

//import javax.ws.rs.CookieParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
//import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.internal.util.Base64;

import com.EHR.allContent.daoLayer.CredentialDao;
import com.EHR.allContent.daoLayer.SessionDao;
import com.EHR.allContent.module.User_Client;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization"; 
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic "; 
	private static final String SECURED_URL_PREFIX = "login";
	private static final String SECURED_USER_PREFIX = "user";
	private static final String SESSION_HEADER_KEY = "Session";
//	private static final String AUTHORIZED_SESSION_HEADER_PREFIX = "Token ";
	long userId;
	
	CredentialDao credentialDao = new CredentialDao();
	SessionDao sessionDao = new SessionDao();
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException,NullPointerException {
		// TODO Auto-generated method stub
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				System.out.println(username + password);
				try {
					userId = credentialDao.validateLoginCredential(username, password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (userId != -1l) {
//					System.out.println(userId);
					return;
				}
				
			}
			
			//Response redirect = Response.ok().
			
			Response unauthorizedStatus = Response
											.status(Response.Status.OK)
								    		.entity(new User_Client("wrong email and password"))
								            .build();
					
			requestContext.abortWith(unauthorizedStatus);
			

		}
//		else if (requestContext.getUriInfo().getPath().contains(SECURED_USER_PREFIX)) {
//			List<String> authHeader = requestContext.getHeaders().get(SESSION_HEADER_KEY);
//			if (authHeader != null && authHeader.size() > 0) {
//				String authToken = authHeader.get(0);
//				authToken = authToken.replaceFirst(AUTHORIZED_SESSION_HEADER_PREFIX, "");
//				String decodedString = Base64.decodeAsString(authToken);
//				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
//				long userid = Long.parseLong(tokenizer.nextToken());
//				String token = tokenizer.nextToken();
//                boolean result = false;
//				//				System.out.println(username + password);
//				try {
//					result = sessionDao.validateSessionDetails(userid, token);
//				} catch (ClassNotFoundException | SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				if (result) {
//					return;
//				}
//				
//			}
//			Response unauthorizedStatus = Response
//								            .status(Response.Status.UNAUTHORIZED)
//								            .entity("User need to login.")
//								            .build();
//					
//			requestContext.abortWith(unauthorizedStatus);
//		}
		
//		else if (requestContext.getUriInfo().getPath().contains(SECURED_USER_PREFIX)) {
//			List<String> authHeader = requestContext.getHeaders().get(SESSION_HEADER_KEY);
//			if (authHeader != null && authHeader.size() > 0) {
//				String authToken = authHeader.get(0);
//				authToken = authToken.replaceFirst(AUTHORIZED_SESSION_HEADER_PREFIX, "");
//				System.out.println(authToken + "hello");
//				String decodedString = Base64.decodeAsString(authToken);
//				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
//				long userid = Long.parseLong(tokenizer.nextToken());
//				String token = tokenizer.nextToken();
//                boolean result = false;
//				try {
//					result = sessionDao.validateSessionDetails(userid, token);
//				} catch (ClassNotFoundException | SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				if (result) {
//					return;
//				}
//				
//			}
//			Response unauthorizedStatus = Response
//								            .status(Response.Status.UNAUTHORIZED)
//								            .entity("User need to login.")
//								            .build();
//					
//			requestContext.abortWith(unauthorizedStatus);
//		}
		
		else if(requestContext.getUriInfo().getPath().contains(SECURED_USER_PREFIX)) {
//			@CookieParam("Session") Cookie cookie;
			
//			List<String> authHeader = requestContext.getHeaders().get(SESSION_HEADER_KEY);
			Cookie cookie = requestContext.getCookies().get(SESSION_HEADER_KEY);
//			String value = cookie.getValue();
//			System.out.println(authHeader.get(0));
//			if (authHeader != null && authHeader.size() > 0) {
			if(cookie != null) {
				String authToken = cookie.getValue();
//				System.out.println(authToken+"token");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				long userid = Long.parseLong(tokenizer.nextToken());
				String token = tokenizer.nextToken();
                boolean result = false;
				try {
					result = sessionDao.validateSessionDetails(userid, token);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (result) {
					return;
				}else {
					Response unauthorizedStatus = Response
				            .status(Response.Status.OK)
				            .entity("User need to login.")
				            .build();

					requestContext.abortWith(unauthorizedStatus);
				}
				
			}
			
			Response unauthorizedStatus = Response
		            .status(Response.Status.OK)
		            .entity("User need to login.")
		            .build();

			requestContext.abortWith(unauthorizedStatus);
		}
		
	} 
	
	

}
