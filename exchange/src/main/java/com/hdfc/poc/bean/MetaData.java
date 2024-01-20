package com.hdfc.poc.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MetaData {

	@JsonProperty(value = "last_updated_at")
	private String lastUpdatedAt;

	public String getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(String lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	
	
}
