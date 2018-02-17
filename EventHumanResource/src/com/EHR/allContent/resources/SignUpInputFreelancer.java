package com.EHR.allContent.resources;


import javax.ws.rs.FormParam;


public class SignUpInputFreelancer {

	
	private @FormParam("f_name") long f_name;
	private @FormParam("l_name") long l_name;
	private @FormParam("m_name") long m_name;
	private @FormParam("email_id") String email_id;
	private @FormParam("add_line1") String add_line1;
	private @FormParam("add_line2") String add_line2;
	private @FormParam("street_name") String street_name;
	private @FormParam("city") String city;
	private @FormParam("state") String  state;
	private @FormParam("country") String country;
	private @FormParam("zipcode") int zipcode;
	private @FormParam("dd") int dd;
	private @FormParam("mm") int mm;
	private @FormParam("yyyy") int yyyy;
//	private ArrayList<Long> ph_no;
	@FormParam("work_environment") String work_environment;
//	private ArrayList<Long> ph_no;
//	private ArrayList<SkillSet> skills;
	public long getF_name() {
		return f_name;
	}
	public void setF_name(long f_name) {
		this.f_name = f_name;
	}
	public long getL_name() {
		return l_name;
	}
	public void setL_name(long l_name) {
		this.l_name = l_name;
	}
	public long getM_name() {
		return m_name;
	}
	public void setM_name(long m_name) {
		this.m_name = m_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAdd_line1() {
		return add_line1;
	}
	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}
	public String getAdd_line2() {
		return add_line2;
	}
	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getDd() {
		return dd;
	}
	public void setDd(int dd) {
		this.dd = dd;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getYyyy() {
		return yyyy;
	}
	public void setYyyy(int yyyy) {
		this.yyyy = yyyy;
	}
	public String getWork_environment() {
		return work_environment;
	}
	public void setWork_environment(String work_environment) {
		this.work_environment = work_environment;
	}
	

}
