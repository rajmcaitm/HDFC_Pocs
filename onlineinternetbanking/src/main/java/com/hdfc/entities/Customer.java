package com.hdfc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customeraccount")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String repassword;
	private double amount;
	private String adderess;
	private Long phone;
	private Long accountNo;

	public Customer() {
	}

	public Customer(Long id, String username, String password, String repassword, double amount, String adderess,
			Long phone, Long accountNo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.amount = amount;
		this.adderess = adderess;
		this.phone = phone;
		this.accountNo = accountNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAdderess() {
		return adderess;
	}

	public void setAdderess(String adderess) {
		this.adderess = adderess;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", repassword=" + repassword
				+ ", amount=" + amount + ", adderess=" + adderess + ", phone=" + phone + ", accountNo=" + accountNo
				+ "]";
	}

}
