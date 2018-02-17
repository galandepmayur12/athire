package com.EHR.allContent.module;

public class SessionInfo {
	
	private long userId;
	private String username;
	private String token;
	
	
	public SessionInfo() {
		super();
	}

	public SessionInfo(long userId, String username, String token) {
		super();
		this.userId = userId;
		this.username = username;
		this.token = token;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	

}
