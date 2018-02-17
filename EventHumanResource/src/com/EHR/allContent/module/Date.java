package com.EHR.allContent.module;

public class Date {
	private int dd,mm,yyyy;

	@Override
	public String toString() {
		return  this.getYyyy() + "-" + this.getMm() + "-" + this.getDd();
	}


	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getYyyy() {
		return yyyy;
	}

	public void setYyyy(int yyyy) {
		this.yyyy = yyyy;
	}


	public Date(int dd, int mm, int yyyy) {
		super();
		this.dd = dd;
		this.mm = mm;
		this.yyyy = yyyy;
	}


	public Date() {
		super();
	}
	
	
}
