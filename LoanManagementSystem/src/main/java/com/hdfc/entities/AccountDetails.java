package com.hdfc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Account_Details")
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;
	@Column(name = "custid")
	private Long custId;
	@Column(name = "acc_num")
	private Long accountNumber;
	@Column(name = "acc_name")
	private String accountName;
	@Column(name = "custAddr1")
	private String custAddr1;
	@Column(name = "custAddr2")
	private String custAddr2;
	@Column(name = "custAddr3")
	private String custAddr3;

	@Column(name = "MobileNo")
	private Long mobileNo;
	@Column(name = "EmailId")
	private String emailId;
	@Column(name = "IEC")
	private Long iec;
	@Column(name = "PanNumber")
	private String panNumber;
	@Column(name = "processing_status")
	String processingStatus;
	
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

	public String getCustAddr1() {
		return custAddr1;
	}

	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
	}

	public String getCustAddr2() {
		return custAddr2;
	}

	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}

	public String getCustAddr3() {
		return custAddr3;
	}

	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
    
	public Long getIec() {
		return iec;
	}

	public void setIec(Long iec) {
		this.iec = iec;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	
	/*
	 * @Override public String toString() { return "AccountDetails [id=" + id +
	 * ", accountNumber=" + accountNumber + ", accountName=" + accountName +
	 * ", custAddr1=" + custAddr1 + ", custAddr2=" + custAddr2 + ", custAddr3=" +
	 * custAddr3 + ", mobileNo=" + mobileNo + ", emailId=" + emailId +
	 * ", panNumber=" + panNumber + "]"; }
	 */

}