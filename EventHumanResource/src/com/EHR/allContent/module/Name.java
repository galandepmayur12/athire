package com.EHR.allContent.module;

public class Name {
	private String f_name;
	private String m_name;
	private String l_name;
	public String getF_name() {
		return f_name;
	}
	
	public Name() {
		super();
	}

	public Name (String nm) {
		String[] str = nm.split(" ");
		setF_name(str[0]);
		setM_name(str[1]);
		setL_name(str[2]);
	}
	
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	@Override
	public String toString() {
		return  this.getF_name() + " " + this.getL_name() ;
	}
	
	
}
