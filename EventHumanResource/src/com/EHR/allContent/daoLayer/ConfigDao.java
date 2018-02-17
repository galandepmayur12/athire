package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.EHR.allContent.connector.Connector;

public class ConfigDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	String query;
	
	public void setEventScheduler() throws ClassNotFoundException, IOException, SQLException {
		
		query = " SET GLOBAL event_scheduler = ON ";
		
		con = dbConnector.getConnection();
		st = con.createStatement();
		st.executeUpdate(query);
		
		
	}

}
