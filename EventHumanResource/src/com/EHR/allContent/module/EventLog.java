package com.EHR.allContent.module;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class EventLog {
	private long event_id;
	private long user_id;
	private String event_name;
	private String event_type;
	private String event_desc;
	private Date event_date;
	private String event_location;
	private String event_status;
	private String event_final;
	private Map<String, Integer> skill_needed;
	private int event_quote;
	
	
	public EventLog() {
		super();
	}
	

	@Override
	public String toString() {
		return "EventLog [event_id=" + event_id + ", user_id=" + user_id + ", event_name=" + event_name
				+ ", event_type=" + event_type + ", event_desc=" + event_desc + ", event_date=" + event_date
				+ ", event_location=" + event_location + ", event_status=" + event_status + ", event_final="
				+ event_final + ", skill_needed=" + skill_needed + ", event_quote=" + event_quote + "]";
	}


	public EventLog(long event_id, long user_id, String event_name, String event_type, String event_desc,
			Date event_date, String event_location, String event_status, String event_final,
			Map<String, Integer> skill_needed, int event_quote) {
		super();
		this.event_id = event_id;
		this.user_id = user_id;
		this.event_name = event_name;
		this.event_type = event_type;
		this.event_desc = event_desc;
		this.event_date = event_date;
		this.event_location = event_location;
		this.event_status = event_status;
		this.event_final = event_final;
		this.skill_needed = skill_needed;
		this.event_quote = event_quote;
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
	public String getEvent_desc() {
		return event_desc;
	}
	public void setEvent_desc(String event_desc) {
		this.event_desc = event_desc;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public String getEvent_status() {
		return event_status;
	}
	public void setEvent_status(String event_status) {
		this.event_status = event_status;
	}
	public String getEvent_final() {
		return event_final;
	}
	public void setEvent_final(String event_final) {
		this.event_final = event_final;
	}
	public Map<String, Integer> getSkill_needed() {
		return skill_needed;
	}
	public void setSkill_needed(Map<String, Integer> skill_needed) {
		this.skill_needed = skill_needed;
	}
	public int getEvent_quote() {
		return event_quote;
	}
	public void setEvent_quote(int event_quote) {
		this.event_quote = event_quote;
	}


	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	

}
