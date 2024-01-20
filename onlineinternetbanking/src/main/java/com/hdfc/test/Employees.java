package com.hdfc.test;

public class Employees {
	
	int id;
	
	String firstName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstName=" + firstName + "]";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Employees(int id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}
	
	

}
