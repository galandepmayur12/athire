package com.EHR.allContent.resources;

import javax.ws.rs.QueryParam;

public class ValidityBean {
	private @QueryParam("email_id") String email_id;
	private @QueryParam("password") String password;
	private @QueryParam("zipcode") String zipcode;
	private @QueryParam("date") String date;
	private @QueryParam("dd") String dd;
	private @QueryParam("mm") String mm;
	private @QueryParam("yyyy") String yyyy;
	private @QueryParam("mob") String mob;
	private @QueryParam("email_id1") String email_id1;
	
	public String getEmail_id1() {
		return email_id1;
	}
	public void setEmail_id1(String email_id1) {
		this.email_id1 = email_id1;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getYyyy() {
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
