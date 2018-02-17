package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.Date;
import com.EHR.allContent.module.FreeLancerSchedule;

public class FreeLancerScheduleDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs =null, rs1 = null;
	String query, query1;
	
	@SuppressWarnings("deprecation")
	public Set<FreeLancerSchedule> getSchedule(long userId) throws ClassNotFoundException, IOException, SQLException{
		
		query = "select * from freelancer_schedule where " + Constants.FREELANCER_ID + " = ?";
		Set<FreeLancerSchedule> freeLancerSchedules = new HashSet<>();
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			freeLancerSchedules.add(new FreeLancerSchedule(rs.getLong(1), rs.getLong(2), new Date(rs.getDate(3).getDate(), 
					(rs.getDate(3).getMonth())+1, (rs.getDate(3).getYear())+1900)));
		}
		
		return freeLancerSchedules;
		
	}

}
