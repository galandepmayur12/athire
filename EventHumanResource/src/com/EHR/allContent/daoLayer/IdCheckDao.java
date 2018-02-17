package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EHR.allContent.connector.Connector;

public class IdCheckDao {
	
	
	public static boolean chk(long id, String table_name , String id_name ) throws SQLException {
		Connector dbConnection = new Connector();
		Connection con = null;
		Statement st = null;
		
		String query = "Select * from " + table_name + " where " + id_name + "=" + id ;
//		System.out.println(query);
		try {
			con = dbConnection.getConnection();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query) ;
		if(rs == null) {
			return false;
		}
		
		return true;
			
		
	}
}
