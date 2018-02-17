package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.User;

public class UserDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs;
	String query,query1;
	
	public boolean emailCheck(String email) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from users where " + Constants.USERNAME + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setString(1, email);
		rs = pst.executeQuery();
		if(rs.next())
			return false;
		else
			return true;
		
		
	}
	
	public String username(long userId) throws SQLException, ClassNotFoundException, IOException {
		query = "select " + Constants.USERNAME + " from users where " + Constants.USER_ID + " = ?";
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getString(1);
		}
		return null;
	}
	
	public User getUserDetails(String email) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from users where " + Constants.USERNAME + " = ?";
		User user = new User();
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setString(1, email);
		rs = pst.executeQuery();
		while(rs.next()) {
			user.setUser_id(rs.getLong(1));
			user.setUsername(rs.getString(2));
			user.setUsertype(rs.getString(3));
		}
		
		return user;
	}
	
	public String userType(long userId) throws SQLException, ClassNotFoundException, IOException {
		query = "select " + Constants.USER_TYPE + " from users where " + Constants.USER_ID + " = ?";
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getString(1);
		}
		return "";
	}
	
	public boolean updatePassword(long userId, String newPassword) throws ClassNotFoundException, IOException, SQLException {
		
		query = "update credential set" + Constants.PASSWORD + " = ? where " + Constants.USER_ID + " = ?";
		
		con = dbConnector.getConnection();
		pst = con.prepareStatement(query);
		pst.setString(1, newPassword);
		pst.setLong(2, userId);
		int affected = pst.executeUpdate();
		
		if(affected > 0) {
			return true;
		}else {
			return false;
		}
	}

}
