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
@Table(name = "AccountNumber")
public class AccountNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "accountNo", nullable = false)
	Long accountNo;

	@Column(name = "balance", nullable = false)
	Float balance;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "acc_no_id")
	List<Cheque> cheque;


	public AccountNumber() {

	}

	public AccountNumber(Long id, Long accountNo, Float balance) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountNumber [id=" + id + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}

}