package com.hdfc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table  
public class Lead {
	
	@Id
	@GenericGenerator(name = "sequence_lead_id", strategy = "com.hdfc.entities.CustomLeadIdGenerator")
	@GeneratedValue(generator = "sequence_lead_id")
	private String id;
	private Long custId;
	private Long custMobileNo;
	private String custName;
	private String custEmailId;
	private Long custAccountNo;
	private String custLeadType;
	private String custLeadsubType;
	private Long custBranchId;
	private String custBranchName;
	private String processingStatus;
	
	
	public Lead() {
	}
	
	public Lead(String id, Long custId, Long custMobileNo, String custName, String custEmailId, Long custAccountNo,
			String custLeadType, String custLeadsubType, Long custBranchId, String custBranchName,
			String processingStatus) {
		super();
		this.id = id;
		this.custId = custId;
		this.custMobileNo = custMobileNo;
		this.custName = custName;
		this.custEmailId = custEmailId;
		this.custAccountNo = custAccountNo;
		this.custLeadType = custLeadType;
		this.custLeadsubType = custLeadsubType;
		this.custBranchId = custBranchId;
		this.custBranchName = custBranchName;
		this.processingStatus = processingStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(Long custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public Long getCustAccountNo() {
		return custAccountNo;
	}

	public void setCustAccountNo(Long custAccountNo) {
		this.custAccountNo = custAccountNo;
	}

	public String getCustLeadType() {
		return custLeadType;
	}

	public void setCustLeadType(String custLeadType) {
		this.custLeadType = custLeadType;
	}

	public String getCustLeadsubType() {
		return custLeadsubType;
	}

	public void setCustLeadsubType(String custLeadsubType) {
		this.custLeadsubType = custLeadsubType;
	}

	public Long getCustBranchId() {
		return custBranchId;
	}

	public void setCustBranchId(Long custBranchId) {
		this.custBranchId = custBranchId;
	}

	public String getCustBranchName() {
		return custBranchName;
	}

	public void setCustBranchName(String custBranchName) {
		this.custBranchName = custBranchName;
	}

	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	@Override
	public String toString() {
		return "Lead [id=" + id + ", custId=" + custId + ", custMobileNo=" + custMobileNo + ", custName=" + custName
				+ ", custEmailId=" + custEmailId + ", custAccountNo=" + custAccountNo + ", custLeadType=" + custLeadType
				+ ", custLeadsubType=" + custLeadsubType + ", custBranchId=" + custBranchId + ", custBranchName="
				+ custBranchName + ", processingStatus=" + processingStatus + "]";
	}

	
}
