package com.EHR.allContent.module;

public class ApplyRecords {
	private long job_id;
	private long freelancer_id;
	private String username;
	private String time;
	private int bid;
	
	
	public ApplyRecords() {
		super();
	}
	
	public ApplyRecords(long job_id, long freelancer_id, String username, String time, int bid) {
		super();
		this.job_id = job_id;
		this.freelancer_id = freelancer_id;
		this.username = username;
		this.time = time;
		this.bid = bid;
	}

	public long getJob_id() {
		return job_id;
	}

	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}

	public long getFreelancer_id() {
		return freelancer_id;
	}

	public void setFreelancer_id(long freelancer_id) {
		this.freelancer_id = freelancer_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
