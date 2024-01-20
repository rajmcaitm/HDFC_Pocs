package com.hdfc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_details")
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "loan_amount")
	Integer loanAmount;
	@Column(name = "currency_type")
	String currencyType;
	@Column(name = "credit_score")
	Integer creditScore;
	@Column(name = "custid")
	Long custId;
	@Column(name = "rate_of_intrest")
	Float rateOfIntrest;
	@Column(name = "documets_attached")
	Boolean documentsAttached;
	@Column(name = "intrest_type")
	String intrestType;
	@Column(name = "loan_tenure")
	Integer loanTenure;
	@Column(name = "loan_purpose")
	String purposeOfLoan;
	@Column(name = "periodicity_installment")
	String periodicityOfInstallment;
	@Column(name = "general_remarks")
	String generalRemarks;
	@Column(name = "reffernce_number")
	String refferenceNumber;
	@Column(name = "processing_status")
	String processingStatus;
	@Column(name = "dicripancy_reason")
	String dicripancyReason;
	@Column(name = "resolution_reason")
	String resolutionReason;
	@Column(name = "resolved_status")
	String resolvedStatus="NO";
	
	public LoanDetails() {
		
	}
	

	
	public LoanDetails(Long id, Integer loanAmount, String currencyType, Integer creditScore, Long custId,
			Float rateOfIntrest, Boolean documentsAttached, String intrestType, Integer loanTenure,
			String purposeOfLoan, String periodicityOfInstallment, String generalRemarks, String refferenceNumber,
			String processingStatus, String dicripancyReason, String resolutionReason, String resolvedStatus) {
		super();
		this.id = id;
		this.loanAmount = loanAmount;
		this.currencyType = currencyType;
		this.creditScore = creditScore;
		this.custId = custId;
		this.rateOfIntrest = rateOfIntrest;
		this.documentsAttached = documentsAttached;
		this.intrestType = intrestType;
		this.loanTenure = loanTenure;
		this.purposeOfLoan = purposeOfLoan;
		this.periodicityOfInstallment = periodicityOfInstallment;
		this.generalRemarks = generalRemarks;
		this.refferenceNumber = refferenceNumber;
		this.processingStatus = processingStatus;
		this.dicripancyReason = dicripancyReason;
		this.resolutionReason = resolutionReason;
		this.resolvedStatus = resolvedStatus;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public Float getRateOfIntrest() {
		return rateOfIntrest;
	}
	public void setRateOfIntrest(Float rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}
	public Boolean getDocumentsAttached() {
		return documentsAttached;
	}
	public void setDocumentsAttached(Boolean documentsAttached) {
		this.documentsAttached = documentsAttached;
	}
	public String getIntrestType() {
		return intrestType;
	}
	public void setIntrestType(String intrestType) {
		this.intrestType = intrestType;
	}
	public Integer getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}
	public String getPurposeOfLoan() {
		return purposeOfLoan;
	}
	public void setPurposeOfLoan(String purposeOfLoan) {
		this.purposeOfLoan = purposeOfLoan;
	}
	public String getPeriodicityOfInstallment() {
		return periodicityOfInstallment;
	}
	public void setPeriodicityOfInstallment(String periodicityOfInstallment) {
		this.periodicityOfInstallment = periodicityOfInstallment;
	}
	public String getGeneralRemarks() {
		return generalRemarks;
	}
	public void setGeneralRemarks(String generalRemarks) {
		this.generalRemarks = generalRemarks;
	}
	public String getRefferenceNumber() {
		return refferenceNumber;
	}
	public void setRefferenceNumber(String refferenceNumber) {
		this.refferenceNumber = refferenceNumber;
	}
	public String getProcessingStatus() {
		return processingStatus;
	}
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}
	public String getDicripancyReason() {
		return dicripancyReason;
	}
	public void setDicripancyReason(String dicripancyReason) {
		this.dicripancyReason = dicripancyReason;
	}
	
	public String getResolutionReason() {
		return resolutionReason;
	}

	public void setResolutionReason(String resolutionReason) {
		this.resolutionReason = resolutionReason;
	}

	public String getResolvedStatus() {
		return resolvedStatus;
	}

	public void setResolvedStatus(String resolvedStatus) {
		this.resolvedStatus = resolvedStatus;
	}

	@Override
	public String toString() {
		return "LoanDetails [id=" + id + ", loanAmount=" + loanAmount + ", currencyType=" + currencyType
				+ ", creditScore=" + creditScore + ", custId=" + custId + ", rateOfIntrest=" + rateOfIntrest
				+ ", documentsAttached=" + documentsAttached + ", intrestType=" + intrestType + ", loanTenure="
				+ loanTenure + ", purposeOfLoan=" + purposeOfLoan + ", periodicityOfInstallment="
				+ periodicityOfInstallment + ", generalRemarks=" + generalRemarks + ", refferenceNumber="
				+ refferenceNumber + ", processingStatus=" + processingStatus + ", dicripancyReason=" + dicripancyReason
				+ ", resolutionReason=" + resolutionReason + ", resolvedStatus=" + resolvedStatus + "]";
	}

	
	
	}

	
	


