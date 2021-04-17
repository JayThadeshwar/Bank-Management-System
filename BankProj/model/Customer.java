package model;

import java.sql.Date;

public class Customer {
	int id;
	String name;
	String email;
	String contact;
	Date dob;
	String password;

	public Customer() {}

	public Customer(String name, String email, String contact, Date dob, String password) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
