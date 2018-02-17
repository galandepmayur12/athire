package com.EHR.allContent.resources;

import java.util.ArrayList;

//import java.util.ArrayList;

import javax.ws.rs.FormParam;


public class SignUpInputClient {

	private	@FormParam("f_name") String f_name;
	private @FormParam("l_name") String l_name;
	private @FormParam("m_name") String m_name;
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
	private @FormParam("ph_no") ArrayList<Long> ph_no;
	public ArrayList<Long> getPh_no() {
		return ph_no;
	}
	public void setPh_no(ArrayList<Long> ph_no) {
		this.ph_no = ph_no;
	}
	private @FormParam("comp_name") String comp_name;
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
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
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	
	
}
