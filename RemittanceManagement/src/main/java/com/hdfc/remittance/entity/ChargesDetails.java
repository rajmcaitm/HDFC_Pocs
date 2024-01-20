package com.hdfc.remittance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charges")
public class ChargesDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	Long id;
	@Column(name = "fcyAmount", nullable = false)
	Float fcyAmount;
	@Column(name = "exchangeRate", nullable = false)
	Float exchangeRate;
	@Column(name = "netInr", nullable = false)
	Float netInr;
	@Column(name = "swiftFee", nullable = false)
	Float swiftFee;
	@Column(name = "fxConCharges", nullable = false)
	Float fxConCharges;
	@Column(name = "processingFee", nullable = false)
	Float processingFee;
	@Column(name = "gstProcessingFee", nullable = false)
	Float gstProcessingFee;
	@Column(name = "gstOnSwift", nullable = false)
	Float gstOnSwift;
	@Column(name = "totalAmountInInr", nullable = false)
	Float totalAmountInInr;
	@Column(name = "tcs")
	Float tcs;
	@Column(name = "netTotal", nullable = false)
	Float netTotal;
	@Column(name = "netFcyAmount", nullable = false)
	Float netFcyAmount;
	@Column(name = "payeeAccNo")
	private Long payeeAccNo;
	
	
	public Float getNetFcyAmount() {
		return netFcyAmount;
	}

	public void setNetFcyAmount(Float netFcyAmount) {
		this.netFcyAmount = netFcyAmount;
	}

	public ChargesDetails() {
		
	}
	
	public ChargesDetails(Long id, Float fcyAmount, Float exchangeRate, Float netInr, Float swiftFee,
			Float fxConCharges, Float processingFee, Float gstProcessingFee, Float gstOnSwift, Float totalAmountInInr,
			Float tcs, Float netTotal, Float netFcyAmount, Long payeeAccNo) {
		super();
		this.id = id;
		this.fcyAmount = fcyAmount;
		this.exchangeRate = exchangeRate;
		this.netInr = netInr;
		this.swiftFee = swiftFee;
		this.fxConCharges = fxConCharges;
		this.processingFee = processingFee;
		this.gstProcessingFee = gstProcessingFee;
		this.gstOnSwift = gstOnSwift;
		this.totalAmountInInr = totalAmountInInr;
		this.tcs = tcs;
		this.netTotal = netTotal;
		this.netFcyAmount = netFcyAmount;
		this.payeeAccNo = payeeAccNo;
	}

	public Float getFcyAmount() {
		return fcyAmount;
	}
	public void setFcyAmount(Float fcyAmount) {
		this.fcyAmount = fcyAmount;
	}
	public Float getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public Float getNetInr() {
		return netInr;
	}
	public void setNetInr(Float netInr) {
		this.netInr = netInr;
	}
	public Float getSwiftFee() {
		return swiftFee;
	}
	public void setSwiftFee(Float swiftFee) {
		this.swiftFee = swiftFee;
	}
	public Float getFxConCharges() {
		return fxConCharges;
	}
	public void setFxConCharges(Float fxConCharges) {
		this.fxConCharges = fxConCharges;
	}
	public Float getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(Float processingFee) {
		this.processingFee = processingFee;
	}
	public Float getGstProcessingFee() {
		return gstProcessingFee;
	}
	public void setGstProcessingFee(Float gstProcessingFee) {
		this.gstProcessingFee = gstProcessingFee;
	}
	public Float getGstOnSwift() {
		return gstOnSwift;
	}
	public void setGstOnSwift(Float gstOnSwift) {
		this.gstOnSwift = gstOnSwift;
	}
	public Float getTotalAmountInInr() {
		return totalAmountInInr;
	}
	public void setTotalAmountInInr(Float totalAmountInInr) {
		this.totalAmountInInr = totalAmountInInr;
	}
	public Float getTcs() {
		return tcs;
	}
	public void setTcs(Float tcs) {
		this.tcs = tcs;
	}
	public Float getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(Float netTotal) {
		this.netTotal = netTotal;
	}
	
	public Long getPayeeAccNo() {
		return payeeAccNo;
	}

	public void setPayeeAccNo(Long payeeAccNo) {
		this.payeeAccNo = payeeAccNo;
	}

	@Override
	public String toString() {
		return "ChargesDetails [id=" + id + ", fcyAmount=" + fcyAmount + ", exchangeRate=" + exchangeRate + ", netInr="
				+ netInr + ", swiftFee=" + swiftFee + ", fxConCharges=" + fxConCharges + ", processingFee="
				+ processingFee + ", gstProcessingFee=" + gstProcessingFee + ", gstOnSwift=" + gstOnSwift
				+ ", totalAmountInInr=" + totalAmountInInr + ", tcs=" + tcs + ", netTotal=" + netTotal
				+ ", netFcyAmount=" + netFcyAmount + ", payeeAccNo=" + payeeAccNo + "]";
	}

	
}
