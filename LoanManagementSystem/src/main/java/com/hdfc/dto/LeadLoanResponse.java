package com.hdfc.dto;

public class LeadLoanResponse {

    private String refNo;
    private long custId;
    private String custName;
    private Long loanAmount;
    private String currency;
    private String processingStatus;
    
    public LeadLoanResponse() {
          
    }
    
    public LeadLoanResponse(String refNo, long custId, String custName, Long loanAmount, String currency,
                 String processingStatus) {
          super();
          this.refNo = refNo;
          this.custId = custId;
          this.custName = custName;
          this.loanAmount = loanAmount;
          this.currency = currency;
          this.processingStatus = processingStatus;
    }
    public String getRefNo() {
          return refNo;
    }
    public void setRefNo(String refNo) {
          this.refNo = refNo;
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
    public Long getLoanAmount() {
          return loanAmount;
    }
    public void setLoanAmount(Long loanAmount) {
          this.loanAmount = loanAmount;
    }
    public String getCurrency() {
          return currency;
    }
    public void setCurrency(String currency) {
          this.currency = currency;
    }
    public String getProcessingStatus() {
          return processingStatus;
    }
    public void setProcessingStatus(String processingStatus) {
          this.processingStatus = processingStatus;
    }
    
    
    
}

