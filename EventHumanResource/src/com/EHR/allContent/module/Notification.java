package com.EHR.allContent.module;

public class Notification {
	
	private long notification_id;
	private long user_id;
	private String notification_desc;
	private long notification_ref_id;
	private String notification_status;
	
	public Notification() {
		super();
	}

	public Notification(long notification_id, long user_id, String notification_desc, long notification_ref_id,
			String notification_status) {
		super();
		this.notification_id = notification_id;
		this.user_id = user_id;
		this.notification_desc = notification_desc;
		this.notification_ref_id = notification_ref_id;
		this.notification_status = notification_status;
	}

	public long getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(long notification_id) {
		this.notification_id = notification_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getNotification_desc() {
		return notification_desc;
	}

	public void setNotification_desc(String notification_desc) {
		this.notification_desc = notification_desc;
	}

	public long getNotification_ref_id() {
		return notification_ref_id;
	}

	public void setNotification_ref_id(long notification_ref_id) {
		this.notification_ref_id = notification_ref_id;
	}

	public String getNotification_status() {
		return notification_status;
	}

	public void setNotification_status(String notification_status) {
		this.notification_status = notification_status;
	}

	@Override
	public String toString() {
		return "Notification [notification_id=" + notification_id + ", user_id=" + user_id + ", notification_desc="
				+ notification_desc + ", notification_ref_id=" + notification_ref_id + ", notification_status="
				+ notification_status + "]";
	}
	
	
	
}
