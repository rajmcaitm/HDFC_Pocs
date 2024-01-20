package com.hdfc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	// @JoinColumn(name = "account", referencedColumnName = "id")
	private long custId;
	private String custName;
	@Column(name = "processing_status")
	String processingStatus;
	@ManyToOne
	@JoinColumn(name = "acc_id", referencedColumnName = "id")
	private AccountDetails id;

	public Customer() {

	}

	public Customer(long custId, String custName, AccountDetails acc_id) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.id = acc_id;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public AccountDetails getAcc_id() {
		return id;
	}

	public void setAcc_id(AccountDetails acc_id) {
		this.id = acc_id;
	}

	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", acc_id=" + id
				+ "]";
	}

	

}
