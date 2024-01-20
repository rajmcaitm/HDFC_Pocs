package com.hdfc.dto;

public class LoanDiscrepancyDetailsResponse {
	String dicripancyReason;
	String resolutionReason;
	String resolvedStatus;
	public LoanDiscrepancyDetailsResponse() {
		
	}
	public LoanDiscrepancyDetailsResponse(String dicripancyReason, String resolutionReason, String resolvedStatus) {
		super();
		this.dicripancyReason = dicripancyReason;
		this.resolutionReason = resolutionReason;
		this.resolvedStatus = resolvedStatus;
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
		return "LoanDiscrepancyDetailsResponse [dicripancyReason=" + dicripancyReason + ", resolutionReason="
				+ resolutionReason + ", resolvedStatus=" + resolvedStatus + "]";
	}

}
