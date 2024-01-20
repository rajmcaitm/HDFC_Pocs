package com.hdfc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DebitCard")
public class DebitCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	@Column(name = "debitCardNo", nullable = false)
	private String debitCardNo;
	@Column(name = "pinNumber", nullable = false)
	private Integer pinNumber;
	@Column(name = "cvv", nullable = false)
	private Integer cvv;
	@Column(name = "expiryMonth")
	private Integer expiryMonth;
	@Column(name = "expiryYear")
	private Integer expiryYear;

	public DebitCard() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDebitCardNo() {
		return debitCardNo;
	}

	public void setDebitCardNo(String debitCardNo) {
		this.debitCardNo = debitCardNo;
	}

	public Integer getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(Integer pinNumber) {
		this.pinNumber = pinNumber;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	public DebitCard(Long id, String debitCardNo, Integer pinNumber, Integer cvv, Integer expiryMonth,
			Integer expiryYear, Integer custId) {
		super();
		this.id = id;
		this.debitCardNo = debitCardNo;
		this.pinNumber = pinNumber;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		
	}

	@Override
	public String toString() {
		return "DebitCard [id=" + id + ", debitCardNo=" + debitCardNo + ", pinNumber=" + pinNumber + ", cvv=" + cvv
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + "]";
	}

}
