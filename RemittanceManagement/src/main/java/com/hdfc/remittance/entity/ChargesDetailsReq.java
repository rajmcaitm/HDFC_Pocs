package com.hdfc.remittance.entity;

public class ChargesDetailsReq {
	
	Float fcyAmount;
	Float exchangeRate;
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
	public ChargesDetailsReq(Float fcyAmount, Float exchangeRate) {
		super();
		this.fcyAmount = fcyAmount;
		this.exchangeRate = exchangeRate;
	}
	@Override
	public String toString() {
		return "ChargesDetailsReq [fcyAmount=" + fcyAmount + ", exchangeRate=" + exchangeRate + "]";
	}
	

}
