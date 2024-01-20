package com.hdfc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SBAccount")
public class SBAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "customerName", nullable = false)
	String customerName;

	@Column(name = "customerMobileNo", nullable = false)
	Long customerMobileNo;

	@Column(name = "emailId", nullable = false)
	String emailId;

	@Column(name = "aadharNumber", nullable = false)
	Long aadharNumber;

	@Column(name = "panNumber", nullable = false)
	String panNumber;

	@Column(name = "address", nullable = false)
	String address;

	@Column(name = "city", nullable = false)
	String city;

	@Column(name = "pinCode", nullable = false)
	Integer pinCode;

	@Column(name = "profile", nullable = false)
	String profile;

	@Column(name = "refNo")
	Long refNo;

	public SBAccount() { 

	}

	public SBAccount(Long id, String customerName, Long customerMobileNo, String emailId, Long aadharNumber,
			String panNumber, String address, String city, Integer pinCode, String profile, Long refNo) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerMobileNo = customerMobileNo;
		this.emailId = emailId;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.profile = profile;
		this.refNo = refNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(Long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Long getRefNo() {
		return refNo;
	}

	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "SBAccount [id=" + id + ", customerName=" + customerName + ", customerMobileNo=" + customerMobileNo
				+ ", emailId=" + emailId + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", address="
				+ address + ", city=" + city + ", pinCode=" + pinCode + ", profile=" + profile + ", refNo=" + refNo
				+ "]";
	}

}
