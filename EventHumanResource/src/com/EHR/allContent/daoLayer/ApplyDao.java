package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.ApplyRecords;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.Date;
import com.EHR.allContent.module.Jobs;


public class ApplyDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs;
	String query,query1;
	FreeLancerDao freeLancerDao = new FreeLancerDao();
	
	public boolean applyForJob(long jobId, long freelancerId) throws ClassNotFoundException, IOException, SQLException {
		
		query = " insert into apply_table (" + Constants.JOB_ID + "," + Constants.FREELANCER_ID + "," + Constants.BID + ") values(?,?,?)";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, jobId);
		pst.setLong(2, freelancerId);
		pst.setInt(3, 786);
		int affected = pst.executeUpdate();
		
		if (affected > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeApplication(long jobId, long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "delete from apply_table where " + Constants.JOB_ID + " = ? and " + Constants.FREELANCER_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, jobId);
		pst.setLong(2, userId);
		int affected = pst.executeUpdate();
		if (affected > 0) {
			return true;
		} else {
			return false;
		}
	}
	//public List<Jobs> allJobApplicationDetails
	
	public Set<Long> allApplicationJobId(long userId) throws ClassNotFoundException, IOException, SQLException{
		query = "select " + Constants.JOB_ID + " from apply_table where " + Constants.FREELANCER_ID + " = ? ";
		Set<Long> jobIds = new HashSet<>(); 
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			jobIds.add(rs.getLong(1));
		}
		
		return jobIds;
	}
	
	@SuppressWarnings("deprecation")
	public List<Jobs> allJobApplication(long userId) throws SQLException, ClassNotFoundException, IOException{
		
		query = "select * from apply_table where " + Constants.FREELANCER_ID + " = ?";
		query1 = "select * from jobs where " + Constants.JOB_ID + " = ?";
		List<ApplyRecords> applyRecords = new ArrayList<>();
		List<Jobs> allJobDetails = new ArrayList<>();
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
			while (rs.next()) {
// 				System.out.println("hello");
				applyRecords.add(new ApplyRecords(rs.getLong(1), rs.getLong(2), null, null, rs.getInt(4)));
			}
		for (ApplyRecords records : applyRecords) {
			pst = con.prepareStatement(query1);
			pst.setLong(1, records.getJob_id());
			rs = pst.executeQuery();
			while(rs.next()) {
				allJobDetails.add(new Jobs(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), 
						new Date(rs.getDate(7).getDate(),(rs.getDate(7).getMonth())+1,(rs.getDate(7).getYear())+1900), rs.getLong(8), rs.getLong(9), rs.getInt(10), rs.getLong(11),rs.getString(12)));
			}
		}
	
	
		return allJobDetails;
	}

}
