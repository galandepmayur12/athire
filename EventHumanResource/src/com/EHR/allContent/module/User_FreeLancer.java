package com.EHR.allContent.module;

import java.util.ArrayList;

public class User_FreeLancer {
	private long freeLancer_id;
	private Name freelancer_name;
	private String email_id;
	private Date dob;
	private Address address;
	private ArrayList<Long> ph_no;
	private ArrayList<SkillSet> skills;
	private String work_environment;
	private String url;
	private String password;
	
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User_FreeLancer(String url) {
		super();
		this.url = url;
	}

	public String getWork_environment() {
		return work_environment;
	}

	public void setWork_environment(String work_environment) {
		this.work_environment = work_environment;
	}

	public ArrayList<SkillSet> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<SkillSet> skills) {
		this.skills = skills;
	}
	
	public User_FreeLancer() {
		super();
	}

	public User_FreeLancer(long freeLancer_id, Name freelancer_name, String email_id, Date dob, Address address,
			ArrayList<Long> ph_no, ArrayList<SkillSet> skills, String work_environment) {
		super();
		this.freeLancer_id = freeLancer_id;
		this.freelancer_name = freelancer_name;
		this.email_id = email_id;
		this.dob = dob;
		this.address = address;
		this.ph_no = ph_no;
		this.skills = skills;
		this.work_environment = work_environment;
	}

	public long getFreeLancer_id() {
		return freeLancer_id;
	}
	public void setFreeLancer_id(long freeLancer_id) {
		this.freeLancer_id = freeLancer_id;
	}
	public Name getFreelancer_name() {
		return freelancer_name;
	}
	public void setFreelancer_name(Name freelancer_name) {
		this.freelancer_name = freelancer_name;
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
	public ArrayList<Long> getPh_no() {
		return ph_no;
	}
	public void setPh_no(ArrayList<Long> ph_no) {
		this.ph_no = ph_no;
	}

	@Override
	public String toString() {
		return "User_FreeLancer [freeLancer_id=" + freeLancer_id + ", freelancer_name=" + freelancer_name
				+ ", email_id=" + email_id + ", dob=" + dob + ", address=" + address + ", ph_no=" + ph_no + ", skills="
				+ skills + ", work_environment=" + work_environment + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
