package com.EHR.allContent.module;

public class Address {
	private String add_line1;
	private String add_line2;
	private String street_name;
	private String city;
	private String  state;
	public Address(String add_line1, String add_line2, String street_name, String city, String state, String country,
			int zipcode) {
		super();
		this.add_line1 = add_line1;
		this.add_line2 = add_line2;
		this.street_name = street_name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	private String country;
	private int zipcode;
	public String getAdd_line1() {
		return add_line1;
	}
	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}
	public String getAdd_line2() {
		return add_line2;
	}
	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return this.getAdd_line1() + "," + this.getAdd_line2() + "," + this.getStreet_name() + "," + this.getCity() + "," + 
				this.getState() + "," + this.getCountry() + "," + this.getZipcode();
	}
	
}
