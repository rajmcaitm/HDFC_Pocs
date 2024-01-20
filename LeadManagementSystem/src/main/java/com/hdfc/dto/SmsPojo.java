package com.hdfc.dto;

public class SmsPojo {
	
	private String phoneNo;
	
		public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "SmsPojo [phoneNo=" + phoneNo + "]";
	}

	

}
