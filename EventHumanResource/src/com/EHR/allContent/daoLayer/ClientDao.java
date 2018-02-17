package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Address;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.Credentials;
import com.EHR.allContent.module.Name;
import com.EHR.allContent.module.User_Client;
import com.EHR.allContent.resources.Mailer;



public class ClientDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
//	User_Client user_client = new User_Client();
	String query, query1, query2;
	ArrayList <Long> ph;
	ResultSet rs = null, rs1 = null;
	
	
	
	public boolean addClient(User_Client user_Client) throws SQLException, ClassNotFoundException, IOException {
		
//		query = "insert into client (" + Constants.CLIENT_ID + "," + Constants.F_NAME + "," + Constants.M_NAME + "," + Constants.L_NAME + "," + Constants.EMAIL_ID
//				+ "," + Constants.DOB + "," + Constants.COMP_NAME + ") values(?,?,?,?,?,?,?)";
//		System.out.println(query);
		query = "insert into client values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		query1 = "insert into phone_no values(?,?,?)";
		query2 = "insert into users values(?,?,?)";
		con = dbConnector.getConnection();
		boolean status = false;
		 ph = new ArrayList<>();
		ph = user_Client.getPh_no();
		long id = System.currentTimeMillis();
		CredentialDao credentialDao = new CredentialDao();
		
		do {
			
			status = IdCheckDao.chk(id, "client" , Constants.CLIENT_ID);
			
			if (status != true) {
				id++;
			}
		} while (status != true);
		
		
		pst = con.prepareStatement(query2);
		pst.setLong(1, id);
		pst.setString(2, user_Client.getEmail_id());
		pst.setString(3, "client");
		int affected1 = pst.executeUpdate();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, id);
		pst.setString(2, user_Client.getClient_name().getF_name());
		pst.setString(3, user_Client.getClient_name().getM_name());
		pst.setString(4, user_Client.getClient_name().getL_name());
		pst.setString(5, user_Client.getEmail_id());
		pst.setDate(6, Date.valueOf(user_Client.getDob().toString()));
		pst.setString(7, user_Client.getAddress().getAdd_line1());
		pst.setString(8, user_Client.getAddress().getAdd_line2());
		pst.setString(9, user_Client.getAddress().getStreet_name());
		pst.setString(10, user_Client.getAddress().getCity());
		pst.setString(11, user_Client.getAddress().getState());
		pst.setString(12, user_Client.getAddress().getCountry());
		pst.setInt(13, user_Client.getAddress().getZipcode());
		pst.setString(14, user_Client.getComp_name());
		int affected2 = pst.executeUpdate();
		
		
		
		int affected3 = 1;
	//	pst.close();
		for(long i:ph) {
			pst = con.prepareStatement(query1);
			pst.setLong(1, i);
			pst.setString(2, user_Client.getEmail_id());
			pst.setLong(3, id);
			affected3 = pst.executeUpdate();
//			pst.addBatch();
			if(affected3 == 0)
				affected3 = 0;
		}
		
		credentialDao.insertCredential(new Credentials(id, user_Client.getEmail_id(), user_Client.getPassword()));
		
		if ((affected1 > 0) && (affected2 > 0) && (affected3 > 0)) {
			Mailer.send(Constants.COMPANY_EMAIL, Constants.COMPANY_PASSWORD, user_Client.getEmail_id(), "Welcome", "Hi," + user_Client.getClient_name().toString() + " We are so glad you decided to try out HRS hope that u enjoy our services");
			return true;
		} else {
			return false;
		}
		
		
