package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.Credentials;
import com.EHR.allContent.resources.Mailer;

public class CredentialDao {
	 Connector dbconnector = new Connector();
	 Connection con = null;
	 Statement st = null;
	 PreparedStatement pst = null;
	 String query,query1;
	 ResultSet rs;

	 public long validateLoginCredential(String username, String password) throws ClassNotFoundException, IOException, SQLException {
		 
		 query = "select password,user_id from credential where " + Constants.USERNAME + " = ?";
		 
		 con = dbconnector.getConnection();
		 
		 pst = con.prepareStatement(query);
		 pst.setString(1, username);
		 rs = pst.executeQuery();
		 //System.out.println(username);
		 while(rs.next()) {
			 //System.out.println(rs.getString(1) + password);
			 if(rs.getString(1).equals(password)) {
				 //System.out.println(rs.getLong(2) + "hello");
				 return rs.getLong(2); 
		 	}
		 }
		 System.out.println("asdfklh");
		 return -1l;
	 }
	 
	 public boolean insertCredential(Credentials credentials) throws ClassNotFoundException, IOException, SQLException {
		 
		 query = "insert into credential values(?,?,?)";
		 
		 con = dbconnector.getConnection();
		 
		 pst = con.prepareStatement(query);
		 pst.setLong(1, credentials.getUserId());
		 pst.setString(2, credentials.getUsername());
		 pst.setString(3, credentials.getPassword());
		 int affected = pst.executeUpdate();
		 if(affected > 0)
			 return true;
		 else 
			 return false;
	 }
	 
	 public boolean updateCredential(Credentials credentials, long userId) throws ClassNotFoundException, IOException, SQLException {
		 
		 query = "update credential set " + Constants.PASSWORD + " = ? where " + Constants.USER_ID + " = ?";
		 
		 con = dbconnector.getConnection();
		 
		 pst = con.prepareStatement(query);
		 pst.setString(1, credentials.getPassword());
		 pst.setLong(2, userId);
		 int affected = pst.executeUpdate();
		 if(affected > 0)
			 return true;
		 else 
			 return false;
		 
	 }
	 
	 public boolean updatePassword(String newPassword, String username) throws ClassNotFoundException, IOException, SQLException {
		 
		 query = "update credential set " + Constants.PASSWORD + " = ? where " + Constants.USERNAME + " = ?";
		 
		 con = dbconnector.getConnection();
		 
		 pst = con.prepareStatement(query);
		 pst.setString(1, newPassword);
		 pst.setString(2, username);
		 int affected = pst.executeUpdate();
		 if(affected > 0) {
			 Mailer.send(Constants.COMPANY_EMAIL, Constants.COMPANY_PASSWORD, username, "Password Change!!", "Hello, this mail is regarding your password change" + System.lineSeparator() + 
					  "On your request your password is been changed." + System.lineSeparator() + "Your new password is," + System.lineSeparator() + newPassword);
			 return true;
		 }else 
			 return false;
		 
	 }
	 
	 public boolean checkPassword(long userId, String password) throws ClassNotFoundException, IOException, SQLException {
		 
		 query = "select " + Constants.PASSWORD + " from credential where " + Constants.USER_ID + " = ?";
		 
		 con = dbconnector.getConnection();
		 pst = con.prepareStatement(query);
		 pst.setLong(1, userId);
		 rs = pst.executeQuery();
		 while(rs.next()) {
			 if(password.equals(rs.getString(1))) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	public boolean updatePassword(long userId, String newPassword) throws ClassNotFoundException, IOException, SQLException {
			
		query = "update credential set " + Constants.PASSWORD + " = ? where " + Constants.USER_ID + " = ?";
		
		con = dbconnector.getConnection();
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
