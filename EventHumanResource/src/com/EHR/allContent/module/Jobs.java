package com.EHR.allContent.module;

public class Jobs {
	
	private long job_id;
	private String job_title;
	private String job_desc;
	private long job_skill;
	private String status;
	private String assign_status;
	private Date date;
	private long client_id;
	private long freelancer_id;
	private int wage;
	private long event_id;
	private String work_environment;
	
	
	public Jobs() {
		super();
	}
	

	public Jobs(long job_id, String job_title, String job_desc, long job_skill, String status, String assign_status,
			Date date, long client_id, long freelancer_id, int wage, long event_id, String work_environment) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.job_desc = job_desc;
		this.job_skill = job_skill;
		this.status = status;
		this.assign_status = assign_status;
		this.date = date;
		this.client_id = client_id;
		this.freelancer_id = freelancer_id;
		this.wage = wage;
		this.event_id = event_id;
		this.work_environment = work_environment;
	}

	

	@Override
	public String toString() {
		return "Jobs [job_id=" + job_id + ", job_title=" + job_title + ", job_desc=" + job_desc + ", job_skill="
				+ job_skill + ", status=" + status + ", assign_status=" + assign_status + ", date=" + date
				+ ", client_id=" + client_id + ", freelancer_id=" + freelancer_id + ", wage=" + wage + ", event_id="
				+ event_id + ", work_environment=" + work_environment + "]";
	}


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
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
	public long getFreelancer_id() {
		return freelancer_id;
	}
	public void setFreelancer_id(long freelancer_id) {
		this.freelancer_id = freelancer_id;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public long getJob_skill() {
		return job_skill;
	}
	public void setJob_skill(long job_skill) {
		this.job_skill = job_skill;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}


	public String getWork_environment() {
		return work_environment;
	}


	public void setWork_environment(String work_environment) {
		this.work_environment = work_environment;
	}
	
	

}
