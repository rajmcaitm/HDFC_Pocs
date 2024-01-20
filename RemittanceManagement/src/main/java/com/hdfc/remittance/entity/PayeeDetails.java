package com.hdfc.remittance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "payee")

public class PayeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
	@Column(name = "accountNumber", nullable = false)
	Long accountNumber;
	@Column(name = "accountName", nullable = false)
	String accountName;
	@Column(name = "nickName", nullable = false)
	String nickName;
	@Column(name = "addressLine1", nullable = false)
	String addressLine1;
	@Column(name = "addressLine2", nullable = false)
	String addressLine2;
	@Column(name = "swiftCode", nullable = false)
	String swiftCode;
	@Column(name = "city", nullable = false)
	String city;
	@Column(name = "bankName", nullable = false)
	String	bankName;
	@Column(name = "country", nullable = false)
	String country;
	@Column(name = "iBan", nullable = false)
	String iBan;
	@Column(name = "custId", nullable = false)
	Long custId;
	@Column(name = "refNo", nullable = false)
	String refNo;
	@Transient
	@Column(name = "payeemobileno")
	private String payeeMobileNo;
	
	
	public PayeeDetails() {
		
	}
	
	public PayeeDetails(Long id, Long accountNumber, String accountName, String nickName, String addressLine1,
			String addressLine2, String swiftCode, String city, String bankName, String country, String iBan,
			Long custId, String refNo, String payeeMobileNo) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.nickName = nickName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.swiftCode = swiftCode;
		this.city = city;
		this.bankName = bankName;
		this.country = country;
		this.iBan = iBan;
		this.custId = custId;
		this.refNo = refNo;
		this.payeeMobileNo = payeeMobileNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getiBan() {
		return iBan;
	}

	public void setiBan(String iBan) {
		this.iBan = iBan;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getPayeeMobileNo() {
		return payeeMobileNo;
	}

	public void setPayeeMobileNo(String payeeMobileNo) {
		this.payeeMobileNo = payeeMobileNo;
	}

	@Override
	public String toString() {
		return "PayeeDetails [id=" + id + ", accountNumber=" + accountNumber + ", accountName=" + accountName
				+ ", nickName=" + nickName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", swiftCode=" + swiftCode + ", city=" + city + ", bankName=" + bankName + ", country=" + country
				+ ", iBan=" + iBan + ", custId=" + custId + ", refNo=" + refNo + ", payeeMobileNo=" + payeeMobileNo
				+ "]";
	}

}
