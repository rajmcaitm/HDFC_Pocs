package com.hdfc.poc.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ExchangeRate {

	private String code;
	
	private double value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