//		pst.executeBatch();		
		
		
	}

	public boolean updateClient(long userId, User_Client user_Client) throws ClassNotFoundException, IOException, SQLException {

		query = "update client set " + Constants.F_NAME + " = ? , " + Constants.M_NAME + " = ? , " +
				Constants.L_NAME + " = ? , " + Constants.DOB + " = ? , " + Constants.ADD_LINE1 + " = ? , " +
				Constants.ADD_LINE2 + " = ? , " + Constants.STREET_NAME + " = ? , " + Constants.CITY + " = ? , " +
				Constants.STATE + " = ? , " + Constants.COUNTRY + " = ? , " + Constants.ZIPCODE + " = ? , " +
				Constants.COMP_NAME + " = ?  where " + Constants.CLIENT_ID + " = ? " ;
		query1 = "insert into phone_no values(?,?,?)";
		query2 = "delete from phone_no where " + Constants.USER_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setString(1, user_Client.getClient_name().getF_name());
		pst.setString(2, user_Client.getClient_name().getM_name());
		pst.setString(3, user_Client.getClient_name().getL_name());
		pst.setDate(4, Date.valueOf(user_Client.getDob().toString()));
		pst.setString(5, user_Client.getAddress().getAdd_line1());
		pst.setString(6, user_Client.getAddress().getAdd_line2());
		pst.setString(7, user_Client.getAddress().getStreet_name());
		pst.setString(8, user_Client.getAddress().getCity());
		pst.setString(9, user_Client.getAddress().getState());
		pst.setString(10, user_Client.getAddress().getCountry());
		pst.setInt(11, user_Client.getAddress().getZipcode());
		pst.setString(12, user_Client.getComp_name());
		pst.setLong(13, userId);
		
		int affected = pst.executeUpdate();
		
		int affected2 = 0;
		pst = con.prepareStatement(query2);
		pst.setLong(1, userId);
		affected2 = pst.executeUpdate();
		
		int affected3 = 0;
		for(long i: user_Client.getPh_no()) {
			pst = con.prepareStatement(query1);
			pst.setLong(1, i);
			pst.setString(2, user_Client.getEmail_id());
			pst.setLong(3, userId);
			affected3 = pst.executeUpdate();
//			pst.addBatch();
			if(affected3 == 0)
				affected3 = 0;
		}
		
		if ((affected > 0) && (affected2 > 0) && (affected3 > 0)) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public boolean deleteClient(long userId) throws ClassNotFoundException, IOException, SQLException {

		query = "Delete from client where " + Constants.CLIENT_ID+ " = ? ";
		query1 = " Delete from users where "+ Constants.USER_ID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		int nrows = pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, userId);
		int nrows1 = pst.executeUpdate();
		
		if (nrows > 0 && nrows1 > 0) 
			return true;
		return false;
		
	}

	public long getUserId(String username) throws ClassNotFoundException, IOException, SQLException {
		
		query = " Select client_id from client where " + Constants.EMAIL_ID + " = '" + username + "'";
		
		con = dbConnector.getConnection();
		
		st = con.createStatement();
		rs = st.executeQuery(query);
		
		if(rs.next())
			return rs.getLong(1);
		return -1;
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public User_Client getClient(long userId) throws ClassNotFoundException, IOException, SQLException {
		

		User_Client user_client = new User_Client();
		Name nm = new Name();
		Address add = new Address();
		ArrayList<Long> ph = new ArrayList<>();
		com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date();
		query = " Select * from client where " + Constants.CLIENT_ID + " = " + userId;
		query1 = " Select * from phone_no where " + Constants.USER_ID + " = " + userId; 
		
		con = dbConnector.getConnection();
		st = con.createStatement();
		System.out.println("check0");
		rs = st.executeQuery(query);
		System.out.println("check1");
		if(rs != null) {
			System.out.println("check2");
			while(rs.next()) {
				
				user_client.setClient_id(rs.getLong(1));
				nm.setF_name(rs.getString(2));
				nm.setM_name(rs.getString(3));
				nm.setL_name(rs.getString(4));
				user_client.setClient_name(nm);
				user_client.setEmail_id(rs.getString(5));
				dt.setDd(rs.getDate(6).getDate());
				dt.setMm((rs.getDate(6).getMonth())+1);
				dt.setYyyy((rs.getDate(6).getYear())+1900);
				user_client.setDob(dt);  
				add.setAdd_line1(rs.getString(7));
				add.setAdd_line2(rs.getString(8));
				add.setStreet_name(rs.getString(9));
				add.setCity(rs.getString(10));
				add.setState(rs.getString(11));
				add.setCountry(rs.getString(12));
				add.setZipcode(rs.getInt(13));
				user_client.setAddress(add);
				user_client.setComp_name(rs.getString(14));
				
				
			}
			
			
			rs1 = st.executeQuery(query1);
			while(rs1.next()) {
				
				ph.add(rs1.getLong(1));
					
			}
			
			user_client.setPh_no(ph);
			System.out.println(user_client.toString());
			
			return user_client;

		}
		
		return null;
		
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
