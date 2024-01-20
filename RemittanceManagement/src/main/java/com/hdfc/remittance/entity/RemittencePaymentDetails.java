package com.hdfc.remittance.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "remitt_payment")
public class RemittencePaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fromAccount", nullable = false)
	private String fromAccount;
	@Column(name = "remittanceCurrency", nullable = false)
	private String remittanceCurrency;
	@Column(name = "currencyAmount", nullable = false)
	private Double currencyAmount;
	@Column(name = "remitterEmailId", nullable = false)
	private String remitterEmailId;
	@Column(name = "purpose", nullable = false)
	private String purpose;
	@Column(name = "sourceOfFund", nullable = false)
	private String sourceOfFund;
	@Column(name = "patientName")
	private String patientName;
	@Column(name = "invoiceNumber")
	private String invoiceNumber;
	@Column(name = "invoiceDate")
	private LocalDate invoiceDate;
	@Column(name = "travelDate")
	private LocalDate travelDate;
	@Column(name = "academicStartDate")
	private LocalDate academicStartDate;
	@Column(name = "conProUltiService")
	private String conProUltiService;
	@Column(name = "corresBankingCharge", nullable = false)
	private String corresBankingCharge;
	@Column(name = "refNo")
	private String refNo;

	public RemittencePaymentDetails() {
	}

	public RemittencePaymentDetails(Long id, String fromAccount, String remittanceCurrency, Double currencyAmount,
			String remitterEmailId, String purpose, String sourceOfFund, String patientName, String invoiceNumber,
			LocalDate invoiceDate, LocalDate travelDate, LocalDate academicStartDate, String conProUltiService,
			String corresBankingCharge, String refNo) {
		super();
		this.id = id;
		this.fromAccount = fromAccount;
		this.remittanceCurrency = remittanceCurrency;
		this.currencyAmount = currencyAmount;
		this.remitterEmailId = remitterEmailId;
		this.purpose = purpose;
		this.sourceOfFund = sourceOfFund;
		this.patientName = patientName;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.travelDate = travelDate;
		this.academicStartDate = academicStartDate;
		this.conProUltiService = conProUltiService;
		this.corresBankingCharge = corresBankingCharge;
		this.refNo = refNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getRemittanceCurrency() {
		return remittanceCurrency;
	}

	public void setRemittanceCurrency(String remittanceCurrency) {
		this.remittanceCurrency = remittanceCurrency;
	}

	public Double getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(Double currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	public String getRemitterEmailId() {
		return remitterEmailId;
	}

	public void setRemitterEmailId(String remitterEmailId) {
		this.remitterEmailId = remitterEmailId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSourceOfFund() {
		return sourceOfFund;
	}

	public void setSourceOfFund(String sourceOfFund) {
		this.sourceOfFund = sourceOfFund;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public LocalDate getAcademicStartDate() {
		return academicStartDate;
	}

	public void setAcademicStartDate(LocalDate academicStartDate) {
		this.academicStartDate = academicStartDate;
	}

	public String getConProUltiService() {
		return conProUltiService;
	}

	public void setConProUltiService(String conProUltiService) {
		this.conProUltiService = conProUltiService;
	}

	public String getCorresBankingCharge() {
		return corresBankingCharge;
	}

	public void setCorresBankingCharge(String corresBankingCharge) {
		this.corresBankingCharge = corresBankingCharge;
	}
	
	
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "RemittencePaymentDetails [id=" + id + ", fromAccount=" + fromAccount + ", remittanceCurrency="
				+ remittanceCurrency + ", currencyAmount=" + currencyAmount + ", remitterEmailId=" + remitterEmailId
				+ ", purpose=" + purpose + ", sourceOfFund=" + sourceOfFund + ", patientName=" + patientName
				+ ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", travelDate=" + travelDate
				+ ", academicStartDate=" + academicStartDate + ", conProUltiService=" + conProUltiService
				+ ", corresBankingCharge=" + corresBankingCharge + ", refNo=" + refNo + "]";
	}

	
}
