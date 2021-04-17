package model;

import java.sql.Date;

public class Account {
	String acNo;
	String name;
	String email;
	String contact;
	Date dob;
	String gender;
	String panNo;
	String aadharNo;
	String city;
	String area;
	String state;
	String pincode;
	double balance;
	
	public Account() {}
	
	public Account(String acNo, String name, String email, String contact, Date dob, String gender, String panNo,
			String aadharNo, String city, String area, String state, String pincode) {
		super();
		this.acNo = acNo;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
		this.gender = gender;
		this.panNo = panNo;
		this.aadharNo = aadharNo;
		this.city = city;
		this.area = area;
		this.state = state;
		this.pincode = pincode;
	}

	public String getAcNo() {
		return acNo;
	}

	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
		
}
