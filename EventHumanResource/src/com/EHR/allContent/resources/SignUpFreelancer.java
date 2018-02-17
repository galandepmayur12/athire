package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.EHR.allContent.daoLayer.FreeLancerDao;
import com.EHR.allContent.module.Address;
import com.EHR.allContent.module.Date;
import com.EHR.allContent.module.Name;
import com.EHR.allContent.module.User_FreeLancer;

@Path("/SignUpFreelancer")
public class SignUpFreelancer {
	
	
	FreeLancerDao freelancerDao = new FreeLancerDao();
	User_FreeLancer user_freelancer = new User_FreeLancer();
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public Response createFreelancer(@BeanParam SignUpInputFreelancer freelancer) {
		
		Address address = new Address();
		address.setAdd_line1(freelancer.getAdd_line1());
		address.setAdd_line2(freelancer.getAdd_line2());
		address.setCity(freelancer.getCity());
		address.setCountry(freelancer.getCountry());
		address.setState(freelancer.getState());
		address.setStreet_name(freelancer.getStreet_name());
		address.setZipcode(freelancer.getZipcode());
		
		user_freelancer.setEmail_id(freelancer.getEmail_id());
		user_freelancer.setFreeLancer_id(0l);
		user_freelancer.setWork_environment(freelancer.getWork_environment());
		user_freelancer.setFreelancer_name(new Name(freelancer.getF_name() + " " + freelancer.getM_name() + " " + freelancer.getL_name()));
		user_freelancer.setAddress(address);
		user_freelancer.setDob(new Date(freelancer.getDd(), freelancer.getMm(), freelancer.getYyyy()));
		try {
			freelancerDao.createFreeLancer(user_freelancer);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response	createFreelancerFromJson(User_FreeLancer user_FreeLancer) {
		
		try {
			freelancerDao.createFreeLancer(user_FreeLancer);
			return Response.status(Response.Status.CREATED)
		            .entity("User Profile Created!!")
		            .build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(Status.NOT_IMPLEMENTED)
				.entity("Unable to update your profiile Try again!!")
				.build();
	}

}
