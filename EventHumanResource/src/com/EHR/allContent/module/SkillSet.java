package com.EHR.allContent.module;

public class SkillSet {
	private long skill_id;
	private String skill_name;
	private int skill_cost;
	public long getSkill_id() {
		return skill_id;
	}
	public void setSkil_id(long skil_id) {
		this.skill_id = skil_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	
	@Override
	public String toString() {
		return "SkillSet [skill_id=" + skill_id + ", skill_name=" + skill_name + ", skill_cost=" + skill_cost + "]";
	}
	
	public void setSkill_id(long skill_id) {
		this.skill_id = skill_id;
	}
	public SkillSet() {
		super();
	}
	public SkillSet(long skill_id, String skill_name, int skill_cost) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
		this.skill_cost = skill_cost;
	}
	public int getSkill_cost() {
		return skill_cost;
	}
	public void setSkill_cost(int skill_cost) {
		this.skill_cost = skill_cost;
	}
	
	
}
