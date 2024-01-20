package com.hdfc.remittance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	@Column(name = "custId", nullable = false)
	Long custId;
	@Column(name = "currencyType", nullable = false)
	String currencyType;
	@Column(name = "accNo", nullable = false)
	String accNo;
	@Column(name = "balance", nullable = false)
	Long balance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	public AccountDetails() {
		
	}
	public AccountDetails(Long id, Long custId, String currencyType, String accNo, Long balance) {
		super();
		this.id = id;
		this.custId = custId;
		this.currencyType = currencyType;
		this.accNo = accNo;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", custId=" + custId + ", currencyType=" + currencyType + ", accNo=" + accNo
				+ ", balance=" + balance + "]";
	}
	

	

}
