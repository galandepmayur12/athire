package com.EHR.allContent.module;

import java.util.ArrayList;


public class AppliedJobs {
	private long job_id;
	private String job_title;
	private String job_desc;
	private long job_skill;
	private String status;
	private String assign_status;
	private Date date;
	private ArrayList<Long> ph_no;
	private String event_location;
	private String client_name;
	private int wage;
	private String work_environment;
	private long event_id;
	private long user_id;
	private String event_name;
	public long getJob_id() {
		return job_id;
	}
	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_desc() {
		return job_desc;
	}
	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}
	public long getJob_skill() {
		return job_skill;
	}
	public void setJob_skill(long job_skill) {
		this.job_skill = job_skill;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssign_status() {
		return assign_status;
	}
	public void setAssign_status(String assign_status) {
		this.assign_status = assign_status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Long> getPh_no() {
		return ph_no;
	}
	public void setPh_no(ArrayList<Long> ph_no) {
		this.ph_no = ph_no;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public String getWork_environment() {
		return work_environment;
	}
	public void setWork_environment(String work_environment) {
		this.work_environment = work_environment;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	@Override
	public String toString() {
		return "AppliedJobs [job_id=" + job_id + ", job_title=" + job_title + ", job_desc=" + job_desc + ", job_skill="
				+ job_skill + ", status=" + status + ", assign_status=" + assign_status + ", date=" + date + ", ph_no="
				+ ph_no + ", event_location=" + event_location + ", client_name=" + client_name + ", wage=" + wage
				+ ", work_environment=" + work_environment + ", event_id=" + event_id + ", user_id=" + user_id
				+ ", event_name=" + event_name + "]";
	}
	public AppliedJobs(long job_id, String job_title, String job_desc, long job_skill, String status,
			String assign_status, Date date, ArrayList<Long> ph_no, String event_location, String client_name, int wage,
			String work_environment, long event_id, long user_id, String event_name) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.job_desc = job_desc;
		this.job_skill = job_skill;
		this.status = status;
		this.assign_status = assign_status;
		this.date = date;
		this.ph_no = ph_no;
		this.event_location = event_location;
		this.client_name = client_name;
		this.wage = wage;
		this.work_environment = work_environment;
		this.event_id = event_id;
		this.user_id = user_id;
		this.event_name = event_name;
	}
	public AppliedJobs() {
		super();
	}

	
}
