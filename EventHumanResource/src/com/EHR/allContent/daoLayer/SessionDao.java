package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.RandomString;
 

public class SessionDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs;
	String query,query1;
	
	public String addSession(long userId, String username) throws ClassNotFoundException, IOException, SQLException {
		
		query = "insert into session_table (" + Constants.USER_ID + "," + Constants.TOKEN + "," + Constants.USERNAME + ") values(?,?,?)";
		RandomString randomString = new RandomString();
		String token = randomString.randomString(7);
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		pst.setString(2, token);
		pst.setString(3, username);
		
		pst.executeUpdate();
		
		return userId + ":" + token;
	}
	
	public boolean deleteToken(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "delete from session_table where " + Constants.USER_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		int result = pst.executeUpdate();
		if(result == 0)
			return false;
		return true;
	}
	
	public boolean validateSessionDetails(long userId, String token) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from session_table where " + Constants.USER_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		if(rs.next()) {
			if(token.equals(rs.getString(2))) {
				//System.out.println(rs.getString(2)+"hello");
				return true;
			}
		}
		return false;
		
	}
	
}
