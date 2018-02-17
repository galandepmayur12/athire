package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.EHR.allContent.daoLayer.ApplyDao;
import com.EHR.allContent.daoLayer.JobsDao;
import com.EHR.allContent.module.Jobs;


public class JobResource {
	
	JobsDao jobsDao = new JobsDao();
	ApplyDao applyDao = new ApplyDao();
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Jobs> getAllJobs(@PathParam("userId") long userId) {
		try {
//			System.out.println(jobsDao.getUserJobs(userId));
			return jobsDao.getUserJobs(userId);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/applied-for")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jobs> getApplications(@PathParam("userId") long userId){
		
		try {
			return applyDao.allJobApplication(userId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/{jobId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Jobs getJob(@PathParam("userId") long userId, @PathParam("jobId") long jobId) {
		
		try {
			return jobsDao.getJob(jobId);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	@Path("/{jobId}/apply")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response applyFor(@PathParam("userId") long userId, @PathParam("jobId") long jobId) {
		
		boolean result = false;
		
		try {
			result = applyDao.applyForJob(jobId, userId);
			if(result == true) {
				return Response.status(Status.CREATED)
						.entity("Sucessfully Applied!!")
						.build();
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(Status.NOT_MODIFIED)
				.entity("Unable to apply for the Job try again!!")
				.build();
	}
	
	@Path("/job-search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Jobs> getAllEligbleJobs(@PathParam("userId") long userId){
		try {
			return jobsDao.getJobList(userId);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/{jobId}/cancel")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cancelJob(@PathParam("userId") long userId, @PathParam("jobId") long jobId) {
		
		boolean result = false;
		
		try {
			applyDao.removeApplication(jobId, userId);
			if(result == true) {
				return Response.status(Status.NOT_MODIFIED)
						.entity("Sucessfully Application Deleted!!")
						.build();
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(Status.NOT_MODIFIED)
				.entity("Unable to cancel the application for the Job try again!!")
				.build();
		
	}

}
