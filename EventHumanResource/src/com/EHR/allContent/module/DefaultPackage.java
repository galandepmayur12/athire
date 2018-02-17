package com.EHR.allContent.module;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DefaultPackage {
	
	private long packageid;
	private String event_name;
	private String package_type;
	private String event_desc;
	private Map<String, Integer> skill_needed;
	private int package_quote;
	
	
	public DefaultPackage() {
		super();
	}
	

	public DefaultPackage(long packageid, String event_name, String package_type, String event_desc,
			Map<String, Integer> skill_needed, int package_quote) {
		super();
		this.packageid = packageid;
		this.event_name = event_name;
		this.package_type = package_type;
		this.event_desc = event_desc;
		this.skill_needed = skill_needed;
		this.package_quote = package_quote;
	}


	public long getPackageid() {
		return packageid;
	}
	public void setPackageid(long packageid) {
		this.packageid = packageid;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getPackage_type() {
		return package_type;
	}
	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}
	public String getEvent_desc() {
		return event_desc;
	}
	public void setEvent_desc(String event_desc) {
		this.event_desc = event_desc;
	}
	public Map<String, Integer> getSkill_needed() {
		return skill_needed;
	}
	public void setSkill_needed(Map<String, Integer> skill_needed) {
		this.skill_needed = skill_needed;
	}
	
	@Override
	public String toString() {
		return "DefaultPackage [packageid=" + packageid + ", event_name=" + event_name + ", package_type="
				+ package_type + ", event_desc=" + event_desc + ", skill_needed=" + skill_needed + ", package_quote="
				+ package_quote + "]";
	}


	public int getPackage_quote() {
		return package_quote;
	}
	public void setPackage_quote(int package_quote) {
		this.package_quote = package_quote;
	}
	
	

}
