package com.hdfc.dto;

public class CheckerCustomerDetails {

	private Long custId;
	private String custName;
	private Long accountNo;
	private String accName;
	private String custAddr1;
	private Long mobileNo;
	private String custAddr2;
	private String emailId;
	private String custAddr3;
	private String panNumber;
	private Double txAmount;
	private String currency;
	private String purposeCode;
	private String purposeDescription;
	private String equivalentTo;
	private Double rate;
	private Double paymentRate;
	private Double paymentAmount;
	private String paymentRemarks;
	
	public CheckerCustomerDetails() {
	}

	public CheckerCustomerDetails(Long custId, String custName, Long accountNo, String accName, String custAddr1,
			Long mobileNo, String custAddr2, String emailId, String custAddr3, String panNumber, Double txAmount,
			String currency, String purposeCode, String purposeDescription, String equivalentTo, Double rate,
			Double paymentRate, Double paymentAmount, String paymentRemarks) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.accountNo = accountNo;
		this.accName = accName;
		this.custAddr1 = custAddr1;
		this.mobileNo = mobileNo;
		this.custAddr2 = custAddr2;
		this.emailId = emailId;
		this.custAddr3 = custAddr3;
		this.panNumber = panNumber;
		this.txAmount = txAmount;
		this.currency = currency;
		this.purposeCode = purposeCode;
		this.purposeDescription = purposeDescription;
		this.equivalentTo = equivalentTo;
		this.rate = rate;
		this.paymentRate = paymentRate;
		this.paymentAmount = paymentAmount;
		this.paymentRemarks = paymentRemarks;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getCustAddr1() {
		return custAddr1;
	}

	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCustAddr2() {
		return custAddr2;
	}

	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustAddr3() {
		return custAddr3;
	}

	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Double getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(Double txAmount) {
		this.txAmount = txAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPurposeCode() {
		return purposeCode;
	}

	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	public String getPurposeDescription() {
		return purposeDescription;
	}

	public void setPurposeDescription(String purposeDescription) {
		this.purposeDescription = purposeDescription;
	}

	public String getEquivalentTo() {
		return equivalentTo;
	}

	public void setEquivalentTo(String equivalentTo) {
		this.equivalentTo = equivalentTo;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(Double paymentRate) {
		this.paymentRate = paymentRate;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentRemarks() {
		return paymentRemarks;
	}

	public void setPaymentRemarks(String paymentRemarks) {
		this.paymentRemarks = paymentRemarks;
	}

	@Override
	public String toString() {
		return "CheckerCustomerDetails [custId=" + custId + ", custName=" + custName + ", accountNo=" + accountNo
				+ ", accName=" + accName + ", custAddr1=" + custAddr1 + ", mobileNo=" + mobileNo + ", custAddr2="
				+ custAddr2 + ", emailId=" + emailId + ", custAddr3=" + custAddr3 + ", panNumber=" + panNumber
				+ ", txAmount=" + txAmount + ", currency=" + currency + ", purposeCode=" + purposeCode
				+ ", purposeDescription=" + purposeDescription + ", equivalentTo=" + equivalentTo + ", rate=" + rate
				+ ", paymentRate=" + paymentRate + ", paymentAmount=" + paymentAmount + ", paymentRemarks="
				+ paymentRemarks + "]";
	}

}
