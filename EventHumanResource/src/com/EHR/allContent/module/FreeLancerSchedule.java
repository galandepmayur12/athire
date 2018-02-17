package com.EHR.allContent.module;

public class FreeLancerSchedule {
	
	private long freelancer_id;
	private long job_id;
	private Date slot;
	public FreeLancerSchedule() {
		super();
	}
	public FreeLancerSchedule(long freelancer_id, long job_id, Date slot) {
		super();
		this.freelancer_id = freelancer_id;
		this.job_id = job_id;
		this.slot = slot;
	}
	public long getFreelancer_id() {
		return freelancer_id;
	}
	public void setFreelancer_id(long freelancer_id) {
		this.freelancer_id = freelancer_id;
	}
	public long getJob_id() {
		return job_id;
	}
	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}
	public Date getSlot() {
		return slot;
	}
	public void setSlot(Date slot) {
		this.slot = slot;
	}
	
	

}
