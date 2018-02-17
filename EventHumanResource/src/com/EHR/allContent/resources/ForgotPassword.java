package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.EHR.allContent.daoLayer.CredentialDao;
import com.EHR.allContent.module.RandomString;

@Path("/forgot-password")
public class ForgotPassword {
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	public Response setNewPassword(@QueryParam("username") String username) {
		
		RandomString randomString = new RandomString();
		CredentialDao credentialDao = new CredentialDao();
		
		try {
			credentialDao.updatePassword(randomString.randomString(6), username);
			return Response.ok()
					.entity("Password Changed Successfully!!")
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.ok()
					.entity("Unable to change password. Try Again!!")
					.build();
		}
		
	}
	
}
