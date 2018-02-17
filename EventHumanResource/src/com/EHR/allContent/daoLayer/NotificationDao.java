package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.Notification;
import com.EHR.allContent.resources.Mailer;

public class NotificationDao {

	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String query,query1;
	UserDao userDao = new UserDao();
	FreeLancerDao freeLancerDao = new FreeLancerDao();
	JobsDao jobDao = new JobsDao();
	
	
	
	@SuppressWarnings("null")
	public ArrayList<Notification> getNotifications(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from notification_table where " + Constants.USER_ID + " = ? and " + Constants.NOTIFICATION_STATUS + " ='Not Seen'";  
		UserDao userDao = new UserDao();
		System.out.println("Query" + System.lineSeparator() + query);
		ArrayList<Notification> allNoti = new ArrayList<>();
		//System.out.println(userId);
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		if(rs != null) {
			
			while(rs.next()) {
				allNoti.add(new Notification(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
			}
			int i = 1;
			String message = "Hello, Your notifications ";
			for(Notification notification : allNoti) {
				String addon = "";
				if(userDao.userType(jobDao.getAllotedUserId(notification.getNotification_ref_id())).equals("freelancer")) {
					addon = "FreeLancer Details:" + System.lineSeparator() + "Name: " + freeLancerDao.getName(jobDao.getAllotedUserId(notification.getNotification_ref_id())) +
						 System.lineSeparator() + "Contact Details: " + freeLancerDao.getContact(jobDao.getAllotedUserId(notification.getNotification_ref_id()));
					
							
				}
				message = message + System.lineSeparator() + i + ". " + notification.getNotification_desc() + System.lineSeparator() + " reference id:" + notification.getNotification_ref_id() + System.lineSeparator() + addon;	
				System.out.println(message);
				setNotificationStatus(notification.getNotification_id());
				i++;
			}
			System.out.println(message);
			if(!message.equals("Hello, Your notifications "))
				Mailer.send(Constants.COMPANY_EMAIL, Constants.COMPANY_PASSWORD, userDao.username(userId), "Notification", message);
			return allNoti;
		}
		
		return null;
		
		
	}
	
	public void setNotificationStatus(long notificationId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "update notification_table set " + Constants.NOTIFICATION_STATUS + " ='Seen' where " + Constants.NOTIFICATION_ID + " = ?"; 
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, notificationId);
		pst.executeUpdate();
		
		
	}
	
	public void setAllNotificationStatus(ArrayList<Long> notificationIds) throws SQLException {
		
		query = "update notification_table set " + Constants.NOTIFICATION_STATUS + " ='Seen' where " + Constants.NOTIFICATION_ID + " = ?"; 
		
		for (long ids : notificationIds) {
			pst = con.prepareStatement(query);
			pst.setLong(1, ids);
			pst.executeUpdate();
		}
	}
}
