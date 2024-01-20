package com.hdfc.poc.bean;

import java.util.Map;

import lombok.Data;

@Data
public class CurrencyAPIResponse {

	private MetaData meta;
	
	private Map<String, ExchangeRate> data;

	public MetaData getMeta() {
		return meta;
	}

	public void setMeta(MetaData meta) {
		this.meta = meta;
	}

	public Map<String, ExchangeRate> getData() {
		return data;
	}

	public void setData(Map<String, ExchangeRate> data) {
		this.data = data;
	}

}
