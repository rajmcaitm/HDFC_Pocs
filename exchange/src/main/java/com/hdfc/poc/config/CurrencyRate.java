package com.hdfc.poc.config;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Currency_Rate")
public class CurrencyRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "currency")
	String currency;
	
	@Column(name = "rate")
	double rate;

	public CurrencyRate() {

	}

	public CurrencyRate(Long id, String currency, double rate) {
		super();
		this.id = id;
		this.currency = currency;
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "CurrencyRate [id=" + id + ", currency=" + currency + ", rate=" + rate + "]";
	}

}
