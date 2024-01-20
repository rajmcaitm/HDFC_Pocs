package com.hdfc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerTable")
public class CustomerTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "name")
	String customerName;
	@Column(name = "custId", nullable = false)
	Long custId;
	@Column(name = "phoneNumber", nullable = false)
	Long phoneNumber;
	@Column(name = "address", nullable = false)
	String address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	List<AccountNumber> accountNumber;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id") 
	List<DebitCard> customerId;
	
	public CustomerTable() { 

	}

	public CustomerTable(Long id, String customerName, Long custId, Long phoneNumber, String address,
			List<AccountNumber> accountNumber) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.custId = custId;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNumber = accountNumber;
	}

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AccountNumber> getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(List<AccountNumber> accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName; 
	}

	@Override
	public String toString() {
		return "CustomerTable [id=" + id + ", customerName=" + customerName + ", custId=" + custId + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", accountNumber=" + accountNumber + "]";
	}

}