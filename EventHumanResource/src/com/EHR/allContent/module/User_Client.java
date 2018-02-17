package com.EHR.allContent.module;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User_Client {
	
	private long client_id;
	private Name client_name;
	private String email_id;
	private Date dob;
	private Address address;
	private ArrayList<Long> ph_no;
	private String comp_name;
	private String url;
	private String password;
	
	
	@Override
	public String toString() {
		return "User_Client [client_id=" + client_id + ", client_name=" + client_name + ", email_id=" + email_id
				+ ", dob=" + dob + ", address=" + address + ", ph_no=" + ph_no + ", comp_name=" + comp_name + "]";
	}
	public User_Client() {
		super();
	}
	public User_Client(long client_id, Name client_name, String email_id, Date dob, Address address,
			ArrayList<Long> ph_no, String comp_name) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.email_id = email_id;
		this.dob = dob;
		this.address = address;
		this.ph_no = ph_no;
		this.comp_name = comp_name;
	}
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
	public Name getClient_name() {
		return client_name;
	}
	public void setClient_name(Name client_name) {
		this.client_name = client_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public ArrayList<Long> getPh_no() {
		return ph_no;
	}
	public void setPh_no(ArrayList<Long> ph_no) {
		this.ph_no = ph_no;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public User_Client(String url) {
		super();
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
