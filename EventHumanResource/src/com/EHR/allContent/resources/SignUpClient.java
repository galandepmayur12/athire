package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.EHR.allContent.daoLayer.ClientDao;
import com.EHR.allContent.module.Address;
import com.EHR.allContent.module.Date;
import com.EHR.allContent.module.Name;
import com.EHR.allContent.module.User_Client;


@Path("/SignUpClient")
public class SignUpClient {
	
	ClientDao clientDao = new ClientDao();
	User_Client user_client = new User_Client();

	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createClientFromForm(@BeanParam SignUpInputClient client) {
//		System.out.println("hello");
		Address address = new Address();
//		System.out.println(f_name);
		address.setAdd_line1(client.getAdd_line1());
		address.setAdd_line2(client.getAdd_line2());
		address.setCity(client.getCity());
		address.setCountry(client.getCountry());
		address.setState(client.getState());
		address.setStreet_name(client.getStreet_name());
		address.setZipcode(client.getZipcode());
		
		user_client.setEmail_id(client.getEmail_id());
		user_client.setClient_id(0l);
		user_client.setComp_name(client.getComp_name());
		user_client.setClient_name(new Name(client.getF_name() + " " + client.getM_name() + " " + client.getL_name()));
		user_client.setAddress(new Address(client.getAdd_line1(), client.getAdd_line2(), client.getStreet_name(), client.getCity(), client.getState(), client.getCountry(), client.getZipcode()));
		user_client.setDob(new Date(client.getDd(), client.getMm(), client.getYyyy()));
		
    	System.out.println(client.getPh_no());
    	ArrayList<Long> pHONEBOOK = new ArrayList<>();
 		pHONEBOOK.add(948748l);
 		pHONEBOOK.add(45674748l);
 		
		user_client.setPh_no(pHONEBOOK);
		System.out.println(user_client.toString());
		try {System.out.println("hello");
			clientDao.addClient(user_client);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createClientFromJson(User_Client user_Client) {
		System.out.println("hella");
		System.out.println(user_Client.toString());
		try {
			clientDao.addClient(user_Client);
			return Response.status(Response.Status.CREATED)
		            .entity("User Profile Created!!")
		            .build();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		finally {
			
		}
//		System.out.println(user_Client.toString() + "json" );
		return Response.status(Response.Status.NOT_ACCEPTABLE)
	            .entity("User Data exists!!")
	            .build();
	}
	


}
