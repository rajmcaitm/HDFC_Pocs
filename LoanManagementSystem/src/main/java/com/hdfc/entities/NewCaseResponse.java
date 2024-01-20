package com.hdfc.entities;

public class NewCaseResponse {
	
	


	String reffernceNumber;
	Long custId;
	String custName;
	String currencyType;
	Long loanAmount;
	String processingStatus;
	public String getReffernceNumber() {
		return reffernceNumber;
	}
	public void setReffernceNumber(String reffernceNumber) {
		this.reffernceNumber = reffernceNumber;
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
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getProcessingStatus() {
		return processingStatus;
	}
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}
	public NewCaseResponse() {}
	
	public NewCaseResponse(String reffernceNumber, Long custId, String custName, String currencyType, Long loanAmount,
			String processingStatus) {
		super();
		this.reffernceNumber = reffernceNumber;
		this.custId = custId;
		this.custName = custName;
		this.currencyType = currencyType;
		this.loanAmount = loanAmount;
		this.processingStatus = processingStatus;
	}

	@Override
	public String toString() {
		return "NewCaseResponse [reffernceNumber=" + reffernceNumber + ", custId=" + custId + ", custName=" + custName
				+ ", currencyType=" + currencyType + ", loanAmount=" + loanAmount + ", processingStatus="
				+ processingStatus + "]";
	}

	
}


