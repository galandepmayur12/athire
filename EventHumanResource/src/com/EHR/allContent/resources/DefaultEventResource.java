package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.EHR.allContent.daoLayer.DefaultPackageDao;
import com.EHR.allContent.module.DefaultPackage;

@Path("/default-package")
public class DefaultEventResource {
	
	ArrayList<DefaultPackage> defaultPackages = new ArrayList<>();
	DefaultPackageDao defaultPackageDao = new DefaultPackageDao();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDefaultPackageDetails() {
		try {
			return Response.ok()
					.entity(defaultPackageDao.getAllPackages())
					.build();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok()
				.entity("unable to connect")
				.build();
	}
	
	@Path("/{packageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDefaultPackageDetails(@PathParam("packageId") long packageId) {
		try {
			return Response.ok()
					.entity(defaultPackageDao.getDefaultPackage(packageId))
					.build();
			 
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(Status.NOT_FOUND)
				.entity("No package exists for this Package id!!")
				.build();
	}
	
}
