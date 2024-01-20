package com.hdfc.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cheque_table")
public class Cheque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "chequeNo", nullable = false)
	private Long chequeNo;
	@Column(name = "cheque_status", nullable = false)
	private String chequeStatus;
	@Column(name = "cheque_acc_no", nullable = false)
	private Long chequeAccNo;
	@Column(name = "paidTo")
	private String paidTo;
	@Column(name = "cheque_amount")
	private Double chequeAmount;
	@Column(name = "clearing_date")
	private LocalDate clearingDate;
	@Column(name = "cheque_quantities", nullable = false)
	private Integer chequeQuantity;

	public Cheque() {

	}

	public Cheque(Integer id, Long chequeNo, String chequeStatus, Long chequeAccNo, String paidTo, Double chequeAmount,
			LocalDate clearingDate, Integer chquueQuantities) {
		super();
		this.id = id;
		this.chequeNo = chequeNo;
		this.chequeStatus = chequeStatus;
		this.chequeAccNo = chequeAccNo;
		this.paidTo = paidTo;
		this.chequeAmount = chequeAmount;
		this.clearingDate = clearingDate;
		this.chequeQuantity = chequeQuantity; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	public Long getChequeAccNo() {
		return chequeAccNo;
	}

	public void setChequeAccNo(Long chequeAccNo) {
		this.chequeAccNo = chequeAccNo;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public Double getChequeAmount() {
		return chequeAmount;
	}

	public void setChequeAmount(Double chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	public LocalDate getClearingDate() {
		return clearingDate;
	}

	public void setClearingDate(LocalDate clearingDate) {
		this.clearingDate = clearingDate;
	}

	public Integer getChquueQuantities() {
		return chequeQuantity;
	}

	public void setChquueQuantities(Integer chequeQuantity) {
		this.chequeQuantity = chequeQuantity;
	}
 
	@Override
	public String toString() {
		return "Cheque [id=" + id + ", chequeNo=" + chequeNo + ", chequeStatus=" + chequeStatus + ", chequeAccNo="
				+ chequeAccNo + ", paidTo=" + paidTo + ", chequeAmount=" + chequeAmount + ", clearingDate="
				+ clearingDate + ", chquueQuantities=" + chequeQuantity + "]";
	}

}
