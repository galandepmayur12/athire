package com.EHR.allContent.module;

public class User {
	
	private long user_id;
	private String username;
	private String usertype;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public User(long user_id, String username, String usertype) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.usertype = usertype;
	}
	public User() {
		super();
	}

	
	
}
