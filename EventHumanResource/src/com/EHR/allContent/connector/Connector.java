package com.EHR.allContent.connector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
	public static Connection dbConnection = null;
	private String dbDriver; 
	private String connectionUrl;
	private String userName;
	private String password;
	
	public String getDbDriver() {
		return dbDriver;
	}
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}
	public String getConnectionUrl() {
		return connectionUrl;
	}
	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@SuppressWarnings("resource")
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		if(dbConnection != null ) {
			return dbConnection;
		}else {
			java.net.URL fileLocation = Connector.class.getResource("database.property");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation.getFile())));
			String line;
			while ((line = br.readLine()) != null) {
				if(line.contains("dbDriver")) {
					String[] dbd = line.split("=");
					setDbDriver(dbd[1]);
				}else if (line.contains("connectionUrl")) {
					String[] cUrl = line.split("=");
					setConnectionUrl(cUrl[1]);
				}else if (line.contains("userName")) {
					String[] uName = line.split("=");
					setUserName(uName[1]);
				}else {
					String[] pwd = line.split("=");
					setPassword(pwd[1]);
				}
				
			}
			
			Class.forName(getDbDriver());
			dbConnection = DriverManager.getConnection(getConnectionUrl(), getUserName(), getPassword()); 
			
		}
		return dbConnection;
		
	}
	
}
