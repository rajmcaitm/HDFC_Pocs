package com.hdfc.entities;

public class AllDetailsResponse {
	
	Long custId;
	Long accNum;
	String custName;	
	String custAddr1;
	String custAddr2;
	String emailId;
	Long iec;
	String panNumber;
	Long mobileNo;
	Integer loanAmount;
	String currencyType;
	Integer creditScore;
	Float rateOfIntrest;
	Boolean documetsAttached;
	String intrestType;
	Integer loanTenure;
	String loanPurpose;
	String periodicityInstallment;
	String generalRemarks;
	String fileName;
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
	public String getCustAddr1() {
		return custAddr1;
	}
	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
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
	public Long getIec() {
		return iec;
	}
	public void setIec(Long iec) {
		this.iec = iec;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
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
	public Float getRateOfIntrest() {
		return rateOfIntrest;
	}
	public void setRateOfIntrest(Float rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}
	public Boolean getDocumetsAttached() {
		return documetsAttached;
	}
	public void setDocumetsAttached(Boolean documetsAttached) {
		this.documetsAttached = documetsAttached;
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
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getPeriodicityInstallment() {
		return periodicityInstallment;
	}
	public void setPeriodicityInstallment(String periodicityInstallment) {
		this.periodicityInstallment = periodicityInstallment;
	}
	public String getGeneralRemarks() {
		return generalRemarks;
	}
	public void setGeneralRemarks(String generalRemarks) {
		this.generalRemarks = generalRemarks;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getAccNum() {
		return accNum;
	}
	public void setAccNum(Long accNum) {
		this.accNum = accNum;
	}

	@Override
	public String toString() {
		return "AllDetailsResponse [custId=" + custId + ", accNum=" + accNum + ", custName=" + custName + ", custAddr1="
				+ custAddr1 + ", custAddr2=" + custAddr2 + ", emailId=" + emailId + ", iec=" + iec + ", panNumber="
				+ panNumber + ", mobileNo=" + mobileNo + ", loanAmount=" + loanAmount + ", currencyType=" + currencyType
				+ ", creditScore=" + creditScore + ", rateOfIntrest=" + rateOfIntrest + ", documetsAttached="
				+ documetsAttached + ", intrestType=" + intrestType + ", loanTenure=" + loanTenure + ", loanPurpose="
				+ loanPurpose + ", periodicityInstallment=" + periodicityInstallment + ", generalRemarks="
				+ generalRemarks + ", fileName=" + fileName + "]";
	}

}


