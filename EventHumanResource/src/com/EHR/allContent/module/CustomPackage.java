package com.EHR.allContent.module;

import java.util.Map;

public class CustomPackage {
	
	private long customid;
	private String event_name;
	private String event_type;
	private String event_desc;
	private Date event_date;
	private String event_location;
	private Map<SkillSet, Integer> skill_needed;
	private int event_quote;
	
	
	public CustomPackage() {
		super();
	}
	
	

	public CustomPackage(long customid, String event_name, String event_type, String event_desc, Date event_date,
			String event_location, Map<SkillSet, Integer> skill_needed, int event_quote) {
		super();
		this.customid = customid;
		this.event_name = event_name;
		this.event_type = event_type;
		this.event_desc = event_desc;
		this.event_date = event_date;
		this.event_location = event_location;
		this.skill_needed = skill_needed;
		this.event_quote = event_quote;
	}



	public long getCustomid() {
		return customid;
	}
	public void setCustomid(long customid) {
		this.customid = customid;
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
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public Map<SkillSet, Integer> getSkill_needed() {
		return skill_needed;
	}
	public void setSkill_needed(Map<SkillSet, Integer> skill_needed) {
		this.skill_needed = skill_needed;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}


	@Override
	public String toString() {
		return "CustomPackage [customid=" + customid + ", event_name=" + event_name + ", event_type=" + event_type
				+ ", event_desc=" + event_desc + ", event_date=" + event_date + ", event_location=" + event_location
				+ ", skill_needed=" + skill_needed + ", event_quote=" + event_quote + "]";
	}



	public int getEvent_quote() {
		return event_quote;
	}


	public void setEvent_quote(int event_quote) {
		this.event_quote = event_quote;
	}
	
	

}
